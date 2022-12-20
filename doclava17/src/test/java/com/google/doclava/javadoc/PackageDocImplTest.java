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

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PackageDocImplTest extends BaseTest {

    private PackageDocImpl comExampleClasses;

    @Before
    public void setUp() {
        super.setUp();
        comExampleClasses = PackageDocImpl.create(PACKAGE.comExampleClasses, context);
    }

    @Ignore("Not yet implemented")
    @Test
    public void allClasses() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void testAllClasses() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void ordinaryClasses() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void exceptions() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void errors() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void enums() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void interfaces() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void annotationTypes() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void annotations() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void findClass() {
    }

    @Ignore("Not yet implemented")
    @Test
    public void isIncluded() {
    }

    @Test
    public void name() {
        assertEquals("classes", comExampleClasses.name());
    }

    @Test
    public void qualifiedName() {
        assertEquals("com.example.classes", comExampleClasses.qualifiedName());
    }
}