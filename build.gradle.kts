plugins {
    id("com.android.library") version "8.0.0-rc01" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.android.application") version "8.0.0-rc01" apply false
}


allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()  // Add this line to include JCenter
    }
}