object Versions {
    val supportLibVersion = "27.1.0"
    val moxyVersion = "1.5.3"
    val roomVersion = "1.0.0"
    val gsonVersion = "2.8.2"
    val retrofitVersion = "2.4.0"
    val ankoVersion = "0.10.4"
    val constraintLayoutVersion = "1.0.2"
    val junitVersion = "4.12"
    val testRunnerVersion = "1.0.1"
    val espressoVersion = "3.0.1"
    val coroutinesVersion = "0.22.5"
    val daggerVersion = "2.15"
    val retrofitCoroutinesVersion = "1.0.0"
}

@Suppress("unused")
object Deps {
    val appCompat = "com.android.support:appcompat-v7:${Versions.supportLibVersion}"
    val constraintLayout = "com.android.support.constraint:constraint-layout:${Versions.constraintLayoutVersion}"

    val ankoCommons = "org.jetbrains.anko:anko-appcompat-v7-commons:${Versions.ankoVersion}"
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"

    val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"

    val moxy = "com.arello-mobile:moxy:${Versions.moxyVersion}"
    val moxyCompiler = "com.arello-mobile:moxy-compiler:${Versions.moxyVersion}"
    val moxyAppCompat = "com.arello-mobile:moxy-app-compat:${Versions.moxyVersion}"

    val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    val retrofitGsonAdapter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    val retrofitCoroutinesAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-experimental-adapter:${Versions.retrofitCoroutinesVersion}"

    val room = "android.arch.persistence.room:runtime:${Versions.roomVersion}"
    val roomCompiler = "android.arch.persistence.room:compiler:${Versions.roomVersion}"
    val roomTesting = "android.arch.persistence.room:testing:${Versions.roomVersion}"

    val junit = "junit:junit:${Versions.junitVersion}"
    val testRunner = "com.android.support.test:runner:${Versions.testRunnerVersion}"
    val espressoCore = "com.android.support.test.espresso:espresso-core:${Versions.espressoVersion}"

}