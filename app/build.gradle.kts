plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //id("com.android.application")
    id("com.google.gms.google-services")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.reader_app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.reader_app"
        minSdk = 24
        //noinspection EditedTargetSdkVersion
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

// Firebase/firestore
    implementation(platform("com.google.firebase:firebase-bom:33.7.0"))
    // Google Sign In SDK
    implementation("com.google.android.gms:play-services-auth:20.5.0")

    // Firebase SDK
    implementation("com.google.firebase:firebase-database-ktx")
    implementation("com.google.firebase:firebase-storage-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")

    // Firebase UI Library
    implementation("com.firebaseui:firebase-ui-auth:8.0.2")
    implementation("com.firebaseui:firebase-ui-database:8.0.2")
    implementation(libs.firebase.firestore.ktx)

// Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.51")
    kapt("com.google.dagger:hilt-android-compiler:2.51")

// Hilt Extensions for AndroidX
    implementation("androidx.hilt:hilt-work:1.0.0")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.hilt:hilt-navigation-fragment:1.0.0")


//    // Coroutines
//    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
//    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")
//    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.9.0")
//
//    // Coroutine Lifecycle Scopes
//    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
//    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
//
//    // Coil
//    implementation("io.coil-kt:coil-compose:2.7.0")
//
//    // Retrofit
//    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
//
//    // OkHttp
//    //implementation("com.squareup.okhttp3:okhttp:5.0.0")
//
//    // JSON Converter
//    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}