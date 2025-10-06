# YouTubeCleanPlay - Plan A (Source)

This is the source scaffold for the YouTubeCleanPlay Android app (Kotlin).
It uses the YouTube IFrame Player inside a WebView and a foreground audio service
to attempt background audio playback (best-effort).

## Included files
- app/src/main/AndroidManifest.xml
- app/build.gradle
- settings.gradle
- build.gradle (project-level)
- app/src/main/java/com/example/ytcleanplay/MainActivity.kt
- app/src/main/java/com/example/ytcleanplay/AudioForegroundService.kt
- app/src/main/res/layout/activity_main.xml
- app/src/main/assets/player.html
- README.md (this file)

## How to build APK locally (step-by-step)
1. Install Android Studio (Arctic Fox or newer) with Android SDK for API 34.
2. Open Android Studio -> File -> New -> Import Project, choose the folder containing this source (the `YouTubeCleanPlay_source` root).
3. Let Gradle sync. Set Gradle JDK to Java 17 if prompted.
4. Build -> Build Bundle(s) / APK(s) -> Build APK(s).
5. The built APK will appear in `app/build/outputs/apk/`.

## Notes
- This project is a minimal scaffold. For production you should add:
  - Proper error handling, permissions, proguard, secure signing config.
  - Robust MediaSession and notification controls.
  - YouTube Data API integration (requires API key).
- Background playback behavior may vary by OEM and Android version.

## If you want me to produce a CI script to auto-build the APK (GitHub Actions),
I can add a `/.github/workflows/build.yml` file to automate building and artifact upload.
