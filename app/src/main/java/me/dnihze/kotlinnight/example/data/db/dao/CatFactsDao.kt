package me.dnihze.kotlinnight.example.data.db.dao

import android.arch.persistence.room.*
import me.dnihze.kotlinnight.example.data.db.LocalCatFact

@Dao
interface CatFactsDao {

    @Query("SELECT * FROM cat_fact LIMIT :limit")
    fun getFacts(limit: Int): List<LocalCatFact>

    @Insert
    fun saveFacts(facts: List<LocalCatFact>)

    @Update
    fun updateFact(fact: LocalCatFact)
}