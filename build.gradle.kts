plugins {
    kotlin("multiplatform") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
    id("org.jlleitschuh.gradle.ktlint") version "10.0.0"
    id("com.android.library") version "7.2.2"
    `maven-publish`
}

val project_version: String by project
val kotlinx_coroutines_version: String by project

val projectGithubUrl: String by project
val projectGithubSCM: String by project
val projectGithubSCMSSL: String by project
val projectDescription: String by project

val developerId: String by project
val developerName: String by project
val developerEmail: String by project

group = "uk.co.andrewreed"
version = project_version

repositories {
    maven {
        name = "github"
        url = uri("https://maven.pkg.github.com/reedyuk/jsonrpc-kotlin-client")
    }
    google()
    mavenCentral()
    mavenLocal()
}

val kermit_version: String by project
val json_rpc_version: String by project
val secp256k1_version: String by project

kotlin {
    android {
        publishLibraryVariants("release", "debug")
    }
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    ios("ios") {
        binaries.framework {
            baseName = "web3"
        }
    }
    iosSimulatorArm64 {
        binaries.framework {
            baseName = "web3"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("co.touchlab:kermit:$kermit_version")
                implementation("uk.co.andrewreed:jsonrpc-kotlin-client:$json_rpc_version")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinx_coroutines_version")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.1.0")
                implementation("com.ionspin.kotlin:bignum:0.3.7")
                //implementation("fr.acinq.secp256k1:secp256k1-kmp:$secp256k1_version")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
//                implementation("com.google.android.material:material:1.2.1")
//                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinx_coroutines_version")
                //implementation("fr.acinq.secp256k1:secp256k1-kmp-jni-android:$secp256k1_version")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13")
            }
        }

        val jvmMain by getting {
            dependencies {
//                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinx_coroutines_version")
            }
        }
        val jvmTest by getting {
            dependencies {
//                implementation("junit:junit:4.13")
            }
        }
        val iosMain by getting {
            dependencies {
            }
        }
        val iosTest by getting

        val iosSimulatorArm64Main by getting
        iosSimulatorArm64Main.dependsOn(iosMain)

        val iosSimulatorArm64Test by getting
        iosSimulatorArm64Test.dependsOn(iosTest)
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

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/reedyuk/web3kotlin")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }

    publications.all {
        this as MavenPublication

        pom {
            name.set(group as String)
            description.set(projectDescription)
            url.set(projectGithubUrl)

            licenses {
                license {
                    name.set("MIT License")
                    url.set("http://opensource.org/licenses/MIT")
                }
            }

            developers {
                developer {
                    id.set(developerId)
                    name.set(developerName)
                    email.set(developerEmail)
                }
            }

            scm {
                url.set(projectGithubUrl)
                connection.set(projectGithubSCM)
                developerConnection.set(projectGithubSCMSSL)
            }
        }
    }
}

