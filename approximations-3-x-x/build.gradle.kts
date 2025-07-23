@file:Suppress("VulnerableLibrariesLocal")

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar


plugins {
    springPlugin("3.3.4")
    id("approximations.spring.spring-base")
    id(Plugins.Shadow)
}

addSpringDependencies()

addUsvmApiDependencies()

dependencies {
    compileOnly(project(":approximations-common"))
}

tasks.withType<ShadowJar> {
    val packages = listOf("decoders", "encoders", "stub", "generated")
    val prefix = "v3xx"
    packages.forEach { relocate(it, "$prefix.$it") }
}
