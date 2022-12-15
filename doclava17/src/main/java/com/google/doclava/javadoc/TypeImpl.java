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
import com.sun.javadoc.ParameterizedType;
import com.sun.javadoc.Type;
import com.sun.javadoc.TypeVariable;
import com.sun.javadoc.WildcardType;

abstract class TypeImpl implements Type {

    @Override
    public String typeName() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public String qualifiedTypeName() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public Type getElementType() {
        return null;
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
    public ParameterizedType asParameterizedType() {
        return null;
    }

    @Override
    public AnnotationTypeDoc asAnnotationTypeDoc() {
        return null;
    }

    @Override
    public AnnotatedType asAnnotatedType() {
        return null;
    }
}
