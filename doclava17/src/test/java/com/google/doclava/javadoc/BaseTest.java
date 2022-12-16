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

import static org.junit.Assert.assertNotNull;

import javax.lang.model.element.TypeElement;
import jdk.javadoc.doclet.DocletEnvironment;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public abstract class BaseTest {

    protected static RootDocImpl rootDoc;
    protected static DocletEnvironment docletEnv;
    protected Context context;

    /**
     * @implNote While marked with {@link BeforeClass}, the actual initialization happens only once
     * across multiple runs by test subclasses, which results are stored in a singleton manner.
     */
    @BeforeClass
    public static void beforeClass() {
        if (docletEnv != null && rootDoc != null) {
            return;
        }

        var doclet = new EmptyDoclet("src/test/resources");
        docletEnv = doclet.getEnvironment();

        rootDoc = new RootDocImpl(docletEnv);
    }

    @Before
    public void setUp() {
        context = new Context(docletEnv);
    }

    // TypeElements (ANNOTATION_TYPE, CLASS, ENUM, INTERFACE, or RECORD).
    static class CLASS {

        static final TypeElement publicAbstractClass = initTypeElement(
                "com.example.classes.AbstractEmptyClass");
        static final TypeElement publicAbstractInterface = initTypeElement(
                "com.example.classes.AbstractEmptyInterface");

        static final TypeElement publicAnnotation = initTypeElement(
                "com.example.classes.PublicAnnotation");
        static final TypeElement publicClass = initTypeElement("com.example.classes.PublicClass");
        static final TypeElement publicEnum = initTypeElement("com.example.classes.PublicEnum");
        static final TypeElement publicInterface = initTypeElement("com.example.classes.PublicInterface");

        static final TypeElement publicClassWithNests = initTypeElement(
                "com.example.classes.PublicClassWithNests");
        static final TypeElement publicClassWithNests$Nest1 = initTypeElement(
                "com.example.classes.PublicClassWithNests.Nest1");
        static final TypeElement publicClassWithNests$Nest1$Nest2 = initTypeElement(
                "com.example.classes.PublicClassWithNests.Nest1.Nest2");

        static final TypeElement parametrizedAnnotation = initTypeElement(
                "com.example.classes.ParametrizedAnnotation");
    }

    static class INSTANCE {

        static final TypeElement javaLangObject = initTypeElement("java.lang.Object");
        static final TypeElement javaLangError  = initTypeElement("java.lang.Error");
        static final TypeElement javaLangException = initTypeElement("java.lang.Exception");
    }

    private static TypeElement initTypeElement(String name) {
        var e = docletEnv.getElementUtils().getTypeElement(name);
        assertNotNull(e);
        return e;
    }
}
