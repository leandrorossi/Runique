plugins {
    alias(libs.plugins.runique.android.dynamic.feature)
}
android {
    namespace = "com.leandrour.analytics.analytics_feature"
}

dependencies {
    implementation(project(":app"))
    implementation(libs.androidx.navigation.compose)
    implementation(libs.google.android.play.feature.delivery)

    api(projects.analytics.presentation)
    implementation(projects.analytics.domain)
    implementation(projects.analytics.data)
    implementation(projects.core.database)
}