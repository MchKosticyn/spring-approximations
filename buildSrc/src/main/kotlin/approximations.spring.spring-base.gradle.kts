plugins {
    java
    `maven-publish`
}

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://jitpack.io")
}

private val jacodbPackage = "com.github.UnitTestBot.jacodb"
private val jacodbVersion = "4ff7243d3a" // jacodb neo branch

val approximationsRepo = "org.usvm.approximations.java.stdlib"
val approximationsVersion = "0.0.0"

dependencies {
    compileOnly("$jacodbPackage:jacodb-api-jvm:$jacodbVersion")
    compileOnly("$jacodbPackage:jacodb-approximations:$jacodbVersion")
    // Fixes "unknown enum constant 'When.MAYBE'" warning
    compileOnly("com.google.code.findbugs:jsr305:3.0.2")
    compileOnly(approximationsRepo, "approximations", approximationsVersion)
}

group = "org.usvm.approximations.spring"
version = "0.0.0"

tasks.withType<JavaCompile> {
    //options.release = 8
    //options.compilerArgs.add("--add-exports=java.base/sun.nio.ch=ALL-UNNAMED")
    options.compilerArgs.add("-target")
    options.compilerArgs.add("1.8")
    options.compilerArgs.add("-source")
    options.compilerArgs.add("1.8")
    options.compilerArgs.add("-Xlint:unchecked")
    options.compilerArgs.add("-Xlint:all")
    options.compilerArgs.add("-Werror")
}
