package me.dnihze.kotlinnight.example.data.net.api

import kotlinx.coroutines.experimental.Deferred
import me.dnihze.kotlinnight.example.data.net.CatFactsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("facts")
    fun getFacts(@Query("limit") limit: Int): Deferred<CatFactsResponse>
}