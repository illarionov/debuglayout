/*
 * Copyright (c) 2024-2026, Alexey Illarionov and the compose-debuglayout project contributors.
 * Please see the AUTHORS file for details.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 * SPDX-License-Identifier: Apache-2.0
 */

package at.released.debuglayout.gradle.multiplatform

import com.android.build.api.dsl.KotlinMultiplatformAndroidHostTestCompilation
import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryTarget
import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

/*
 * Convention plugin that configures unit tests in projects with the Kotlin Multiplatform plugin
 */
plugins.withId("com.android.kotlin.multiplatform.library") {
    val libs = versionCatalogs.named("libs")
    extensions.configure<KotlinMultiplatformExtension> {
        targets.withType<KotlinMultiplatformAndroidLibraryTarget>().configureEach {
            compilations.withType<KotlinMultiplatformAndroidHostTestCompilation>().configureEach {
                defaultSourceSet.dependencies {
                    implementation(kotlin("test-junit5"))
                    runtimeOnly(libs.findLibrary("junit-jupiter-engine").get())
                    runtimeOnly(libs.findLibrary("junit-platform-launcher").get())
                }
            }
        }
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    maxHeapSize = "2G"
    testLogging {
        events = mutableSetOf(
            FAILED,
        )
    }
}
