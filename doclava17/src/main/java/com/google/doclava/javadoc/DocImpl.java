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
import com.sun.source.doctree.BlockTagTree;
import com.sun.source.doctree.DocCommentTree;
import com.sun.source.doctree.DocTree;
import com.sun.source.doctree.DocTree.Kind;
import com.sun.source.doctree.InlineTagTree;
import com.sun.source.doctree.ParamTree;
import com.sun.source.doctree.SeeTree;
import com.sun.source.doctree.SerialFieldTree;
import com.sun.source.doctree.ThrowsTree;
import com.sun.source.util.SimpleDocTreeVisitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.lang.model.element.Element;

abstract class DocImpl<T extends Element> implements Doc, Comparable<Object> {

    protected final T element;
    protected final Context context;

    protected DocImpl(T e, Context context) {
        this.element = e;
        this.context = context;
    }

    private String commentText;

    @Override
    public String commentText() {
        if (commentText == null) {
            var dt = context.environment.getDocTrees().getDocCommentTree(element);
            commentText = dt.getFullBody().stream()
                    .map(DocTree::toString)
                    .collect(Collectors.joining())
                    .trim();
        }
        return commentText;
    }

    private Tag[] tags;

    @Override
    public Tag[] tags() {
        if (tags == null) {
            DocCommentTree tree = context.environment.getDocTrees().getDocCommentTree(element);
            List<? extends DocTree> blockTags = tree.getBlockTags();

            tags = blockTags
                    .stream()
                    .map(docTree -> TagImpl.create(docTree, element, context))
                    .toArray(Tag[]::new);
        }
        return tags;
    }

    @Override
    public Tag[] tags(String kind) {
        return Arrays.stream(tags())
                .filter(t -> t.kind().equals(kind))
                .toArray(Tag[]::new);
    }

    private SeeTag[] seeTags;

    @Override
    public SeeTag[] seeTags() {
        if (seeTags == null) {
            seeTags = Arrays.stream(tags())
                    .filter(t -> t instanceof SeeTagImpl)
                    .toArray(SeeTag[]::new);
        }
        return seeTags;
    }

    private Tag[] inlineTags;

    @Override
    public Tag[] inlineTags() {
        if (inlineTags == null) {
            var dt = context.environment.getDocTrees().getDocCommentTree(element);
            List<DocTree> tags = new ArrayList<>(dt.getFullBody());
            inlineTags = tags.stream()
                    .map(tag -> TagImpl.create(tag, element, context))
                    .toArray(Tag[]::new);
        }
        return inlineTags;
    }

    private Tag[] firstSentenceTags;

    @Override
    public Tag[] firstSentenceTags() {
        if (firstSentenceTags == null) {
            var dt = context.environment.getDocTrees().getDocCommentTree(element);
            firstSentenceTags = dt.getFirstSentence().stream()
                    .map(tag -> TagImpl.create(tag, element, context))
                    .toArray(Tag[]::new);
        }
        return firstSentenceTags;
    }

    private String getRawCommentText;

    /**
     * {@inheritDoc}
     *
     * @implNote this implementation prettifies javadoc a bit; previous implementation returned
     * javadoc as-is without any modifications.
     *
     */
    @Override
    public String getRawCommentText() {
        if (getRawCommentText == null) {
            var dt = context.environment.getDocTrees().getDocCommentTree(element);
            //TODO: this implementation is slightly different, consider reimplementing.
            getRawCommentText = dt.toString();
        }
        return getRawCommentText;
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
