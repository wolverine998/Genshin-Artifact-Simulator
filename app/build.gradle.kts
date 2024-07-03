
plugins {
    id("com.android.application")
}

android {
    namespace = "com.genshin.artifactsimulator"
    compileSdk = 33
    
    signingConfigs {
        create("release") {
            storeFile = file("../release-key.keystore")
            storePassword = "ejub123"
            keyAlias = "release-key"
            keyPassword = "ejub123"
        }
    }
    
    defaultConfig {
        applicationId = "com.genshin.artifactsimulator"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.1"
        
        vectorDrawables { 
            useSupportLibrary = true
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("release")
        }
    }

    buildFeatures {
        viewBinding = true
        
    }
    
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.9.0")
}