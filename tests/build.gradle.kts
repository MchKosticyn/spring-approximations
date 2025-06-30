plugins {
    java
    `maven-publish`
}

group = "org.usvm.approximations.java.stdlib"
version = "0.0.0"

tasks.withType<JavaCompile> {
    options.release = 8
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
