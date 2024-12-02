import org.gradle.api.JavaVersion.VERSION_17
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.akshaw.buildlogic"

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}

java {
    sourceCompatibility = VERSION_17
    targetCompatibility = VERSION_17
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = VERSION_17.toString()
    }
}

gradlePlugin {
    
    plugins {
        
        // Android application
        register("androidApplication") {
            id = "custom.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        
        
        // Android library
        register("androidLibrary") {
            id = "custom.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        
        register("androidLibraryCompose") {
            id = "custom.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
    }
    
}