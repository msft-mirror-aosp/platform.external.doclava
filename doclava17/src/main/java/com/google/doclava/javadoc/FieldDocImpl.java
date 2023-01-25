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
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.SerialFieldTag;
import com.sun.javadoc.Type;
import javax.lang.model.element.VariableElement;

class FieldDocImpl extends MemberDocImpl<VariableElement> implements FieldDoc {

    protected FieldDocImpl(VariableElement e, Context context) {
        super(e, context);
    }

    @Override
    @Used
    public boolean isSynthetic() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Used
    public String name() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Used
    public String qualifiedName() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Used
    public boolean isIncluded() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Used
    public Type type() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Used
    public boolean isTransient() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Used
    public boolean isVolatile() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Unused
    public SerialFieldTag[] serialFieldTags() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Used
    public Object constantValue() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Unused
    public String constantValueExpression() {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
