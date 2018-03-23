package me.dnihze.kotlinnight.example.domain

data class CatFact(
        val id: String,
        val fact: String,
        val length: Int,
        val isLiked: Boolean = false
) {
    fun meow() = "I can do meow!"
}