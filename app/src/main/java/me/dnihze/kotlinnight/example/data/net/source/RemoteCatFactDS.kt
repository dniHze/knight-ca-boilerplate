package me.dnihze.kotlinnight.example.data.net.source

import me.dnihze.kotlinnight.example.data.net.api.ApiService
import me.dnihze.kotlinnight.example.data.net.mapper.NetFactMapper
import me.dnihze.kotlinnight.example.domain.CatFact
import javax.inject.Inject

class RemoteCatFactDS @Inject constructor(
        private val api: ApiService
) {

    private val netFactMapper by lazy { NetFactMapper() }

    suspend fun getFacts(limit: Int): List<CatFact> {
        val response = api.getFacts(limit).await()
        return netFactMapper.map(response.data)
    }
}