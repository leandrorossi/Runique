plugins {
    alias(libs.plugins.runique.android.library)
}

android {
    namespace = "com.leandrour.wear.run.data"

    defaultConfig {
        minSdk = 30
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.health.services.client)
    implementation(libs.bundles.koin)

    implementation(projects.wear.run.domain)
    implementation(projects.core.domain)
}