/**
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements. See the NOTICE
 * file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.ez18n.apt.processor;


import com.swabunga.spell.event.SpellCheckEvent;
import com.swabunga.spell.event.SpellCheckListener;
import org.ez18n.Message;
import org.ez18n.MessageBundle;
import org.ez18n.apt.LabelTemplateMethod;
import org.ez18n.apt.base.TemplateAnnotation;
import org.ez18n.apt.base.TemplateParam;
import org.spell6r.Spell6rChecker;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.element.*;
import javax.tools.Diagnostic;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static javax.lang.model.SourceVersion.RELEASE_6;

@SupportedAnnotationTypes(value = "org.ez18n.MessageBundle")
@SupportedSourceVersion(RELEASE_6)
public class Spell6rMessagesProcessor extends AbstractProcessor {

  Spell6rChecker spell = null;

  public Spell6rMessagesProcessor() {
    final String languages = System.getProperty("spell6r.languages", "en_US");
    log(Diagnostic.Kind.WARNING, "SPELLCHECK Languages = " + languages);
    final String[] values = languages != null ? languages.split(",") : null;

    spell = new Spell6rChecker(values);
    spell.addSpellCheckListener(new SpellCheckListener() {
      @Override
      public void spellingError(SpellCheckEvent spellCheckEvent) {
        log(Diagnostic.Kind.WARNING, "SPELLCHECK ERROR in " + spell.getCurrentSource() + " : " + spellCheckEvent.getInvalidWord());
      }
    });
  }

  private void log(Diagnostic.Kind kind, String message) {
    log(kind, message, null);
  }

  private void log(Diagnostic.Kind kind, String message, Element element) {
    if (processingEnv != null && processingEnv.getMessager() != null) {
      processingEnv.getMessager().printMessage(kind, message, element);
    } else {
      System.out.println("" + kind + " : " + message);
    }

  }

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

    if (roundEnv.processingOver()) {
      return true;
    }

    final List<LabelTemplateMethod> methods = new ArrayList<LabelTemplateMethod>();
    for (Element element : roundEnv.getElementsAnnotatedWith(MessageBundle.class)) {
      if (element.getKind() != ElementKind.INTERFACE) {
        continue;
      }
      final TypeElement bundleType = (TypeElement) element;
      processMessages(bundleType, methods);
    }
    return false;
  }

  private void processMessages(TypeElement bundleType, List<LabelTemplateMethod> methods) {
    for (Element element : bundleType.getEnclosedElements()) {
      if (element.getKind() != ElementKind.METHOD) {
        continue;
      }
      final ExecutableElement method = (ExecutableElement) element;
      Message labelAnnotation = element.getAnnotation(Message.class);
      final TemplateParam returnType = new TemplateParam(method.getReturnType().toString());
      final boolean deprecated = method.getAnnotation(Deprecated.class) != null;
      final LabelTemplateMethod labelMethod;
      try {
        labelMethod = new LabelTemplateMethod(method.getSimpleName().toString(), deprecated, returnType,
            labelAnnotation.value(), labelAnnotation.mobile());
      } catch (Throwable t) {
        log(Diagnostic.Kind.WARNING, t.getMessage(), bundleType);
        continue;
      }

      for (VariableElement variable : method.getParameters()) {
        final String paramName = variable.getSimpleName().toString();
        final String paramType = variable.asType().toString();

        List<TemplateAnnotation> annotations = new ArrayList<TemplateAnnotation>();
        for (AnnotationMirror annotationMirrors : variable.getAnnotationMirrors()) {
          annotations.add(new TemplateAnnotation(annotationMirrors.getAnnotationType().toString()));
        }

        labelMethod.getParams().add(new TemplateParam(paramType, paramName, annotations));
      }
      checkTemplateMethod(bundleType, labelMethod);
      methods.add(labelMethod);
    }
  }

  protected void checkTemplateMethod(final TypeElement bundleType, LabelTemplateMethod method) {

    spell.setCurrentSource(bundleType.getSimpleName() + "-" + method.getName());
    final String desktopText = method.getBase();
    spell.checkSpelling(desktopText, false);
    final String mobileText = method.getMobile();
    spell.checkSpelling(mobileText, false);

  }

}