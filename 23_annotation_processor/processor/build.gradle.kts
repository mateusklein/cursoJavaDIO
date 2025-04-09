plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val autoServiceVersion = "1.1.1"

dependencies {
    compileOnly(project(":annotation"))
    implementation(project(":annotation"))

    implementation("com.squareup:javapoet:1.13.0")
    compileOnly("com.google.auto.service:auto-service:$autoServiceVersion")
    annotationProcessor("com.google.auto.service:auto-service:$autoServiceVersion")
}
