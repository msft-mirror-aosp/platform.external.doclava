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

import com.sun.javadoc.AnnotationDesc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.ProgramElementDoc;
import javax.lang.model.element.Element;

abstract class ProgramElementDocImpl<T extends Element> extends DocImpl<T> implements
        ProgramElementDoc {

    protected ProgramElementDocImpl(T e) {
        super(e);
    }

    @Override
    public ClassDoc containingClass() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public PackageDoc containingPackage() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public int modifierSpecifier() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public String modifiers() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public AnnotationDesc[] annotations() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public boolean isPublic() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public boolean isProtected() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public boolean isPrivate() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public boolean isPackagePrivate() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public boolean isStatic() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public boolean isFinal() {
        throw new UnsupportedOperationException("not yet implemented");
    }

}
