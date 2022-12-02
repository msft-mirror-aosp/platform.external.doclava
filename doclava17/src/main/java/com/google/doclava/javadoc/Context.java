/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.doclava.javadoc;

import java.util.HashMap;
import java.util.Map;
import javax.lang.model.element.TypeElement;
import jdk.javadoc.doclet.DocletEnvironment;

/**
 * Holds temporary objects required to construct {@link RootDocImpl} from a
 * {@link jdk.javadoc.doclet.DocletEnvironment}.
 */
class Context {
    public final DocletEnvironment environment;
    public final Caches caches = new Caches();

    public static class Caches {
        public final Map<TypeElement, ClassDocImpl> classes = new HashMap<>();
        public final Map<TypeElement, AnnotationTypeDocImpl> annotations = new HashMap<>();
    }

    public Context(DocletEnvironment environment) {
        this.environment = environment;
    }
}
