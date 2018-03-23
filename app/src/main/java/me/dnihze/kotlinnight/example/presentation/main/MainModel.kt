package me.dnihze.kotlinnight.example.presentation.main

import me.dnihze.kotlinnight.example.domain.CatFact

data class MainModel(
        val isLoading: Boolean,
        val error: Exception? = null,
        val data: List<CatFact> = listOf()
)