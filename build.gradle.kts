
plugins {
    java
    application
    id("org.springframework.boot") version "3.2.0"
}
apply(plugin = "io.spring.dependency-management")

group = "2023.aoc"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("main.Application")
}

springBoot {
    mainClass.set("main.Application")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework:spring-context")
    testImplementation("org.springframework:spring-context")

    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    testCompileOnly("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
