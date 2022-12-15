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
        static final TypeElement publicInterface = initTypeElement(
                "com.example.classes.PublicInterface");

        static final TypeElement publicClassWithNests = initTypeElement(
                "com.example.classes.PublicClassWithNests");
        static final TypeElement publicClassWithNests$Nest1 = initTypeElement(
                "com.example.classes.PublicClassWithNests.Nest1");
        static final TypeElement publicClassWithNests$Nest1$Nest2 = initTypeElement(
                "com.example.classes.PublicClassWithNests.Nest1.Nest2");

        static final TypeElement parametrizedAnnotation = initTypeElement(
                "com.example.classes.ParametrizedAnnotation");

        static final TypeElement tags = initTypeElement("com.example.classes.Tags");
        static final TypeElement tags$See = initTypeElement("com.example.classes.Tags.See");
        static final TypeElement tags$Throws = initTypeElement("com.example.classes.Tags.Throws");
        static final TypeElement tags$Various = initTypeElement("com.example.classes.Tags.Various");

        static final TypeElement constructors = initTypeElement(
                "com.example.constructors.Constructors");

        static final TypeElement packagePrivateClass = initTypeElement("com.example.classes.PackagePrivateClass");

        static final TypeElement implementsSerializable = initTypeElement(
                "com.example.classes.ImplementsSerializable");
        static final TypeElement implementsExternalizable = initTypeElement(
                "com.example.classes.ImplementsExternalizable");
    }
    
    static class INTERFACE {
        static final TypeElement extendsSerializable = initTypeElement(
                "com.example.classes.ExtendsSerializable");
        static final TypeElement extendsExternalizable = initTypeElement(
                "com.example.classes.ExtendsExternalizable");
    }

    static class INSTANCE {

        static final TypeElement javaLangObject = initTypeElement("java.lang.Object");
        static final TypeElement javaLangError = initTypeElement("java.lang.Error");
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

            static final ExecutableElement returningBool = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "bool()");
            static final ExecutableElement returningByte = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "byt()");
            static final ExecutableElement returningChar = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "ch()");
            static final ExecutableElement returningDouble = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "dbl()");
            static final ExecutableElement returningFloat = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "flt()");
            static final ExecutableElement returningInteger = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "integer()");
            static final ExecutableElement returningLond = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "lng()");
            static final ExecutableElement returningShort = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "shrt()");
            static final ExecutableElement returningString = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "str()");
            static final ExecutableElement returningClass = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "cls()");
            static final ExecutableElement returningEnum = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "enm()");
            static final ExecutableElement returningAnnotation = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "annotation()");
            static final ExecutableElement returningArrayOfString = initExecutableElement(
                    "com.example.classes.AllDefaultAnnotation", "arrayOfStrings()");
        }

        static final TypeElement allDefaultAnnotation = initTypeElement(
                "com.example.classes.AllDefaultAnnotation");
        static final ExecutableElement annotationMethod = initExecutableElement(
                "com.example.classes.ParametrizedAnnotation", "primitiveI()");
        static final ExecutableElement annotationMethodWithDefault = initExecutableElement(
                "com.example.classes.ParametrizedAnnotation", "primitiveDefaultL()");
    }

    static class CONSTRUCTOR {

        static final ExecutableElement empty = initExecutableElement(
                "com.example.constructors.Constructors", "Constructors()");
        static final ExecutableElement arg1_int = initExecutableElement(
                "com.example.constructors.Constructors", "Constructors(int)");
        static final ExecutableElement arg1_String = initExecutableElement(
                "com.example.constructors.Constructors", "Constructors(java.lang.String)");
        static final ExecutableElement arg2_int_String = initExecutableElement(
                "com.example.constructors.Constructors", "Constructors(int,java.lang.String)");
    }

    static class METHOD {

        static class OF_CLASS {

            static final ExecutableElement public_void_arg0 = initExecutableElement(
                    "com.example.methods.OfClass", "public_void_arg0()");
            static final ExecutableElement private_int_arg0 = initExecutableElement(
                    "com.example.methods.OfClass", "private_int_arg0()");
            static final ExecutableElement packagePrivate_String_arg2_int_String = initExecutableElement(
                    "com.example.methods.OfClass",
                    "packagePrivate_String_arg2_int_String(int,java.lang.String)");
            static final ExecutableElement public_abstract_void_arg0 = initExecutableElement(
                    "com.example.methods.OfClass", "public_abstract_void_arg0()");
            static final ExecutableElement override_public_String_toString0 = initExecutableElement(
                    "com.example.methods.OfClass", "toString()");
        }

        static class OF_INTERFACE {

            static final ExecutableElement public_void_arg0 = initExecutableElement(
                    "com.example.methods.OfInterface", "public_void_arg0()");
            static final ExecutableElement public_default_String_arg0 = initExecutableElement(
                    "com.example.methods.OfInterface", "public_default_String_arg0()");
        }
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
     * Finds ExecutableElement in the environment by class type and element signature.
     * Signature should be in the following format: {@code methodName(type1[,type2...])}, types
     * are specified in a fully qualified form. For example:
     *
     * <ul>
     *     <li>{@code Constructor()}</li>
     *     <li>{@code Constructor(int)}</li>
     *     <li>{@code update(java.lang.String,float)}</li>
     * </ul>
     *
     * @param type fully qualified class name
     * @param signature signature of executable element
     * @return ExecutableElement
     */
    private static ExecutableElement initExecutableElement(String type, String signature) {
        var t = initTypeElement(type);
        var methods = t.getEnclosedElements()
                .stream()
                .filter(e -> e instanceof ExecutableElement)
                .map(e -> (ExecutableElement) e)
                .filter(exe -> signature.equals(exe.toString()))
                .toList();

        assertEquals(1, methods.size());
        return methods.get(0);
    }
}
