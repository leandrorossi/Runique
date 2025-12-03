pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "Runique"
include(":app")
include(":auth:data")
include(":auth:presentation")
include(":auth:domain")
include(":core:presentation:ui")
include(":core:presentation:designsystem")
include(":core:database")
include(":core:data")
include(":core:domain")
include(":run:data")
include(":run:location")
include(":run:network")
include(":run:presentation")
include(":run:domain")
include(":analytics:data")
include(":analytics:presentation")
include(":analytics:domain")
include(":analytics:analytics_feature")
include(":wear:app")
include(":wear:run:data")
include(":wear:run:presentation")
include(":wear:run:domain")
include(":core:presentation:designsystem_wear")
include(":core:connectivity:domain")
include(":core:connectivity:data")
include(":core:notification")
