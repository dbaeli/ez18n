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
import org.spell6r.Spell6rChecker;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

import static javax.lang.model.SourceVersion.RELEASE_6;

@SupportedAnnotationTypes(value = "org.ez18n.MessageBundle")
@SupportedSourceVersion(RELEASE_6)
public class Spell6rMessagesProcessorImpl extends AbstractProcessor {

  Spell6rChecker spell = null;

  public Spell6rMessagesProcessorImpl() {
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

    for (Element element : roundEnv.getElementsAnnotatedWith(MessageBundle.class)) {
      if (element.getKind() != ElementKind.INTERFACE) {
        continue;
      }

      final TypeElement bundleType = (TypeElement) element;
      for (Element subElement : bundleType.getEnclosedElements()) {
        if (subElement.getKind() != ElementKind.METHOD) {
          continue;
        }
        final ExecutableElement method = (ExecutableElement) subElement;

        Message labelAnnotation = subElement.getAnnotation(Message.class);

        spell.setCurrentSource(bundleType.getQualifiedName() + "#" + method.getSimpleName());
        final String desktopText = labelAnnotation.value();
        spell.checkSpelling(desktopText, false);

        spell.setCurrentSource(bundleType.getQualifiedName() + "#" + method.getSimpleName() + " (Mobile)");
        final String mobileText = labelAnnotation.mobile();
        spell.checkSpelling(mobileText, false);
      }
    }
    return false;
  }

}