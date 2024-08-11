buildscript {
    // Root level dependencies versions
    val kotlinVersion by extra("1.9.10")
    val androidGradlePluginVersion by extra("8.4.0")
    val bintrayVersion by extra("0.9.2")
    val gmsVersion by extra("4.4.0")
    val firebaseCrashlyticsGradleVersion by extra("2.9.9")
    val androidMaterialVersion by extra("1.10.0")
    val appCompatVersion by extra("1.6.1")
    val desugarLibraryVersion by extra("2.0.3")

    repositories {
        jcenter()
        google()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:$androidGradlePluginVersion") {
            description = "Gradle plug-in to build Android applications."
        }
        classpath("com.novoda:bintray-release:$bintrayVersion") {
            description = "A helper for releasing from gradle up to bintray."
        }
        classpath("com.google.gms:google-services:$gmsVersion") {
            description = "A collection of Google applications and APIs that help support functionality across devices."
        }
        classpath("com.google.firebase:firebase-crashlytics-gradle:$firebaseCrashlyticsGradleVersion") {
            description = "Firebase Crashlytics Gradle"
        }
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion") {
            description = "Kotlin Gradle Plugin"
        }
    }
}

allprojects {
    repositories {
        maven { url = uri("https://s3.amazonaws.com/repo.commonsware.com") }
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
        maven { url = uri("https://maven.google.com") }
        mavenCentral()
        jcenter()
        google()
    }
}

ext {
    set("minSdkVersion", 21)
    set("targetSdkVersion", 33)
    set("compileSdkVersion", 34)
    set("buildToolsVersion", "34.0.0")

    set("versionCode", 2011200157)
    set("versionName", "2.15.0")
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}

configurations.all {
    resolutionStrategy {
        failOnVersionConflict()
        preferProjectModules()
    }
}