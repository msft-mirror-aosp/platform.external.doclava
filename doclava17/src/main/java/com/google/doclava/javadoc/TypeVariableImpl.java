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

import com.google.doclava.annotation.Unused;
import com.google.doclava.annotation.Used;
import com.sun.javadoc.AnnotationDesc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.ProgramElementDoc;
import com.sun.javadoc.Type;
import com.sun.javadoc.TypeVariable;
import java.util.Objects;
import javax.lang.model.type.TypeMirror;

class TypeVariableImpl extends TypeImpl implements TypeVariable {

    private final javax.lang.model.type.TypeVariable typeVariable;

    protected TypeVariableImpl(javax.lang.model.type.TypeVariable typeVariable, Context context) {
        super(typeVariable, context);
        this.typeVariable = typeVariable;
    }

    static TypeVariableImpl create(javax.lang.model.type.TypeVariable typeVariable,
            Context context) {
        return context.caches.types.typevar.computeIfAbsent(typeVariable,
                el -> new TypeVariableImpl(typeVariable, context));
    }

    @Override
    @Used(implemented = true)
    public Type[] bounds() {
        return new Type[0];
    }

    @Override
    @Used(implemented = true)
    public ClassDoc asClassDoc() {
        TypeMirror erasure = context.environment.getTypeUtils().erasure(typeVariable);
        Type type = create(erasure, context);
        Objects.requireNonNull(type);
        return type.asClassDoc();
    }

    @Override
    @Unused
    public ProgramElementDoc owner() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Used(implemented = true)
    public TypeVariable asTypeVariable() {
        return this;
    }

    @Override
    @Unused
    public AnnotationDesc[] annotations() {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
