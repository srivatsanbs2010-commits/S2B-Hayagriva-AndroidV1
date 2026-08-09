plugins {
    id 'com.android.application' version '8.7.3'
}

android {
    namespace 'com.s2b.hayagriva'
    compileSdk 35

    defaultConfig {
        applicationId 'com.s2b.hayagriva"
        minSdk 24
        targetSdk 35
        versionCode 1
        versionName "1.0"
    }

    buildTypes {
        release {
            minifyEnabled false
        }

        debug {
            debuggable true
        }
    }

    sourceSets {
        main {
            manifest.srcFile 'AndroidManifest.xml'
            java.srcDirs = ['.']
            res.srcDirs = ['res']
        }
    }
}
