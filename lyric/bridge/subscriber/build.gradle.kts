plugins {
    alias(libs.plugins.android.library)
    kotlin("plugin.serialization") version "2.1.21"
    id("kotlin-parcelize")
    signing
    id("com.vanniktech.maven.publish")
}

android {
    namespace = "io.github.proify.lyricon.subscriber"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        buildConfig = true
        aidl = true
    }
}

dependencies {
    api(project(":lyric:model"))
    api(libs.kotlinx.serialization.json)

    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}