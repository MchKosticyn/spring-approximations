import gradle.kotlin.dsl.accessors._97fddd71138b33e4dd1c6e1c7bd55d33.main
import gradle.kotlin.dsl.accessors._97fddd71138b33e4dd1c6e1c7bd55d33.publishing
import gradle.kotlin.dsl.accessors._97fddd71138b33e4dd1c6e1c7bd55d33.runtimeClasspath
import gradle.kotlin.dsl.accessors._97fddd71138b33e4dd1c6e1c7bd55d33.sourceSets
import org.gradle.api.Project
import org.gradle.api.file.DuplicatesStrategy
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register

fun Project.addPublish() {
    tasks.register<Jar>("fatJar") {
        archiveBaseName.set("${project.name}-fat")
        archiveVersion.set("${project.version}")

        from(sourceSets.main.get().output)

        from({
            configurations.runtimeClasspath.get()
                .filter { it.name.endsWith(".jar") }
                .map { zipTree(it) }
        })

        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }

    tasks.register<Jar>("sourcesJar") {
        archiveClassifier.set("sources")
        from(sourceSets.main.get().allJava)
    }

    publishing {
        publications {
            create<MavenPublication>("maven") {
                artifact(tasks["fatJar"])
                artifact(tasks["sourcesJar"])
            }
        }
    }
}
