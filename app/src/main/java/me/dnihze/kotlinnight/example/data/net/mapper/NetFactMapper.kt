package me.dnihze.kotlinnight.example.data.net.mapper

import me.dnihze.kotlinnight.example.data.net.RemoteCatFact
import me.dnihze.kotlinnight.example.domain.CatFact
import me.dnihze.kotlinnight.example.domain.common.AsyncMapper
import java.util.*

class NetFactMapper: AsyncMapper<RemoteCatFact, CatFact> {
    override fun mapOne(t: RemoteCatFact) = CatFact(
            id = UUID.randomUUID().toString(),
            fact = t.fact,
            length = t.length,
            isLiked = false
    )
}