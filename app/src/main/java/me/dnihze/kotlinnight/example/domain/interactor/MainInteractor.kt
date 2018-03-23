package me.dnihze.kotlinnight.example.domain.interactor

import kotlinx.coroutines.experimental.channels.BroadcastChannel
import me.dnihze.kotlinnight.example.domain.CatFact
import me.dnihze.kotlinnight.example.domain.repository.FactsRepository
import javax.inject.Inject

class MainInteractor @Inject constructor(
        private val factsRepository: FactsRepository
) {

    private val _factsChannel: BroadcastChannel<List<CatFact>> = BroadcastChannel(10)

    val factsChannel: BroadcastChannel<List<CatFact>>
        get() = _factsChannel

    suspend fun loadData() = reloadFactsToChannel()

    suspend fun swapLike(fact: CatFact) {
        factsRepository.updateFact(fact.copy(isLiked = !fact.isLiked))
        reloadFactsToChannel()
    }

    private suspend fun reloadFactsToChannel() {
        val facts = factsRepository.getFacts(DEFAULT_LIMIT)
        _factsChannel.send(facts)
    }

    companion object {
        private const val DEFAULT_LIMIT = 100
    }
}