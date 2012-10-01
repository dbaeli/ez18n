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


import com.swabunga.spell.event.CapitalizedWordFinder;
import com.swabunga.spell.event.SpellCheckEvent;
import com.swabunga.spell.event.SpellCheckListener;
import com.swabunga.spell.event.StringWordTokenizer;
import org.apache.commons.io.IOUtils;
import org.ez18n.Message;
import org.ez18n.MessageBundle;
import org.ez18n.apt.TemplateLoader;
import org.spell6r.Spell6rChecker;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

import static javax.lang.model.SourceVersion.RELEASE_6;

/**
 * Generates Spell6r checker through JUnit tests
 */
@SupportedAnnotationTypes(value = "org.ez18n.MessageBundle")
@SupportedSourceVersion(RELEASE_6)
public class Spell6rTestMobileBundleProcessor extends TestMobileBundleProcessor {

  public Spell6rTestMobileBundleProcessor() {
    super();
		try {
			template = TemplateLoader.load("Spell6rTestBundle.template");
			methodTemplate = TemplateLoader.load("Spell6rTestBundleMethod.template");
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
  }

}