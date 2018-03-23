package me.dnihze.kotlinnight.example.di

import android.arch.persistence.room.Room
import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import me.dnihze.kotlinnight.example.data.db.dao.AppDatabase
import me.dnihze.kotlinnight.example.data.db.dao.CatFactsDao
import me.dnihze.kotlinnight.example.data.net.api.ApiService
import me.dnihze.kotlinnight.example.data.repository.FactsRepositoryImpl
import me.dnihze.kotlinnight.example.domain.repository.FactsRepository
import me.dnihze.kotlinnight.example.util.API_LINK
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApplicationModule(private val context: Context) {

    @Provides
    fun provideContext(): Context = context

    @Provides
    fun provideFactDao(): CatFactsDao {
        val db = Room.databaseBuilder(context, AppDatabase::class.java, "sample")
                .build()
        return db.catFactsDao()
    }

    @Provides
    fun providesApiService(): ApiService {
        val retrofit = Retrofit.Builder()
                .baseUrl(API_LINK)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideRepo(repositoryImpl: FactsRepositoryImpl): FactsRepository = repositoryImpl
}