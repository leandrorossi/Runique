plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
    namespace = "com.leandrour.analytics.presentation"
}

dependencies {
    implementation(projects.analytics.domain)
}