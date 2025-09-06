@file:Suppress("VulnerableLibrariesLocal")

plugins {
    springPlugin("3.3.4")
    id("approximations.spring.spring-base")
}

addSpringDependencies()

dependencies {
    compileOnly(project(":approximations-common"))
}
