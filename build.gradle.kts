import org.jetbrains.compose.compose
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.compose") version "1.1.1"
    `java-library`
    `maven-publish`
    jacoco
    signing
}

group = "io.github.app-outlet"
version = "1.0.2"

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "karavel"
            from(components["java"])

            pom {
                name.set("Karavel")
                description.set("Lightweight navigation library for Compose for Desktop")
                url.set("https://github.com/app-outlet/karavel")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://github.com/app-outlet/karavel/blob/main/LICENSE")
                    }
                }
                developers {
                    developer {
                        id.set("messiaslima")
                        name.set("Messias Junior")
                        email.set("messiaslima.03@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/app-outlet/karavel.git")
                    developerConnection.set("scm:git:ssh://github.com/app-outlet/karavel.git")
                    url.set("https://github.com/app-outlet/karavel")
                }
            }
        }
    }
    repositories {
        maven {
            val releasesRepoUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            val snapshotsRepoUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")

            name = "OSSRH"
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl

            credentials {
                username = System.getenv("OSSRH_USERNAME")
                password = System.getenv("OSSRH_PASSWORD")
            }
        }
    }
}

signing {
    useInMemoryPgpKeys(
        System.getenv("GPG_KEY_ID"),
        System.getenv("GPG_SECRET_KEY"),
        System.getenv("GPG_PASSWORD")
    )
    sign(publishing.publications["maven"])
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
}

dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    implementation(compose.desktop.currentOs)
}