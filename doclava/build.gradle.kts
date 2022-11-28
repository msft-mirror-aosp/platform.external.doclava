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

import java.net.URLClassLoader
import javax.tools.ToolProvider

plugins {
    id("com.google.doclava.java-application-conventions")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

application {
    mainClass.set("com.google.doclava.Doclava")
}

dependencies {
    // tools.jar required for com.sun.javadoc
    val toolsJars = if (JavaVersion.current().isJava8) {
        (ToolProvider.getSystemToolClassLoader() as URLClassLoader).urLs
    } else if (System.getenv("JAVA_TOOLS_JAR") != null) {
        arrayOf(System.getenv("JAVA_TOOLS_JAR"))
    } else {
        throw GradleException("""If you are not using Java 8, JAVA_TOOLS_JAR env variable
          needs to be set to tools.jar from a Java 8 installation
          to build Doclava""")
    }

    implementation(files(toolsJars))
}

sourceSets {
    main {
        java {
            srcDirs("${project.rootDir}/src")
        }
        resources {
            srcDirs("${project.rootDir}/res")
        }
    }
    test {
        java {
            srcDir("${project.rootDir}/test")
            exclude("${project.rootDir}/test/api*")
        }
        resources {
            srcDirs("${project.rootDir}/test/api")
        }
    }
}

tasks.test {
    workingDir = project.rootDir;
}
