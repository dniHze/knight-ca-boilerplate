package me.dnihze.kotlinnight.example.data.db.mapper

import me.dnihze.kotlinnight.example.data.db.LocalCatFact
import me.dnihze.kotlinnight.example.domain.CatFact
import me.dnihze.kotlinnight.example.domain.common.AsyncMapper

class DBFactMapper: AsyncMapper<CatFact, LocalCatFact> {

    override fun mapOne(t: CatFact) = LocalCatFact(
            id = t.id,
            fact = t.fact,
            length = t.length,
            isLiked = t.isLiked
    )
}