# Translator Kotlin Multiplatform App

<<< In progress ⚒️ >>>

This repository contains an application developed in Kotlin Multiplatform (KMP) that uses Jetpack Compose on the Android side and SwiftUI on the iOS side. The architecture of the application is based on the MVVM (Model-View-ViewModel) pattern and makes use of Flows for reactive data management.

## Philip Lackner's Course
This project is part of the course offered by Philip Lackner. You can find more information about the course [here](https://pl-coding.com/building-industry-level-multiplatform-apps-with-kmm/).

## Project Setup
### Prerequisites
- Make sure you have [Android Studio](https://developer.android.com/studio) installed for Android development.
- Make sure you have [Kotlin Multiplatform plugin]([https://developer.android.com/studio](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform-mobile)) installed.
- For iOS development, you'll need a Swift development environment and Xcode installed on your system.

### Setup Instructions
1. Clone this repository on your local machine:
    ```bash
    git clone https://github.com/yourusername/reponame.git
    ```

2. Open the project in Android Studio to work on the Android platform.

3. For iOS development, open the project in Xcode and ensure you have the proper Swift configuration.

## Project Structure
- Shared code between platforms is located in the `shared` directory.
- Android-specific implementation is in the `composeApp` directory.
- iOS-specific implementation is in the `iosApp` directory.

## Technologies Used
- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [SwiftUI](https://developer.apple.com/documentation/swiftui)
- [Flows](https://kotlinlang.org/docs/flows.html)
- MVVM (Model-View-ViewModel)
- SOLID principles
