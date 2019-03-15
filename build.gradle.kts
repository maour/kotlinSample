// Top-level build file where you can add configuration options common to all sub-projects/modules.



buildscript {
    extra.set("kotlin_version", "1.3.21")

    repositories {
        google()
        jcenter()
        maven("https://maven.fabric.io/public")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.0-rc01")
        classpath(kotlin("gradle-plugin", version = extra.get("kotlin_version").toString()))
        classpath(kotlin("android-extensions", version = extra.get("kotlin_version").toString()))
        classpath("de.mannodermaus.gradle.plugins:android-junit5:1.3.2.0")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
