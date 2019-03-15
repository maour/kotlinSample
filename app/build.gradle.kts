plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
    id("de.mannodermaus.android-junit5")
}

android {
    compileSdkVersion(28)

    dataBinding.isEnabled = true
    defaultConfig {
        applicationId = "com.example.sample"
        buildConfigField("String", "SERVER_URL", "\"https://testcompany.pipedrive.com/api/v1/\"")
        buildConfigField("String", "API_TOKEN", "\"f1afc9a830e64e2084a43612c2a97171209c4dd8\"")
        minSdkVersion(16)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        compileOptions {
            setTargetCompatibility(1.8)
            setSourceCompatibility(1.8)
        }
    }
}

dependencies {
    fileTree(mapOf("includes" to listOf("*.jar"), "dir" to "libs"))

    val kotlinVersion = rootProject.extra.get("kotlin_version").toString()
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.2")
    testImplementation("io.mockk:mockk:1.8.13")
    testImplementation("org.mockito:mockito-core:2.24.5")
    testImplementation("org.mockito:mockito-inline:2.24.5")
    testImplementation("android.arch.core:core-testing:1.1.1")
    testImplementation("com.nhaarman:mockito-kotlin:1.5.0")

    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-contrib:3.0.1")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.1")

    implementation("com.android.support:appcompat-v7:28.0.0")
    implementation("com.android.support:design:28.0.0")
    implementation("com.android.support:support-v4:28.0.0")
    implementation("com.android.support:appcompat-v7:28.0.0")
    implementation("com.android.support:recyclerview-v7:28.0.0")
    implementation("com.android.support:cardview-v7:28.0.0")

    // NETWORK
    implementation("com.squareup.okhttp3:okhttp:3.12.1")
    implementation("com.squareup.okhttp3:logging-interceptor:3.12.1")
    implementation("com.squareup.retrofit2:retrofit:2.5.0")
    implementation("com.squareup.retrofit2:retrofit-converters:2.5.0")
    implementation("com.squareup.retrofit2:converter-gson:2.4.0")
    implementation("com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0")

    // RXJAVA
    implementation("io.reactivex.rxjava2:rxjava:2.1.14")
    implementation("io.reactivex.rxjava2:rxandroid:2.0.1")

    // Dagger2
    implementation("com.google.dagger:dagger:2.15")
    kapt("com.google.dagger:dagger-compiler:2.15")
    implementation("com.google.dagger:dagger-android-support:2.15")
    kapt("com.google.dagger:dagger-android-processor:2.15")
    compileOnly("javax.annotation:jsr250-api:1.0")
    implementation("javax.inject:javax.inject:1")

    // Room
    implementation("android.arch.persistence.room:runtime:1.1.0")
    implementation("android.arch.persistence.room:rxjava2:1.1.0")
    kapt("android.arch.persistence.room:compiler:1.1.0")

    // Arch Component
    implementation("android.arch.lifecycle:livedata:1.1.1")
    implementation("android.arch.lifecycle:common-java8:1.1.1")
    implementation("android.arch.lifecycle:extensions:1.1.1")
    implementation("android.arch.lifecycle:viewmodel:1.1.1")
    implementation("android.arch.lifecycle:reactivestreams:1.1.1")
}
