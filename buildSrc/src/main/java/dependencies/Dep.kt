package dependencies

object Dep {

    object Versions {
        const val compose = "1.0.5"
        const val kotlin = "1.5.31"
    }

    object Kotlin {
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1"
    }

    object Jetpack {
        const val appcompat = "androidx.appcompat:appcompat:1.4.0"
        const val core = "androidx.core:core-ktx:1.7.0"
    }

    object Compose {
        const val activity = "androidx.activity:activity-compose:1.3.1"
        const val navigation = "androidx.navigation:navigation-compose:2.4.0-alpha10"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"

        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val materialIcons = "androidx.compose.material:material-icons-extended:${Versions.compose}"
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"

        const val coil = "io.coil-kt:coil-compose:1.4.0"
    }

    object Koin {
        private const val koinVersion = "3.1.4"
        const val android = "io.insert-koin:koin-android:$koinVersion"
        const val compose = "io.insert-koin:koin-androidx-compose:$koinVersion"
        const val navigation = "io.insert-koin:koin-androidx-navigation:$koinVersion"
    }

    object Network {
        private const val okhttpVersion = "4.9.3"
        const val okhttp = "com.squareup.okhttp3:okhttp:$okhttpVersion"
        const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:$okhttpVersion"
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val retrofitConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
    }

    object AndroidTest {
        const val junit = "androidx.test.ext:junit:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
    }
}
