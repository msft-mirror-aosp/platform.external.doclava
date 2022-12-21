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

import com.google.doclava.annotation.Used;
import com.sun.javadoc.ParamTag;
import com.sun.source.doctree.ParamTree;
import java.util.HashMap;
import javax.lang.model.element.Element;

class ParamTagImpl extends TagImpl implements ParamTag {

    protected ParamTagImpl(ParamTree paramTree, Element owner, Context context) {
        super(paramTree, owner, context);
    }

    static ParamTagImpl create(ParamTree paramTree, Element owner, Context context) {
        var tagsOfElement = context.caches.tags.param.computeIfAbsent(owner,
                el -> new HashMap<>());
        return tagsOfElement.computeIfAbsent(paramTree, el -> new ParamTagImpl(el, owner, context));
    }

    @Override
    @Used
    public String parameterName() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Used
    public String parameterComment() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    @Used
    public boolean isTypeParameter() {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
