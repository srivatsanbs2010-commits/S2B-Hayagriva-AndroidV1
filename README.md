# S2B Hayagriva — Android V1

A Kotlin + Jetpack Compose foundation for the S2B Hayagriva AI assistant.

## Included now
- Always-dark Hayagriva UI
- Home / Voice / Vision / Settings navigation
- AI state indicator scaffold
- Voice-mode UI
- Wake-word foreground-service scaffold
- Multilingual settings placeholder
- Math / Coding / Research quick actions
- Camera/vision integration point
- Permission declarations for core Android capabilities

## Next integrations
1. Gemini/LLM backend
2. Streaming speech-to-text and text-to-speech
3. On-device "Hey Hayagriv" wake word
4. CameraX + multimodal vision
5. Android Accessibility Service for screen/context automation
6. Calls/SMS/calendar/files with explicit Android permissions
7. Location, weather and news providers
8. PDF/image generation
9. Receipt/expense OCR
10. Device-to-device / TV / smartwatch integrations

## Build
Open this folder in Android Studio and let Gradle sync.

Then select:
app > Build > Build APK(s)

Debug APK output:
app/build/outputs/apk/debug/app-debug.apk

## Important
API keys should not be hard-coded into the APK. Put model/provider credentials behind a secure backend.
Some features (background microphone, SMS/calls, accessibility automation, etc.) are restricted by Android and require explicit user consent and platform-compliant implementation.


## V1.1 Thinking HUD
- Added the supplied S2B Hayagriv HUD image as `hayagriva_thinking_hud.png`.
- When Hayagriva enters THINKING state, the HUD is displayed with continuous 3D-style Y rotation and X-axis tilt.
- The thinking state is held for 2.5 seconds in the current demo so the animation is visible.
- The supplied image remains a static texture; the 3D effect is created in Jetpack Compose using `graphicsLayer`.
