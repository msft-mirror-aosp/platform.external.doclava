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

import com.sun.javadoc.Doc;
import com.sun.javadoc.SeeTag;
import com.sun.javadoc.SourcePosition;
import com.sun.javadoc.Tag;
import javax.lang.model.element.Element;

abstract class DocImpl<T extends Element> implements Doc, Comparable<Object> {
    protected final T element;
    protected final Context context;

    protected DocImpl(T e, Context context) {
        this.element = e;
        this.context = context;
    }

    @Override
    public String commentText() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public Tag[] tags() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public Tag[] tags(String tagname) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public SeeTag[] seeTags() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public Tag[] inlineTags() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public Tag[] firstSentenceTags() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public String getRawCommentText() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public void setRawCommentText(String rawDocumentation) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public String toString() {
        return qualifiedName();
    }

    @Override
    public abstract String name();

    public abstract String qualifiedName();

    @Override
    public int compareTo(Object obj) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public boolean isField() {
        return false;
    }

    @Override
    public boolean isEnumConstant() {
        return false;
    }

    @Override
    public boolean isConstructor() {
        return false;
    }

    @Override
    public boolean isMethod() {
        return false;
    }

    @Override
    public boolean isAnnotationTypeElement() {
        return false;
    }

    @Override
    public boolean isInterface() {
        return false;
    }

    @Override
    public boolean isException() {
        return false;
    }

    @Override
    public boolean isError() {
        return false;
    }

    @Override
    public boolean isEnum() {
        return false;
    }

    @Override
    public boolean isAnnotationType() {
        return false;
    }

    @Override
    public boolean isOrdinaryClass() {
        return false;
    }

    @Override
    public boolean isClass() {
        return false;
    }

    @Override
    public abstract boolean isIncluded();

    @Override
    public SourcePosition position() {
        return null;
    }
}
