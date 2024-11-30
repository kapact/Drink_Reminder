package com.akshaw.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

@Suppress("UnusedReceiverParameter")
internal fun Project.configureKotlinAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.apply {
        buildFeaturesCompose()
    }
}

fun CommonExtension<*, *, *, *, *, *>.buildFeaturesCompose() {
    buildFeatures {
        compose = true
        buildConfig = true
    }
}
