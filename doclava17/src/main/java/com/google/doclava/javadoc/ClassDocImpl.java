/*
 * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.google.doclava.javadoc;

import com.sun.javadoc.AnnotatedType;
import com.sun.javadoc.AnnotationTypeDoc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.ConstructorDoc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.ParamTag;
import com.sun.javadoc.ParameterizedType;
import com.sun.javadoc.Type;
import com.sun.javadoc.TypeVariable;
import com.sun.javadoc.WildcardType;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;

class ClassDocImpl extends ProgramElementDocImpl<TypeElement> implements ClassDoc {

    protected final TypeElement typeElement;

    protected ClassDocImpl(TypeElement c, Context context) {
        super(c, context);
        typeElement = c;

        if (c.getKind().isInterface()) {
            reflectModifiers |= java.lang.reflect.Modifier.INTERFACE;
        }
    }

    static ClassDocImpl create(TypeElement e, Context context) {
        return context.caches.classes.computeIfAbsent(e, el -> new ClassDocImpl(el, context));
    }

    private Boolean isClass;

    @Override
    public boolean isClass() {
        if (isClass == null) {
            isClass = typeElement.getKind().isClass();
        }
        return isClass;
    }

    private Boolean isOrdinaryClass;

    @Override
    public boolean isOrdinaryClass() {
        if (isOrdinaryClass == null) {
            isOrdinaryClass = (!isEnum() &&
                    !isInterface() &&
                    !isAnnotationType() &&
                    !isError() &&
                    !isException()
            );
        }
        return isOrdinaryClass;
    }

    private Boolean isEnum;

    @Override
    public boolean isEnum() {
        if (isEnum == null) {
            isEnum = (typeElement.getKind() == ElementKind.ENUM);
        }
        return isEnum;
    }

    private Boolean isInterface;

    @Override
    public boolean isInterface() {
        if (isInterface == null) {
            isInterface = (typeElement.getKind() == ElementKind.INTERFACE);
        }
        return isInterface;
    }

    private Boolean isException;

    @Override
    public boolean isException() {
        if (isException == null) {
            isException = context.docletElementUtils.isException(typeElement);
        }
        return isException;
    }

    private Boolean isError;

    @Override
    public boolean isError() {
        if (isError == null) {
            isError = context.docletElementUtils.isError(typeElement);
        }
        return isError;
    }

    @Override
    public String name() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public String qualifiedName() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public boolean isIncluded() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public boolean isAbstract() {
        return java.lang.reflect.Modifier.isAbstract(reflectModifiers);
    }

    @Override
    public boolean isSerializable() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public boolean isExternalizable() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public MethodDoc[] serializationMethods() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public FieldDoc[] serializableFields() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public boolean definesSerializableFields() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public ClassDoc superclass() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public Type superclassType() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public boolean subclassOf(ClassDoc cd) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public ClassDoc[] interfaces() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public Type[] interfaceTypes() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public TypeVariable[] typeParameters() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public ParamTag[] typeParamTags() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public FieldDoc[] fields() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public FieldDoc[] fields(boolean filter) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public FieldDoc[] enumConstants() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public MethodDoc[] methods() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public MethodDoc[] methods(boolean filter) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public ConstructorDoc[] constructors() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public ConstructorDoc[] constructors(boolean filter) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public ClassDoc[] innerClasses() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public ClassDoc[] innerClasses(boolean filter) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public ClassDoc findClass(String className) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public ClassDoc[] importedClasses() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public PackageDoc[] importedPackages() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public String typeName() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public String qualifiedTypeName() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public String simpleTypeName() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public String dimension() {
        return "";
    }

    @Override
    public boolean isPrimitive() {
        return false;
    }

    @Override
    public ClassDoc asClassDoc() {
        return this;
    }

    @Override
    public ParameterizedType asParameterizedType() {
        return null;
    }

    @Override
    public TypeVariable asTypeVariable() {
        return null;
    }

    @Override
    public WildcardType asWildcardType() {
        return null;
    }

    @Override
    public AnnotatedType asAnnotatedType() {
        return null;
    }

    @Override
    public AnnotationTypeDoc asAnnotationTypeDoc() {
        return null;
    }

    @Override
    public Type getElementType() {
        return null;
    }
}
