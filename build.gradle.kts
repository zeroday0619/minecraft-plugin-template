import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {              
    kotlin("jvm") version "1.5.31"
}

group = "com.github.zeroday0619"
version = "1.0-SNAPSHOT"

repositorys {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_16.toString()
    }
}