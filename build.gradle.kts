plugins {
    kotlin("multiplatform") version "1.5.30-M1"
    id("com.android.library")
    id("kotlin-android-extensions")
    id("org.jlleitschuh.gradle.ktlint") version "10.0.0"
    `maven-publish`
}

val project_version: String by project
val kotlinx_coroutines_version: String by project

group = "uk.co.andrewreed"
version = project_version

repositories {
    google()
    jcenter()
    mavenCentral()
    mavenLocal()
}

val kermit_version: String by project
val json_rpc_version: String by project

kotlin {
    android {
        publishLibraryVariants("release", "debug")
    }
    iosX64("ios") {
        binaries {
            framework {
                baseName = "web3"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("co.touchlab:kermit:$kermit_version")
                implementation("uk.co.andrewreed:jsonrpc-kotlin-client:$json_rpc_version")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinx_coroutines_version")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.google.android.material:material:1.2.1")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinx_coroutines_version")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13")
            }
        }
        val iosMain by getting {
            dependencies {
            }
        }
        val iosTest by getting
    }
}

android {
    compileSdkVersion(29)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(29)
    }
    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

ktlint {
    version.set("0.41.0")
}
