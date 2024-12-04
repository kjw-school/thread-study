plugins {
    id("java")
    id("application")
}

group = "org.kjw"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.openjfx:javafx-base:20.0.2")
    implementation("org.openjfx:javafx-controls:20.0.2")
    implementation("org.openjfx:javafx-fxml:20.0.2")
    implementation("org.openjfx:javafx-graphics:20.0.2")
}

application {
    mainClass.set("org.kjw.reetrantlock_example.Main") // 메인 클래스 이름으로 변경
    applicationDefaultJvmArgs = listOf(
        "--module-path", "/path/to/javafx-sdk/lib", // JavaFX SDK 경로
        "--add-modules", "javafx.controls,javafx.fxml"
    )
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.test {
    useJUnitPlatform()
}