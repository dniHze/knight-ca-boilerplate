@file:Suppress("EXPERIMENTAL_FEATURE_WARNING")

package me.dnihze.kotlinnight.example.domain.common

import kotlinx.coroutines.experimental.async

interface AsyncMapper<in T, out R> {

    suspend fun map(one: T): R = async { mapOne(one) }.await()

    suspend fun map(many: Iterable<T>): List<R> = async { many.map { mapOne(it) } }.await()

    fun mapOne(t: T): R
}