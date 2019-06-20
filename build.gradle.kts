plugins {
	kotlin("multiplatform") version "1.3.40"
}

group = "kotlin-native-test"
version = "0.9.0"

kotlin {
	iosX64 {
		binaries {
			framework(project.name)
		}
	}

	sourceSets {
		getByName("iosX64Main") {
			dependencies {
				api("team.genki:chotto-client:0.9.35")
			}
		}
	}
}

repositories {
	bintray("fluidsonic/maven")
	bintray("genki/maven")
	bintray("kotlin/kotlinx")
	bintray("kotlin/ktor")
	mavenCentral()
}


fun RepositoryHandler.bintray(name: String): MavenArtifactRepository =
	maven("https://dl.bintray.com/$name")
