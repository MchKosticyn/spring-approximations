@file:Suppress("VulnerableLibrariesLocal")

plugins {
    springPlugin("3.3.4")
    id("approximations.spring.spring-base")
    id(Plugins.Shadow.id)
}

addSpringDependencies()

addUsvmApiDependencies()

dependencies {
    compileOnly(project(":approximations-common"))
}

approximationsSourceEntry("v3xx")
