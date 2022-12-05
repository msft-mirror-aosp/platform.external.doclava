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

    @Ignore("Not yet implemented")
    @Test
    public void name() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void qualifiedName() {
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

    @Ignore("Not yet implemented")
    @Test
    public void constructors() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void testConstructors() {
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

    @Ignore("Not yet implemented")
    @Test
    public void typeName() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void qualifiedTypeName() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void simpleTypeName() {
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

}