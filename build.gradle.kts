import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("approximations.spring.spring-base")
    id("com.gradleup.shadow") version "8.3.3"
    `maven-publish`
}

dependencies {
    implementation(project("approximations-common"))
    implementation(project("approximations-3-x-x"))
}

val publicationJar = tasks.register<ShadowJar>("publicationJar") {
    duplicatesStrategy = DuplicatesStrategy.WARN
    from(project.configurations.runtimeClasspath.get())
    mergeServiceFiles()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifact(publicationJar.get())
        }
    }
}
