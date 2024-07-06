plugins {
    id("java")
}

group = "org.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // https://mvnrepository.com/artifact/org.apache.zookeeper/zookeeper
    implementation("org.apache.zookeeper:zookeeper:3.9.2")
    // https://mvnrepository.com/artifact/org.apache.curator/curator-framework
    implementation("org.apache.curator:curator-framework:5.7.0")
    // https://mvnrepository.com/artifact/org.apache.curator/curator-recipes
    implementation("org.apache.curator:curator-recipes:5.7.0")
}

tasks.test {
    useJUnitPlatform()
}