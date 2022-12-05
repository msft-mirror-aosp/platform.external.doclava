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

import jdk.javadoc.doclet.DocletEnvironment;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public abstract class BaseTest {

    protected static RootDocImpl rootDoc;
    protected static DocletEnvironment docletEnv;

    /**
     * @implNote While marked with {@link BeforeClass}, the actual initialization happens only once
     * across multiple runs by test subclasses, which results are stored in a singleton manner.
     */
    @BeforeClass
    public static void beforeClass() {
        if (docletEnv != null && rootDoc != null) {
            return;
        }

        var doclet = new EmptyDoclet("doclava17/src/test/resources");
        docletEnv = doclet.getEnvironment();

        rootDoc = new RootDocImpl(docletEnv);
    }
}
