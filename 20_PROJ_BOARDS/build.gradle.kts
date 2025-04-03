plugins {
    application
}

application {
    mainClass.set("br.com.dio.Main")
}

group = "org.example"
version = "1.0-SNAPSHOT"

val mapstructVersion = "1.5.5.Final"
val lombokVersion = "1.18.30"
val lombokMapstructBinding = "0.2.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.mapstruct:mapstruct:$mapstructVersion")
    implementation("org.projectlombok:lombok-mapstruct-binding:$lombokMapstructBinding")
    implementation("org.liquibase:liquibase-core:4.29.1")
    implementation("mysql:mysql-connector-java:8.0.33")
    compileOnly("org.projectlombok:lombok:$lombokVersion")

    annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:$lombokMapstructBinding")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
}
