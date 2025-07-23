import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("approximations.spring.spring-base")
    id("com.gradleup.shadow") version "8.3.3" apply false
    `maven-publish`
}

val publicationJar = tasks.register<ShadowJar>("publicationJar") {
    project.allprojects
        .filter { it.plugins.hasPlugin(Plugins.Shadow.id) && it != project}
        .forEach {
            dependsOn(it.tasks["shadowJar"])
            from(it.tasks["shadowJar"].outputs.files.single())
        }

    mergeServiceFiles()
}

publishing {
    repositories {
        maven {
            name = "releaseDir"
            url = uri(layout.buildDirectory.dir("release"))
        }
    }

    publications {
        create<MavenPublication>("maven") {
            artifact(publicationJar)
        }
    }
}