import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.0"
    kotlin("plugin.spring") version "1.6.0"
}

group = "com.lightswitch"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter") {
        exclude("org.springframework.boot", "spring-boot-starter-logging")
    }

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.apache.hadoop:hadoop-common:3.3.1")
    testImplementation("org.apache.hadoop:hadoop-hdfs:3.3.1")
    implementation("org.apache.hadoop:hadoop-mapreduce-client-core:3.3.1")

    implementation("org.apache.solr:solr-solrj:8.11.0")
    implementation("org.apache.solr:solr-core:8.11.0")
    implementation("org.apache.solr:solr-common:1.3.0")

    implementation("org.jsoup:jsoup:1.14.3")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
