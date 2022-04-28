import org.springframework.boot.gradle.plugin.SpringBootPlugin.*

plugins {
    /*Java程序*/
    java

    /*类库*/
    //java-library

    /*应用*/
    //application

    /*Spring boot plugin*/
    id("org.springframework.boot") version "2.6.7"

}

apply(plugin = "io.spring.dependency-management")

repositories {
    maven {
        setUrl("https://maven.xpaas.lenovo.com/nexus/content/repositories/public/")
    }
    mavenCentral()
}

dependencies {
    /*spring boot*/
//    implementation(platform(BOM_COORDINATES))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-actuator:")

    /*test*/
    testImplementation(platform("org.junit:junit-bom:5.8.2"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks {
    test {
        useJUnitPlatform()
    }
}