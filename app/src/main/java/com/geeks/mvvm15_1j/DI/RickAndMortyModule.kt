package com.geeks.mvvm15_1j.DI

import com.geeks.mvvm15_1j.data.network.repository.CharacterRepository
import com.geeks.mvvm15_1j.data.network.repository.EpisodeRepository
import com.geeks.mvvm15_1j.data.network.repository.LocationRepository
import com.geeks.mvvm15_1j.data.network.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RickAndMortyModule {
    @Provides
    @Singleton
    fun provideApiService(): ApiService{
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)

    }

    @Provides
    fun provideCharacterRepository(apiService: ApiService): CharacterRepository{
        return CharacterRepository(apiService)
    }

    @Provides
    fun provideEpisodeRepository(apiService: ApiService): EpisodeRepository{
        return EpisodeRepository(apiService)
    }
    @Provides
    fun provideLocationRepository(apiService: ApiService): LocationRepository{
        return LocationRepository(apiService)
    }
}