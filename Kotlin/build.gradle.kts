import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
}

group = "com.gildedrose"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks {
    register("ratchet") {
        dependsOn("test", "commit")
    }

    register("commit") {
        dependsOn("test")

        doLast {
            exec {
                workingDir("./")
                commandLine("git", "add", '.')
                isIgnoreExitValue = true
            }
            exec {
                workingDir("./")
                commandLine("git", "commit", "-m", "wip")
                isIgnoreExitValue = true
            }
        }
    }
}

// config JVM target to 1.8 for kotlin compilation tasks
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "1.8"
}
