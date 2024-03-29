import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
//    id("com.android.library")
}

val kotlinx_coroutines_version = "1.6.3-native-mt"

group = "uk.co.andrewreed"
version = "1.0-SNAPSHOT"

kotlin {
//    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)

//                implementation("uk.co.andrewreed:jsonrpc-kotlin-client:0.0.5")
                implementation("uk.co.andrewreed:web3kotlin:0.0.6")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinx_coroutines_version")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
//        val androidMain by getting {
//            dependencies {
//                api("androidx.appcompat:appcompat:1.2.0")
//                api("androidx.core:core-ktx:1.3.1")
//            }
//        }
//        val androidTest by getting {
//            dependencies {
//                implementation("junit:junit:4.13")
//            }
//        }
        val desktopMain by getting {
            dependencies {
                api(compose.preview)
//                implementation("uk.co.andrewreed:web3kotlin-jvm:0.0.5")
//                implementation("uk.co.andrewreed:jsonrpc-kotlin-client-jvm:0.0.4")

            }
        }
        val desktopTest by getting
    }
}

//android {
//    compileSdkVersion(31)
//    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
//    defaultConfig {
//        minSdkVersion(24)
//        targetSdkVersion(31)
//    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//}
