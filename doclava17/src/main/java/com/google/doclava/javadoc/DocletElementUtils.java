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
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import jdk.javadoc.doclet.DocletEnvironment;

class DocletElementUtils {

    private final DocletEnvironment env;
    private final Types typeUtils;
    private final Elements elementUtils;

    private final TypeMirror exceptionType;
    private final TypeMirror errorType;
    private final TypeMirror throwableType;

    private DocletElementUtils() {
        throw new UnsupportedOperationException("Hide default constructor.");
    }

    public DocletElementUtils(DocletEnvironment e) {
        this.env = e;
        this.typeUtils = e.getTypeUtils();
        this.elementUtils = e.getElementUtils();

        this.exceptionType = getTypeByName("java.lang.Exception");
        this.errorType = getTypeByName("java.lang.Error");
        this.throwableType = getTypeByName("java.lang.Throwable");
    }

    public boolean isException(Element e) {
        if (!isClass(e)) {
            return false;
        }
        return typeUtils.isSubtype(e.asType(), exceptionType);
    }

    public boolean isError(Element e) {
        if (!isClass(e)) {
            return false;
        }
        return typeUtils.isSubtype(e.asType(), errorType);
    }

    public boolean isThrowable(Element e) {
        if (!isClass(e)) {
            return false;
        }
        return typeUtils.isSubtype(e.asType(), throwableType);
    }

    public boolean isAnnotation(Element e) {
        return e.getKind() == ElementKind.ANNOTATION_TYPE;
    }

    public boolean isEnum(Element e) {
        return e.getKind() == ElementKind.ENUM;
    }

    public boolean isInterface(Element e) {
        return e.getKind() == ElementKind.INTERFACE;
    }

    public boolean isClass(Element e) {
        return e.getKind() == ElementKind.CLASS;
    }

    public boolean isPackage(Element e) {
        return e.getKind() == ElementKind.PACKAGE;
    }

    private final HashMap<String, TypeMirror> typeMirrorsCache = new HashMap<>();

    public TypeMirror getTypeByName(String name) {
        TypeMirror mirror = typeMirrorsCache.get(name);
        if (mirror != null) {
            return mirror;
        }
        TypeElement e = elementUtils.getTypeElement(name);
        if (e == null || (mirror = e.asType()) == null) {
            return null;
        }
        typeMirrorsCache.put(name, mirror);
        return mirror;
    }
}
