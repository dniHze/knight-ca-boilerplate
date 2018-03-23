package me.dnihze.kotlinnight.example.data.db.mapper

import me.dnihze.kotlinnight.example.data.db.LocalCatFact
import me.dnihze.kotlinnight.example.domain.CatFact
import me.dnihze.kotlinnight.example.domain.common.AsyncMapper

class DomainFactMapper: AsyncMapper<LocalCatFact, CatFact> {
    override fun mapOne(t: LocalCatFact) = CatFact(
            id = t.id,
            fact = t.fact,
            length = t.length,
            isLiked = t.isLiked
    )
}