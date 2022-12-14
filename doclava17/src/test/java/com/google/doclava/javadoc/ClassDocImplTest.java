/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.doclava.javadoc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ClassDocImplTest extends BaseTest {

    private ClassDocImpl abstractEmptyInterface;
    private ClassDocImpl abstractEmptyClass;
    private ClassDocImpl publicClass;
    private ClassDocImpl publicEnum;
    private ClassDocImpl publicAnnotation;
    private ClassDocImpl publicInterface;

    private ClassDocImpl javaLangError;
    private ClassDocImpl javaLangException;
    private ClassDocImpl javaLangObject;

    private ClassDocImpl publicClassWithNests;
    private ClassDocImpl emptyClassWithNests$Nest1;
    private ClassDocImpl emptyClassWithNests$Nest1$Nest2;

    private ClassDocImpl constructors;

    @Before
    public void setUp() {
        super.setUp();
        abstractEmptyClass = ClassDocImpl.create(CLASS.publicAbstractClass, context);
        abstractEmptyInterface = ClassDocImpl.create(CLASS.publicAbstractInterface, context);

        publicClass = ClassDocImpl.create(CLASS.publicClass, context);
        publicClassWithNests = ClassDocImpl.create(CLASS.publicClassWithNests, context);
        publicEnum = ClassDocImpl.create(CLASS.publicEnum, context);
        // note that it is created using AnnotationTypeDocImpl ctor.
        publicAnnotation = AnnotationTypeDocImpl.create(CLASS.publicAnnotation, context);
        publicInterface = ClassDocImpl.create(CLASS.publicInterface, context);

        javaLangError = ClassDocImpl.create(INSTANCE.javaLangError, context);
        javaLangException = ClassDocImpl.create(INSTANCE.javaLangException, context);
        javaLangObject = ClassDocImpl.create(INSTANCE.javaLangObject, context);

        publicClassWithNests = ClassDocImpl.create(CLASS.publicClassWithNests, context);
        emptyClassWithNests$Nest1 = ClassDocImpl.create(CLASS.publicClassWithNests$Nest1, context);
        emptyClassWithNests$Nest1$Nest2 = ClassDocImpl.create(
                CLASS.publicClassWithNests$Nest1$Nest2, context);

        constructors = ClassDocImpl.create(CLASS.constructors, context);
    }

    @Test
    public void isClass() {
        assertFalse(publicAnnotation.isClass());
        assertFalse(publicInterface.isClass());

        assertTrue(publicClass.isClass());
        assertTrue(publicEnum.isClass());
        assertTrue(javaLangObject.isClass());
        assertTrue(javaLangError.isClass());
        assertTrue(javaLangException.isClass());
    }

    @Test
    public void isOrdinaryClass() {
        // not an enumeration, interface, annotation, exception, or an error.
        assertFalse(publicAnnotation.isOrdinaryClass());
        assertFalse(publicEnum.isOrdinaryClass());
        assertFalse(publicInterface.isOrdinaryClass());
        assertFalse(javaLangError.isOrdinaryClass());
        assertFalse(javaLangException.isOrdinaryClass());

        assertTrue(publicClass.isOrdinaryClass());
        assertTrue(javaLangObject.isOrdinaryClass());
    }

    @Test
    public void isEnum() {
        assertTrue(publicEnum.isEnum());

        assertFalse(publicAnnotation.isEnum());
        assertFalse(publicClass.isEnum());
        assertFalse(publicInterface.isEnum());
        assertFalse(javaLangError.isEnum());
        assertFalse(javaLangException.isEnum());
        assertFalse(javaLangObject.isEnum());
    }

    @Test
    public void isInterface() {
        assertTrue(publicInterface.isInterface());

        assertFalse(publicAnnotation.isInterface());
        assertFalse(publicClass.isInterface());
        assertFalse(publicEnum.isInterface());
        assertFalse(javaLangError.isInterface());
        assertFalse(javaLangException.isInterface());
        assertFalse(javaLangObject.isInterface());
    }

    @Test
    public void isException() {
        assertTrue(javaLangException.isException());

        assertFalse(publicAnnotation.isException());
        assertFalse(publicClass.isException());
        assertFalse(publicEnum.isException());
        assertFalse(publicInterface.isException());
        assertFalse(javaLangError.isException());
        assertFalse(javaLangObject.isException());
    }

    @Test
    public void isError() {
        assertTrue(javaLangError.isError());

        assertFalse(publicAnnotation.isError());
        assertFalse(publicClass.isError());
        assertFalse(publicEnum.isError());
        assertFalse(publicInterface.isError());
        assertFalse(javaLangException.isError());
        assertFalse(javaLangObject.isError());
    }

    @Test
    public void name() {
        assertEquals("AbstractEmptyClass", abstractEmptyClass.name());
        assertEquals("AbstractEmptyInterface", abstractEmptyInterface.name());
        assertEquals("PublicInterface", publicInterface.name());
        assertEquals("PublicAnnotation", publicAnnotation.name());
        assertEquals("PublicClass", publicClass.name());
        assertEquals("PublicEnum", publicEnum.name());

        assertEquals("Error", javaLangError.name());
        assertEquals("Exception", javaLangException.name());
        assertEquals("Object", javaLangObject.name());

        assertEquals("PublicClassWithNests", publicClassWithNests.name());
        assertEquals("PublicClassWithNests.Nest1", emptyClassWithNests$Nest1.name());
        assertEquals("PublicClassWithNests.Nest1.Nest2", emptyClassWithNests$Nest1$Nest2.name());
    }

    @Test
    public void qualifiedName() {
        assertEquals("com.example.classes.AbstractEmptyClass", abstractEmptyClass.qualifiedName());
        assertEquals("com.example.classes.AbstractEmptyInterface",
                abstractEmptyInterface.qualifiedName());
        assertEquals("com.example.classes.PublicInterface", publicInterface.qualifiedName());
        assertEquals("com.example.classes.PublicAnnotation", publicAnnotation.qualifiedName());
        assertEquals("com.example.classes.PublicClass", publicClass.qualifiedName());
        assertEquals("com.example.classes.PublicEnum", publicEnum.qualifiedName());

        assertEquals("java.lang.Error", javaLangError.qualifiedName());
        assertEquals("java.lang.Exception", javaLangException.qualifiedName());
        assertEquals("java.lang.Object", javaLangObject.qualifiedName());

        assertEquals("com.example.classes.PublicClassWithNests",
                publicClassWithNests.qualifiedName());
        assertEquals("com.example.classes.PublicClassWithNests.Nest1",
                emptyClassWithNests$Nest1.qualifiedName());
        assertEquals("com.example.classes.PublicClassWithNests.Nest1.Nest2",
                emptyClassWithNests$Nest1$Nest2.qualifiedName());
    }

    @Ignore("Not yet implemented")
    @Test
    public void isIncluded() {
    }

    @Test
    public void isAbstract() {
        assertTrue(abstractEmptyClass.isAbstract());
        assertTrue(abstractEmptyInterface.isAbstract());
        assertTrue(publicInterface.isAbstract());
        assertTrue(publicAnnotation.isAbstract());

        assertFalse(publicClass.isAbstract());
        assertFalse(publicEnum.isAbstract());
        assertFalse(javaLangError.isAbstract());
        assertFalse(javaLangException.isAbstract());
        assertFalse(javaLangObject.isAbstract());
    }

    @Ignore("Not yet implemented")
    @Test
    public void isSerializable() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void isExternalizable() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void serializationMethods() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void serializableFields() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void definesSerializableFields() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void superclass() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void superclassType() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void subclassOf() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void interfaces() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void interfaceTypes() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void typeParameters() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void typeParamTags() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void fields() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void testFields() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void enumConstants() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void methods() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void testMethods() {
    }

    /**
     * @implNote This (and {@link #constructors_filter_false()} and
     * {@link #constructors_filter_true()}) tests do not cover cases when Doclet is supplied with
     * a non-default <b>selection control</b> flag (default is {@code -protected}), i.e.
     * {@code -public}, {@code -package} or {@code private}. It also does not currently cover
     * selection control options from new Doclet API (e.g. {@code --show-members}.
     *
     * @see jdk.javadoc.doclet definition of <b>selection control</b> in "Terminology" section
     * @see jdk.javadoc.doclet new options in "Options" section
     */
    @Test
    public void constructors() {
        // 1. Class with four constructors (public, protected, private and package-private).
        // Should include only public and protected.
        var ctors = constructors.constructors();
        assertEquals(2, ctors.length);

        // 2. Public enum has no declared constructors, but has one implicit private.
        var enumConstructors = publicEnum.constructors();
        assertEquals(0, enumConstructors.length);

        //TODO: Handle all selection control variants.
    }

    /**
     * @see #constructors
     */
    @Test
    public void constructors_filter_true() {
        // 1. Class with four constructors (public, protected, private and package-private).
        // Should include only public and protected.
        var ctors = constructors.constructors(true);
        assertEquals(2, ctors.length);

        // 2. Public enum has no declared constructors, but has one implicit private.
        var enumConstructors = publicEnum.constructors(true);
        assertEquals(0, enumConstructors.length);
    }

    /**
     * @see #constructors
     */
    @Test
    public void constructors_filter_false() {
        // 1. Class with four constructors (public, protected, private and package-private).
        // Should include all four.
        var ctors = constructors.constructors(false);
        assertEquals(4, ctors.length);

        // 2. Public enum has no declared constructors, but has one implicit private.
        var enumConstructors = publicEnum.constructors(false);
        assertEquals(1, enumConstructors.length);
    }

    @Ignore("Not yet implemented")
    @Test
    public void innerClasses() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void findClass() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void importedClasses() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void importedPackages() {
    }

    @Test
    public void typeName() {
        assertEquals("AbstractEmptyClass", abstractEmptyClass.typeName());
        assertEquals("AbstractEmptyInterface", abstractEmptyInterface.typeName());
        assertEquals("PublicInterface", publicInterface.typeName());
        assertEquals("PublicAnnotation", publicAnnotation.typeName());
        assertEquals("PublicClass", publicClass.typeName());
        assertEquals("PublicEnum", publicEnum.typeName());

        assertEquals("Error", javaLangError.typeName());
        assertEquals("Exception", javaLangException.typeName());
        assertEquals("Object", javaLangObject.typeName());

        assertEquals("PublicClassWithNests", publicClassWithNests.typeName());
        assertEquals("PublicClassWithNests.Nest1", emptyClassWithNests$Nest1.typeName());
        assertEquals("PublicClassWithNests.Nest1.Nest2",
                emptyClassWithNests$Nest1$Nest2.typeName());
    }

    @Test
    public void qualifiedTypeName() {
        assertEquals("com.example.classes.AbstractEmptyClass",
                abstractEmptyClass.qualifiedTypeName());
        assertEquals("com.example.classes.AbstractEmptyInterface",
                abstractEmptyInterface.qualifiedName());
        assertEquals("com.example.classes.PublicInterface", publicInterface.qualifiedName());
        assertEquals("com.example.classes.PublicAnnotation", publicAnnotation.qualifiedName());
        assertEquals("com.example.classes.PublicClass", publicClass.qualifiedName());
        assertEquals("com.example.classes.PublicEnum", publicEnum.qualifiedName());

        assertEquals("java.lang.Error", javaLangError.qualifiedName());
        assertEquals("java.lang.Exception", javaLangException.qualifiedName());
        assertEquals("java.lang.Object", javaLangObject.qualifiedName());

        assertEquals("com.example.classes.PublicClassWithNests",
                publicClassWithNests.qualifiedName());
        assertEquals("com.example.classes.PublicClassWithNests.Nest1",
                emptyClassWithNests$Nest1.qualifiedName());
        assertEquals("com.example.classes.PublicClassWithNests.Nest1.Nest2",
                emptyClassWithNests$Nest1$Nest2.qualifiedName());
    }

    @Test
    public void simpleTypeName() {
        assertEquals("AbstractEmptyClass", abstractEmptyClass.simpleTypeName());
        assertEquals("AbstractEmptyInterface", abstractEmptyInterface.simpleTypeName());
        assertEquals("PublicInterface", publicInterface.simpleTypeName());
        assertEquals("PublicAnnotation", publicAnnotation.simpleTypeName());
        assertEquals("PublicClass", publicClass.simpleTypeName());
        assertEquals("PublicEnum", publicEnum.simpleTypeName());

        assertEquals("Error", javaLangError.simpleTypeName());
        assertEquals("Exception", javaLangException.simpleTypeName());
        assertEquals("Object", javaLangObject.simpleTypeName());

        assertEquals("PublicClassWithNests", publicClassWithNests.simpleTypeName());
        assertEquals("Nest1", emptyClassWithNests$Nest1.simpleTypeName());
        assertEquals("Nest2", emptyClassWithNests$Nest1$Nest2.simpleTypeName());
    }

    @Test
    public void dimension() {
        assertEquals("", publicClass.dimension());
    }

    @Test
    public void isPrimitive() {
        assertFalse(publicClass.isPrimitive());
        assertFalse(publicInterface.isPrimitive());
        assertFalse(publicEnum.isPrimitive());
    }

    @Test
    public void asClassDoc() {
        assertEquals(publicClass, publicClass.asClassDoc());
        assertEquals(publicInterface, publicInterface.asClassDoc());
        assertEquals(publicEnum, publicEnum.asClassDoc());
    }

    @Test
    public void asParameterizedType() {
        assertNull(publicClass.asParameterizedType());
        assertNull(publicInterface.asParameterizedType());
        assertNull(publicEnum.asParameterizedType());
    }

    @Test
    public void asTypeVariable() {
        assertNull(publicClass.asTypeVariable());
        assertNull(publicInterface.asTypeVariable());
        assertNull(publicEnum.asTypeVariable());
    }

    @Test
    public void asWildcardType() {
        assertNull(publicClass.asWildcardType());
        assertNull(publicInterface.asWildcardType());
        assertNull(publicEnum.asWildcardType());
    }

    @Test
    public void asAnnotatedType() {
        assertNull(publicClass.asAnnotatedType());
        assertNull(publicInterface.asAnnotatedType());
        assertNull(publicEnum.asAnnotatedType());
    }

    @Test
    public void asAnnotationTypeDoc() {
        assertNull(publicClass.asAnnotationTypeDoc());
        assertNull(publicInterface.asAnnotationTypeDoc());
        assertNull(publicEnum.asAnnotationTypeDoc());
    }

    @Ignore("Not yet implemented")
    @Test
    public void getElementType() {
    }

    @Test
    public void modifiers() {
        assertEquals("public abstract", abstractEmptyClass.modifiers());
        assertEquals("public", publicClass.modifiers());
        assertEquals("public final", publicEnum.modifiers());

        // interfaces and annotations should not have 'abstract' modifier
        assertEquals("public interface", publicInterface.modifiers());
        assertEquals("public interface", publicAnnotation.modifiers());
    }

    @Test
    public void modifierSpecifier() {
        assertEquals(Modifier.PUBLIC | Modifier.ABSTRACT,
                abstractEmptyClass.modifierSpecifier());
        assertEquals(Modifier.PUBLIC, publicClass.modifierSpecifier());
        assertEquals(Modifier.PUBLIC | Modifier.FINAL, publicEnum.modifierSpecifier());

        // interfaces and annotations should not have 'abstract' modifier
        assertEquals(Modifier.PUBLIC | Modifier.INTERFACE, publicInterface.modifierSpecifier());
        assertEquals(Modifier.PUBLIC | Modifier.INTERFACE, publicAnnotation.modifierSpecifier());
    }
}