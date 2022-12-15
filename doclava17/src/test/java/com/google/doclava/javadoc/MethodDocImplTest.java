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
import static org.junit.Assert.assertTrue;

import com.google.doclava.javadoc.BaseTest.METHOD.OF_CLASS;
import com.google.doclava.javadoc.BaseTest.METHOD.OF_INTERFACE;
import org.junit.Ignore;
import org.junit.Test;

public class MethodDocImplTest extends BaseTest {

    private static class CLASS_METHOD {

        public static MethodDocImpl public_void_arg0;
        public static MethodDocImpl private_int_arg0;
        public static MethodDocImpl packagePrivate_String_arg2_int_String;
        public static MethodDocImpl public_abstract_void_arg0;
        public static MethodDocImpl override_public_String_toString0;
    }

    private static class INTERFACE_METHOD {

        public static MethodDocImpl public_void_arg0;
        public static MethodDocImpl public_default_String_arg0;
    }

    @Override
    public void setUp() {
        super.setUp();
        CLASS_METHOD.public_void_arg0 = MethodDocImpl.create(OF_CLASS.public_void_arg0, context);
        CLASS_METHOD.private_int_arg0 = MethodDocImpl.create(OF_CLASS.private_int_arg0, context);
        CLASS_METHOD.packagePrivate_String_arg2_int_String = MethodDocImpl.create(
                OF_CLASS.packagePrivate_String_arg2_int_String, context);
        CLASS_METHOD.public_abstract_void_arg0 = MethodDocImpl.create(
                OF_CLASS.public_abstract_void_arg0, context);
        CLASS_METHOD.override_public_String_toString0 = MethodDocImpl.create(
                OF_CLASS.override_public_String_toString0, context);

        INTERFACE_METHOD.public_void_arg0 = MethodDocImpl.create(OF_INTERFACE.public_void_arg0,
                context);
        INTERFACE_METHOD.public_default_String_arg0 =
                MethodDocImpl.create(OF_INTERFACE.public_default_String_arg0, context);
    }

    @Test
    public void name() {
        assertEquals("public_void_arg0", CLASS_METHOD.public_void_arg0.name());
        assertEquals("public_default_String_arg0",
                INTERFACE_METHOD.public_default_String_arg0.name());
    }

    @Test
    public void qualifiedName() {
        assertEquals("com.example.methods.OfClass.public_void_arg0",
                CLASS_METHOD.public_void_arg0.qualifiedName());
        assertEquals("com.example.methods.OfInterface.public_default_String_arg0",
                INTERFACE_METHOD.public_default_String_arg0.qualifiedName());
    }

    @Test
    public void isMethod() {
        assertTrue(CLASS_METHOD.public_void_arg0.isMethod());
        assertTrue(INTERFACE_METHOD.public_void_arg0.isMethod());
    }

    @Test
    public void isAbstract() {
        assertFalse(CLASS_METHOD.public_void_arg0.isAbstract());
        // default interface method is not abstract
        assertFalse(INTERFACE_METHOD.public_default_String_arg0.isAbstract());

        assertTrue(CLASS_METHOD.public_abstract_void_arg0.isAbstract());
        // interface methods are abstract
        assertTrue(INTERFACE_METHOD.public_void_arg0.isAbstract());
    }

    @Test
    public void isDefault() {
        assertFalse(CLASS_METHOD.public_void_arg0.isDefault());
        assertFalse(CLASS_METHOD.public_abstract_void_arg0.isDefault());

        assertTrue(INTERFACE_METHOD.public_default_String_arg0.isDefault());
    }

    @Ignore("Not yet implemented")
    @Test
    public void returnType() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void overriddenClass() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void overriddenType() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void overriddenMethod() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void overrides() {
    }
}