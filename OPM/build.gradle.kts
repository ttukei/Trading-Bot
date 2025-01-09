plugins {
    id("java")
    id("application")
}

group = "me.timontukei"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("io.github.cdimascio:dotenv-java:3.1.0")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.0")
}

application {
    mainClass.set("me.timontukei.opm.api.CryptoPanicClient")
}
tasks.test {
    useJUnitPlatform()
}