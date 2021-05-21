import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    id("com.github.ben-manes.versions") version "0.36.0"
    base // adds clean task to root project
}

subprojects {
    repositories {
        mavenCentral()
        google()
        jcenter() // Cannot remove jcenter as of now because flexbox depends on it
    }
}
buildscript {
    repositories {
        google()  // Google's Maven repository
    }
    dependencies {
        // Add this line
        classpath ("com.google.gms:google-services:4.3.8")
    }
}

allprojects {
    repositories {
        // Check that you have the following line (if not, add it):
        google()  // Google's Maven repository
    }
}
// for dependency updates task, only display versions that aren't tagged with alpha or beta
tasks.named<DependencyUpdatesTask>("dependencyUpdates").configure {
    rejectVersionIf {
        "alpha" in candidate.version || "beta" in candidate.version
    }
}
