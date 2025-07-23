@file:Suppress("VulnerableLibrariesLocal")

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.gradle.kotlin.dsl.withType

plugins {
    springPlugin("3.3.4")
    id("approximations.spring.spring-base")
    id(Plugins.Shadow)
}

addSpringDependencies()

addUsvmApiDependencies()

tasks.withType<ShadowJar> {
    val packages = listOf("decoders", "encoders", "stub", "generated")
    val prefix = "common"
    packages.forEach { relocate(it, "$prefix.$it") }
}
