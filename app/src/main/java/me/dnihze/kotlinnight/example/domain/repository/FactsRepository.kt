package me.dnihze.kotlinnight.example.domain.repository

import me.dnihze.kotlinnight.example.domain.CatFact

interface FactsRepository {

    suspend fun getFacts(limit: Int): List<CatFact>

    suspend fun updateFact(fact: CatFact)
}