package com.dscvit.thinker.di

import com.dscvit.thinker.api.WikiSearchApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = "https://iamyajat.com/"

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL: String): WikiSearchApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WikiSearchApi::class.java)

}
