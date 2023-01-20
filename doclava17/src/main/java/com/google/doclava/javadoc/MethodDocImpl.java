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
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.Type;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

class MethodDocImpl extends ExecutableMemberDocImpl implements MethodDoc {

    protected MethodDocImpl(ExecutableElement e, Context context) {
        super(e, context);
    }

    static MethodDocImpl create(ExecutableElement e, Context context) {
        return context.caches.methods.computeIfAbsent(e,
                el -> new MethodDocImpl(el, context));
    }

    @Override
    public String name() {
        return executableElement.getSimpleName().toString();
    }

    @Override
    public String qualifiedName() {
        var enclosingClass = executableElement.getEnclosingElement();
        return switch (enclosingClass.getKind()) {
            case CLASS, INTERFACE, ANNOTATION_TYPE, ENUM -> {
                var enclosingClassName =
                        ((TypeElement) enclosingClass).getQualifiedName().toString();
                yield enclosingClassName + "." + name();
            }
            default -> throw new UnsupportedOperationException("Expected CLASS, INTERFACE, "
                    + "ANNOTATION_TYPE or ENUM, but got " + enclosingClass.getKind());
        };
    }

    @Override
    public boolean isMethod() {
        return true;
    }

    @Override
    public boolean isAbstract() {
        return java.lang.reflect.Modifier.isAbstract(reflectModifiers);
    }

    private Boolean isDefault;

    @Override
    public boolean isDefault() {
        if (isDefault == null) {
            isDefault = executableElement.getModifiers()
                    .stream()
                    .anyMatch(m -> m == Modifier.DEFAULT);
        }
        return isDefault;
    }

    @Override
    public Type returnType() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public ClassDoc overriddenClass() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public Type overriddenType() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public MethodDoc overriddenMethod() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public boolean overrides(MethodDoc meth) {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
