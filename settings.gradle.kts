pluginManagement {
    includeBuild("gradle/plugin/settings")
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.10.0"
    id("at.released.debuglayout.gradle.settings.root")
}

rootProject.name = "compose-debuglayout"
include("core")
