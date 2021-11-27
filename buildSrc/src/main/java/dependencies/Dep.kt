package dependencies

object Dep {

    object Kotlin {
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1"
    }

    object Google {
        const val material = "com.google.android.material:material:1.4.0"
    }

    object Jetpack {
        const val appcompat = "androidx.appcompat:appcompat:1.4.0"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.2"
        const val core = "androidx.core:core-ktx:1.7.0"
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:2.4.0"
        const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0"
    }

    object Koin {
        private const val koinVersion = "3.1.3"
        const val android = "io.insert-koin:koin-android:$koinVersion"
        const val compose = "io.insert-koin:koin-androidx-compose:$koinVersion"
        const val navigation = "io.insert-koin:koin-androidx-navigation:$koinVersion"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
    }

    object AndroidTest {
        const val junit = "androidx.test.ext:junit:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
    }
}
