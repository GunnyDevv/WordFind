plugins {
    java
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.1.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-api:5.1.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.1.0")
    testCompile(group="org.hamcrest", name="hamcrest-all", version= "1.3")

}

tasks.withType<Test> {
    useJUnitPlatform()
}

application {
    mainClassName = "com.gunny.words.Main"
}
