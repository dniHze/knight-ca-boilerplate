package me.dnihze.kotlinnight.example.data.db.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import me.dnihze.kotlinnight.example.data.db.LocalCatFact
import me.dnihze.kotlinnight.example.data.db.dao.CatFactsDao

@Database(entities = [LocalCatFact::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun catFactsDao(): CatFactsDao
}