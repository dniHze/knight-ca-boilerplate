package me.dnihze.kotlinnight.example.data.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "cat_fact")
data class LocalCatFact(
        @PrimaryKey var id: String = "",
        @ColumnInfo(name = "fact") var fact: String = "",
        @ColumnInfo(name = "length") var length: Int = 0,
        @ColumnInfo(name = "liked") var isLiked: Boolean = false
)