/*
 * Copyright (c) 2024-2026, Alexey Illarionov and the compose-debuglayout project contributors.
 * Please see the AUTHORS file for details.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 * SPDX-License-Identifier: Apache-2.0
 */

package at.released.debuglayout.gradle.multiplatform

import org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11

/*
 * Convention plugin that configures Android library target in projects with the Kotlin Multiplatform plugin
 */
plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.kotlin.multiplatform.library")
    id("at.released.debuglayout.gradle.multiplatform.kotlin")
    id("at.released.debuglayout.gradle.lint.android-lint")
}

kotlin {
    android {
        compileSdk = versionCatalogs.named("libs").findVersion("androidCompileSdk").get().displayName.toInt()
        minSdk = versionCatalogs.named("libs").findVersion("androidMinSdk").get().displayName.toInt()
        aarMetadata.minCompileSdk = 1
        enableCoreLibraryDesugaring = false

        compilerOptions {
            jvmTarget.set(JVM_11)
        }
    }
}
