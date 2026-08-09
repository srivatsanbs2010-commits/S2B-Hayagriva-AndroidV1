plugins {
    id("com.android.application") version "8.7.3" apply false
    id("org.jetbrains.kotlin.android") version "2.0.21" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21" apply false
}

android {
    namespace 'com.s2b.hayagriva'
    compileSdk 35

    defaultConfig {
        applicationId 'com.s2b.hayagriva'
        minSdk 24
        targetSdk 35
        versionCode 1
        versionName '1.0'
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_17
        targetCompatibility JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = '17'
    }

    buildFeatures {
        compose true
    }
}

dependencies {
    implementation 'androidx.core:core-ktx:1.15.0'
    implementation 'androidx.activity:activity-compose:1.10.1'

    implementation platform('androidx.compose:compose-bom:2025.01.00')

    implementation 'androidx.compose.ui:ui'
    implementation 'androidx.compose.ui:ui-tooling-preview'
    implementation 'androidx.compose.material3:material3'

    debugImplementation 'androidx.compose.ui:ui-tooling'
}
