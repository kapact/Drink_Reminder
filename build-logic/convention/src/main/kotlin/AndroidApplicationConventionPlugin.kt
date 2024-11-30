import com.akshaw.convention.Android
import com.akshaw.convention.buildFeaturesCompose
import com.akshaw.convention.configureKotlinAndroid
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("kotlin-kapt")
                apply("com.google.devtools.ksp")
                apply("org.jetbrains.kotlin.plugin.compose")
            }
            
            extensions.configure(ApplicationExtension::class.java) {
                configureKotlinAndroid(this)
                targetSdk()
                buildFeaturesCompose()
            }
            
        }
    }
}

fun ApplicationExtension.targetSdk() {
    defaultConfig.targetSdk = Android.Sdk.TARGET
}


