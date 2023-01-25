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
import com.sun.javadoc.AnnotationTypeDoc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.PackageDoc;
import javax.lang.model.element.PackageElement;

class PackageDocImpl extends DocImpl<PackageElement> implements PackageDoc {

    private final PackageElement packageElement;

    protected PackageDocImpl(PackageElement e, Context context) {
        super(e, context);
        this.packageElement = e;
    }

    static PackageDocImpl create(PackageElement e, Context context) {
        return context.caches.packages.computeIfAbsent(e, el -> new PackageDocImpl(el, context));
    }

    @Override
    @Unused
    public ClassDoc[] allClasses(boolean filter) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Unused
    public ClassDoc[] allClasses() {
        return allClasses(true);
    }

    @Override
    @Used
    public ClassDoc[] ordinaryClasses() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Used
    public ClassDoc[] exceptions() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Used
    public ClassDoc[] errors() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Used
    public ClassDoc[] enums() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Used
    public ClassDoc[] interfaces() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Used
    public AnnotationTypeDoc[] annotationTypes() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Unused
    public AnnotationDesc[] annotations() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Unused
    public ClassDoc findClass(String className) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Used
    public boolean isIncluded() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    private String name;

    @Override
    @Used(implemented = true)
    public String name() {
        if (name == null) {
            name = packageElement.getSimpleName().toString();
        }
        return name;
    }

    private String qualifiedName;

    @Override
    public String qualifiedName() {
        if (qualifiedName == null) {
            qualifiedName = packageElement.getQualifiedName().toString();
        }
        return qualifiedName;
    }
}
