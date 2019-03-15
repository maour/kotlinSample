// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        maven("https://maven.fabric.io/public")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.0-rc01")
        classpath(kotlin("gradle-plugin", version = "1.3.11"))
        classpath(kotlin("android-extensions", version = "1.3.11"))
        classpath ("de.mannodermaus.gradle.plugins:android-junit5:1.3.2.0")
    }
}

extra["kotlin_version"] = "1.3.21"

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
