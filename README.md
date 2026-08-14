# S2B Hayagriva Android V1

Clean Android/Jetpack Compose project designed to build directly with GitHub Actions.

## Build

Gradle task:

    assembleDebug

APK output:

    build/outputs/apk/debug/S2B-Hayagriva-AndroidV1-debug.apk

This project intentionally keeps the Android module at the repository root, so there is no `app/` module. The GitHub Actions workflow therefore runs the root `assembleDebug` task.
