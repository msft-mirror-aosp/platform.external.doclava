/*
 * Copyright (C) 2022 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.stubdoclet;

import com.sun.tools.javac.util.Log;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.lang.model.SourceVersion;

import jdk.javadoc.doclet.Doclet;
import jdk.javadoc.doclet.DocletEnvironment;
import jdk.javadoc.doclet.Reporter;
import jdk.javadoc.internal.doclets.formats.html.HtmlDoclet;

/**
 * Stub doclet implementation which supports the same arguments and tags that Doclava.
 *
 * This is to be used with JDK 17 until b/240421555 is fixed.
 */
public class StubDoclet implements Doclet {

  Reporter reporter;
  private final HtmlDoclet htmlDoclet;

  public StubDoclet() {
    htmlDoclet = new HtmlDoclet(this);
  }

  @Override
  public String getName() {
    return "StubDoclet";
  }

  @Override
  public SourceVersion getSupportedSourceVersion() {
    // support the latest release
    return SourceVersion.latest();
  }

  @Override
  public void init(Locale locale, Reporter reporter) {
    this.reporter = reporter;
    htmlDoclet.init(locale, reporter);
  }

  @Override
  public boolean run(DocletEnvironment docEnv) {
    try {
      htmlDoclet.run(docEnv);
    } catch (Throwable t) {
    }
    ((Log)reporter).nerrors = 0;
    return true;
  }

  @Override
  public Set<? extends Option> getSupportedOptions() {
    Set<Option> options = new HashSet<>(htmlDoclet.getSupportedOptions());

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-templatedir");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<path>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-hdf");
        @Override public int          getArgumentCount() { return 2; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<arg1> <arg2>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-knowntags");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<tags>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-apidocsdir");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<path>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-toroot");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<arg1>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-samplecode");
        @Override public int          getArgumentCount() { return 3; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<arg1> <arg2> <arg3>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-samplegroup");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<group>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-samplesdir");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<path>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-htmldir");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<path>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-htmldir2");
        @Override public int          getArgumentCount() { return 2; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<input_path> <output_path>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-resourcesdir");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<path>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-resourcesoutdir");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<path>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-title");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<title>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-werror");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-lerror");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-error");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<code_value>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-warning");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<code_value>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-lint");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<code_value>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-hide");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<code_value>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-keeplist");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<list>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-showUnannotated");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-showAnnotation");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<annotation>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-hideAnnotation");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<annotation>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-showAnnotationOverridesVisibility");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-hidePackage");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<package>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-proguard");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<arg>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-proofread");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<arg>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-todo");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<file>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-public");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-protected");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-package");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-private");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-hidden");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-stubs");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<stubs>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-stubpackages");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<packages>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-stubimportpackages");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<packages>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-stubsourceonly");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-keepstubcomments");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-sdkvalues");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<path>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-api");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<file>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-dexApi");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<file>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-removedApi");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<file>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-removedDexApi");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<file>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-exactApi");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<file>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-privateApi");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<file>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-privateDexApi");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<file>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-apiMapping");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<file>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-nodocs");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-noassets");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-nodefaultassets");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-parsecomments");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-metalavaApiSince");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-since");
        @Override public int          getArgumentCount() { return 2; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<major> <minor>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-artifact");
        @Override public int          getArgumentCount() { return 2; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<arg1> <arg2>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-offlinemode");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-metadataDebug");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-includePreview");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-ignoreJdLinks");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-federate");
        @Override public int          getArgumentCount() { return 2; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<name> <URL>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-federationapi");
        @Override public int          getArgumentCount() { return 2; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<name> <file>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-gmsref");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-gcmref");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-yaml");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<file>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-dac_libraryroot");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<library_root>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-dac_dataname");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<data_name>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-documentannotations");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<path>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-referenceonly");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-staticonly");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-navtreeonly");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-atLinksNavtree");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-yamlV2");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-devsite");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-android");
        @Override public int          getArgumentCount() { return 0; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return ""; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-manifest");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<file>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    options.add(
        new Option() {
        private final List<String> names = Arrays.asList("-compatconfig");
        @Override public int          getArgumentCount() { return 1; }
        @Override public String       getDescription() { return ""; }
        @Override public Option.Kind  getKind() { return Option.Kind.STANDARD; }
        @Override public List<String> getNames() { return names; }
        @Override public String       getParameters() { return "<config>"; }
        @Override public boolean      process(String opt, List<String> arguments) { return true; }
        }
    );

    return options;
  }
}
