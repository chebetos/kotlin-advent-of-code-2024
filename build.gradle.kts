plugins {
    kotlin("jvm") version "2.1.0"
    application
}

group = "es.chebetos.advent2024"
version = "1.0-SNAPSHOT"

dependencies {
    testImplementation(kotlin("test"))
    implementation(kotlin("stdlib-jdk8"))
}

kotlin {
    jvmToolchain(21)
}

tasks {
    test {
        useJUnitPlatform()
    }
    wrapper {
        gradleVersion = "8.11.1"
    }
}
