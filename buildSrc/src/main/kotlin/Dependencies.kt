import gradle.kotlin.dsl.accessors._2c95f20277cbe6143532f6e8d67e36cc.compileOnly
import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.PluginDependenciesSpecScope
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.version

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
