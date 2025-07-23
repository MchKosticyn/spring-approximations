@file:Suppress("VulnerableLibrariesLocal")

plugins {
    springPlugin("3.3.4")
    id("approximations.spring.spring-base")
    id(Plugins.Shadow.id)
}

addSpringDependencies()

addUsvmApiDependencies()

approximationsSourceEntry("common")
