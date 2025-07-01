pluginManagement {
    includeBuild("gradle/plugin/settings")
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
    id("at.released.debuglayout.gradle.settings.root")
}

rootProject.name = "compose-debuglayout"
include("core")
