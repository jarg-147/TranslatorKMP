import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.hiltPlugin)
    kotlin("kapt")
    kotlin("plugin.serialization") version (libs.versions.kotlin.get())
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)
            implementation(libs.kotlinx.coroutines.android)
            implementation(libs.material3)

            implementation(project.dependencies.platform(libs.compose.bom))
            implementation(libs.androidx.activity.compose)
            implementation(libs.compose.ui.tooling)
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.compose.navigation)
            implementation(libs.compose.icons)
            implementation(compose.ui)
            implementation(compose.runtime)
            implementation(compose.foundation)

            implementation(libs.coil.compose)
            implementation(libs.ktor.client.android)

            implementation(libs.hilt.android)
            configurations["kapt"].dependencies.add(libs.hilt.compiler.get())
            implementation(libs.hilt.navigation.compose)

            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
            implementation(projects.shared)
        }
    }
}

android {
    namespace = "com.jarg.translator"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "com.jarg.translator"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    dependencies {
        debugImplementation(libs.compose.ui.tooling)
        androidTestImplementation(libs.compose.test.runner)
        androidTestImplementation(libs.junit)
        androidTestImplementation(libs.compose.testing)
        androidTestImplementation(libs.androidx.test.rules)
        debugImplementation(libs.compose.testing.manifest)

        androidTestImplementation(libs.hilt.testing)
    }
}

