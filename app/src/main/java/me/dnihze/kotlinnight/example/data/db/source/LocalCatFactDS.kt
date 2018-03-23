package me.dnihze.kotlinnight.example.data.db.source

import kotlinx.coroutines.experimental.async
import me.dnihze.kotlinnight.example.data.db.dao.CatFactsDao
import me.dnihze.kotlinnight.example.data.db.mapper.DBFactMapper
import me.dnihze.kotlinnight.example.data.db.mapper.DomainFactMapper
import me.dnihze.kotlinnight.example.domain.CatFact
import javax.inject.Inject

class LocalCatFactDS @Inject constructor(
        private val dao: CatFactsDao
) {
    private val dbMapper by lazy { DBFactMapper() }
    private val domainMapper by lazy { DomainFactMapper() }

    suspend fun getCatFacts(limit: Int): List<CatFact> {
        val facts = async { dao.getFacts(limit) }.await()
        return domainMapper.map(facts)
    }

    suspend fun storeCatFacts(catFacts: List<CatFact>) {
        val dbFacts = dbMapper.map(catFacts)
        async {
            dao.saveFacts(dbFacts)
        }.await()
    }

    suspend fun updateCatFact(catFact: CatFact) {
        val dbFact = dbMapper.map(catFact)
        async {
            dao.updateFact(dbFact)
        }.await()
    }
}