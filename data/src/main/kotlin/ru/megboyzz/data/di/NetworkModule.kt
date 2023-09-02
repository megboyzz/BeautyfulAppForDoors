package ru.megboyzz.data.di

import dagger.Module
import dagger.Provides
import io.ktor.client.HttpClient

@Module
class NetworkModule {

    @Provides
    fun providesHttpClient(): HttpClient = HttpClient()

}