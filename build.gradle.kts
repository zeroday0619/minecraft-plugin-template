import org.gradle.kotlin.dsl.support.zipTo

plugins {
    kotlin("jvm") version "1.4.21"
    kotlin("plugin.serialization") version "1.4.21"
    id("kr.entree.spigradle") version "2.2.3"
}


group = "com.github.zeroday0619"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.heartpattern.kr/repository/maven-public/")
    maven("https://papermc.io/repo/repository/maven-public/")
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("io.papermc:paperlib:1.0.6")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")
    compileOnly("com.destroystokyo.paper:paper-api:1.16.4-R0.1-SNAPSHOT")
}

val shade = configurations.create("shade")
shade.extendsFrom(configurations.implementation.get())

tasks {
    jar {
        from(
            shade.map {
                if (it.isDirectory)
                    it
                else
                    zipTree(it)
            }
        )
    }
}
