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
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.RootDoc;
import com.sun.javadoc.SourcePosition;
import javax.lang.model.element.Element;
import jdk.javadoc.doclet.DocletEnvironment;

/**
 * The {@code RootDocImpl} is an implementation of the "old" Doclet APIs (previously under {@code
 * com.sun.javadoc.*}, deprecated since 9 and removed in 13) in terms of new Doclet APIs {@link
 * jdk.javadoc.doclet.Doclet}. ({@link DocletEnvironment}).
 */
public class RootDocImpl extends DocImpl<Element> implements RootDoc {

    public RootDocImpl(DocletEnvironment environment) {
        super(null, new Context(environment));
    }

    @Override
    public String[][] options() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public PackageDoc[] specifiedPackages() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public ClassDoc[] specifiedClasses() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public ClassDoc[] classes() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public ClassDoc classNamed(String qualifiedName) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public PackageDoc packageNamed(String name) {
        throw new UnsupportedOperationException("not yet implemented");
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
        return false;
    }

    @Override
    public void printError(String msg) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public void printError(SourcePosition pos, String msg) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public void printWarning(String msg) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public void printWarning(SourcePosition pos, String msg) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public void printNotice(String msg) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public void printNotice(SourcePosition pos, String msg) {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
