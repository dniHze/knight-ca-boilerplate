package me.dnihze.kotlinnight.example.data.repository

import kotlinx.coroutines.experimental.delay
import me.dnihze.kotlinnight.example.data.db.source.LocalCatFactDS
import me.dnihze.kotlinnight.example.data.net.source.RemoteCatFactDS
import me.dnihze.kotlinnight.example.domain.CatFact
import me.dnihze.kotlinnight.example.domain.repository.FactsRepository
import java.io.IOException
import javax.inject.Inject

class FactsRepositoryImpl @Inject constructor(
        private val localDS: LocalCatFactDS,
        private val remoteDS: RemoteCatFactDS
) : FactsRepository {

    override suspend fun getFacts(limit: Int): List<CatFact> {
        val facts = localDS.getCatFacts(limit)
        return if (facts.isEmpty()) {
            val newFacts = retryIO { remoteDS.getFacts(limit) }
            localDS.run {
                storeCatFacts(newFacts)
                getCatFacts(limit)
            }
        } else {
            facts
        }
    }

    override suspend fun updateFact(fact: CatFact) {
        localDS.updateCatFact(fact)
    }

    private suspend fun <T> retryIO(retryCount: Int = 3, block: suspend () -> T): T {
        var countOfRetry = 0
        var currentDelay = 1000L
        while (true) {
            try {
                return block()
            } catch (e: IOException) {
                if (countOfRetry >= retryCount) {
                    throw e
                } else {
                    e.printStackTrace()
                    countOfRetry++
                }
            }
            delay(currentDelay)
            currentDelay = (currentDelay * 2).coerceAtMost(60_000L)
        }
    }
}