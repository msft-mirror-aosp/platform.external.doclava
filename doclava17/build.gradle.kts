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

plugins {
    id("com.google.doclava.java-application-conventions")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    mainClass.set("com.google.doclava.Doclava")
}

val doclava17 by configurations.creating

dependencies {
    doclava17(project(":doclava17"))

    implementation("com.google.code.findbugs:jsr305:3.0.2")
}

sourceSets {
    main {
        java {
            srcDir("${project.rootDir}/src")
            exclude {
                it.file.absolutePath.endsWith("src/com/google/doclava/Doclava.java")
            }
        }
        resources {
            srcDirs("${project.rootDir}/res")
        }
    }
    create("for javadoc") {
        java {
            srcDir("${projectDir}/src/main/java")
        }
    }
}

tasks.create<Exec>("doclava17-on-itself") {
    dependsOn(":doclava17:jar")

    group = "run"
    workingDir = projectDir

    val javadocTool = javaToolchains.javadocToolFor {
        languageVersion.set(JavaLanguageVersion.of(17))
    }.get().executablePath.toString()

    val files = project.sourceSets["for javadoc"]
        .allJava
        .filter { !it.endsWith("Doclava.java") }
        .map { it.path }
        .toList()

    val args = mutableListOf(
        javadocTool,
        "-d", "out/doclava-outputs/on-self",
        "-doclet", "com.google.doclava.Doclava",
        "-docletpath", doclava17.files.toList().joinToString(separator = ":") { it.path },
        "-encoding", "UTF-8",
    )
    args.addAll(files)

    commandLine = args
}

val addedExports = listOf("--add-exports", "jdk.javadoc/jdk.javadoc.internal.tool=ALL-UNNAMED")

tasks.withType<JavaCompile> {
    sourceCompatibility = "17"
    options.compilerArgs.addAll(addedExports)
}

tasks.withType<Test> {
    java.sourceCompatibility = JavaVersion.VERSION_17
    jvmArgs = addedExports
}