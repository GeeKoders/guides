plugins {
    id("com.gradle.build-scan") version "2.3"
    id("org.gradle.guides.getting-started") version "0.15.8"
}

configure<org.gradle.guides.GuidesExtension> {
    repoPath = "gradle-guides/executing-gradle-builds-on-travisci"
    mainAuthor = "Benjamin Muschko"
    minimumGradleVersion.set("4.10.3")
}

buildScan {
    setTermsOfServiceUrl("https://gradle.com/terms-of-service")
    setTermsOfServiceAgree("yes")
    if (!System.getenv("CI").isNullOrEmpty()) {
        publishAlways()
        tag("CI")
    }
}
