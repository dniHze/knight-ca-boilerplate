package me.dnihze.kotlinnight.example.domain

enum class NetworkState {
    WIFI, CELLULAR, OTHER, NONE, UNKNOWN;

    fun isConnected() = this in arrayOf(WIFI, CELLULAR, OTHER)
}