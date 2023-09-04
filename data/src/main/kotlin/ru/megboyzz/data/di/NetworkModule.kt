package ru.megboyzz.data.di

import dagger.Module
import dagger.Provides
import io.ktor.client.HttpClient
import io.ktor.client.plugins.addDefaultResponseValidation
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson

@Module
class NetworkModule {

    @Provides
    fun providesHttpClient(): HttpClient = HttpClient{
        install(ContentNegotiation) {
            gson()
        }
    }

}