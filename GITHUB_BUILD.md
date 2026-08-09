# Build S2B Hayagriva APK with GitHub Actions

This project is configured to build an installable **debug APK** automatically in GitHub Actions.

## 1. Create a GitHub repository

Create a new empty repository, for example:

`S2B-Hayagriva-Android`

## 2. Upload the project

Extract this ZIP and upload the contents of the `S2B_Hayagriva` folder to the repository root.

The repository should contain:

- `app/`
- `gradle.properties`
- `settings.gradle.kts`
- `build.gradle.kts`
- `.github/workflows/android-apk.yml`

## 3. Run the build

Push to `main`/`master`, or open:

**GitHub → Actions → Build S2B Hayagriva APK → Run workflow**

The workflow installs Android SDK 35, uses JDK 17 and Gradle 8.9, and runs:

`gradle assembleDebug`

## 4. Download the APK

When the workflow finishes:

**Actions → Build S2B Hayagriva APK → completed run → Artifacts → S2B-Hayagriva-debug-APK**

Download the artifact ZIP, extract it, and you will find:

`app-debug.apk`

Copy that APK to your Android phone and install it.

## Important

This is a debug APK, which is suitable for direct testing on your own Android device.
It is not a Play Store release. A future release build can use a GitHub Actions signing key stored in GitHub Secrets.

## Current Hayagriva V1.1 features

- Dark Hayagriva UI
- Home / Voice / Vision / Settings
- AI state indicator
- Thinking HUD image
- 3D-style rotating/tilting HUD while THINKING
- Voice service scaffold
- Camera/vision integration point
- Math / Coding / Research quick actions
- English / Hindi / Tamil settings foundation
