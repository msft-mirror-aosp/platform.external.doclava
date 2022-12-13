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
import static org.junit.Assert.assertNotNull;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
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

        static TypeElement tags = initTypeElement("com.example.classes.Tags");
        static TypeElement tags$See = initTypeElement("com.example.classes.Tags.See");
        static TypeElement tags$Throws = initTypeElement("com.example.classes.Tags.Throws");
        static TypeElement tags$Various = initTypeElement("com.example.classes.Tags.Various");
    }

    static class INSTANCE {

        static final TypeElement javaLangObject = initTypeElement("java.lang.Object");
        static final TypeElement javaLangError  = initTypeElement("java.lang.Error");
        static final TypeElement javaLangException = initTypeElement("java.lang.Exception");
    }

    static class PACKAGE {

        static PackageElement comExampleClasses = initPackageElement("com.example.classes");
    }

    static class ANNOTATION_METHOD {

        /**
         * <pre>
         * public @interface AllDefaultAnnotation {
         *     boolean bool() default true;
         *     byte byt() default (byte)1;
         *     char ch() default 'a';
         *     double dbl() default 3.1d;
         *     float flt() default 4.1f;
         *     int integer() default 5;
         *     long lng() default 6L;
         *     short shrt() default (short)7;
         *     String str() default "qwe";
         *     Class<?> cls() default PublicClass.class;
         *     SimpleEnum enm() default SimpleEnum.A;
         *     Class<?> annotation() default Override.class;
         *     String[] arrayOfStrings() default { "abc", "def", "ghi" };
         * }
         * </pre>
         */
        static class WITH_DEFAULT {

            static ExecutableElement returningBool = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "bool");
            static ExecutableElement returningByte = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "byt");
            static ExecutableElement returningChar = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "ch");
            static ExecutableElement returningDouble = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "dbl");
            static ExecutableElement returningFloat = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "flt");
            static ExecutableElement returningInteger = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "integer");
            static ExecutableElement returningLond = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "lng");
            static ExecutableElement returningShort = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "shrt");
            static ExecutableElement returningString = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "str");
            static ExecutableElement returningClass = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "cls");
            static ExecutableElement returningEnum = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "enm");
            static ExecutableElement returningAnnotation = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "annotation");
            static ExecutableElement returningArrayOfString = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "arrayOfStrings");
        }

        static TypeElement allDefaultAnnotation = initTypeElement(
                "com.example.classes.AllDefaultAnnotation");
        static ExecutableElement annotationMethod = initExecutableElement(
                "com.example.classes.ParametrizedAnnotation", "primitiveI");
        static ExecutableElement annotationMethodWithDefault = initExecutableElement(
                "com.example.classes.ParametrizedAnnotation", "primitiveDefaultL");
    }

    private static TypeElement initTypeElement(String name) {
        var e = docletEnv.getElementUtils().getTypeElement(name);
        assertNotNull(e);
        return e;
    }

    private static PackageElement initPackageElement(String name) {
        var e = docletEnv.getElementUtils().getPackageElement(name);
        assertNotNull(e);
        return e;
    }

    /**
     * Finds ExecutableElement in the environment by class type and method name. Does not handle
     * same method names and different type signatures. Fails assertion if multiple methods with the
     * same name found.
     *
     * @param type fully qualified class name
     * @param methodName method name
     * @return ExecutableElement
     */
    private static ExecutableElement initExecutableElement(String type, String methodName) {
        var t = initTypeElement(type);
        var methods = t.getEnclosedElements()
                .stream()
                .filter(e -> e.getKind() == ElementKind.METHOD)
                .map(e -> (ExecutableElement) e)
                .filter(e -> e.getSimpleName().toString().equals(methodName))
                .toList();

        assertEquals(1, methods.size());
        return methods.get(0);
    }
}
