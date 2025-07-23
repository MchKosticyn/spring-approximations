import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import gradle.kotlin.dsl.accessors._2c95f20277cbe6143532f6e8d67e36cc.compileOnly
import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.PluginDependenciesSpecScope
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.version
import org.gradle.kotlin.dsl.withType
import org.gradle.plugin.use.PluginDependenciesSpec

fun PluginDependenciesSpecScope.springPlugin(version: String) {
    id("org.springframework.boot") version version
    id("io.spring.dependency-management") version "1.1.7"
}

private fun DependencyHandlerScope.springDependencies() {
    compileOnly("org.springframework.boot:spring-boot-starter-security")
    compileOnly("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.springframework.boot:spring-boot-starter-test")
    compileOnly("org.springframework.security:spring-security-test")
    compileOnly("org.springframework.boot:spring-boot-starter-data-jpa")
    compileOnly("org.springframework.boot:spring-boot-starter-validation")
}

fun Project.addSpringDependencies() {
    check(plugins.hasPlugin("org.springframework.boot")) { "spring plugin not found" }
    dependencies {
        springDependencies()
    }
}

fun Project.addUsvmApiDependencies() {
    dependencies {
        compileOnly(files(rootDir.resolve("usvm-api/usvm-jvm-api.jar")))
        compileOnly(files(rootDir.resolve("usvm-api/usvm-jvm-spring-api.jar")))
    }
}

object Plugins {

    abstract class ProjectPlugin(val id: String, val version: String)

    // https://github.com/GradleUp/shadow
    object Shadow : ProjectPlugin(
        id = "com.gradleup.shadow",
        version = "8.3.3"
    )
}

fun PluginDependenciesSpec.id(plugin: Plugins.ProjectPlugin) {
    id(plugin.id).version(plugin.version)
}

fun Project.approximationsSourceEntry(packagePrefix: String) {
    tasks.withType<ShadowJar> {
        val packages = listOf("decoders", "encoders", "stub", "generated")
        packages.forEach { relocate(it, "$packagePrefix.$it") }
    }
}
