pluginManagement {
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
