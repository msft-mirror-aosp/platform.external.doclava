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

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.ExecutableMemberDoc;
import com.sun.javadoc.ParamTag;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.SourcePosition;
import com.sun.javadoc.ThrowsTag;
import com.sun.javadoc.Type;
import com.sun.javadoc.TypeVariable;
import javax.lang.model.element.ExecutableElement;

abstract class ExecutableMemberDocImpl extends MemberDocImpl<ExecutableElement> implements
        ExecutableMemberDoc {


    protected ExecutableMemberDocImpl(ExecutableElement e) {
        super(e);
    }

    @Override
    public boolean isNative() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public boolean isSynchronized() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public boolean isVarArgs() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public boolean isSynthetic() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public boolean isIncluded() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public ThrowsTag[] throwsTags() {
        throw new UnsupportedOperationException("not yet implemented");
    }


    @Override
    public ParamTag[] paramTags() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public ParamTag[] typeParamTags() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public ClassDoc[] thrownExceptions() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public Type[] thrownExceptionTypes() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public Parameter[] parameters() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public Type receiverType() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public TypeVariable[] typeParameters() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public String signature() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public String flatSignature() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public SourcePosition position() {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
