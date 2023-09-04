package ru.megboyzz.data.di

import dagger.Module
import dagger.Provides
import io.ktor.client.HttpClient
import io.realm.kotlin.Realm
import ru.megboyzz.data.db.AppDataBase
import ru.megboyzz.data.repositories.LocalDataRepositoryImpl
import ru.megboyzz.data.repositories.RemoteDataRepositoryImpl
import ru.megboyzz.domain.repositories.LocalDataRepository
import ru.megboyzz.domain.repositories.RemoteDataRepository

@Module
class RepositoryModule {

    @Provides
    fun providesLocalRepository(dataBase: AppDataBase): LocalDataRepository =
        LocalDataRepositoryImpl(dataBase)

    @Provides
    fun providesRemoteRepository(httpClient: HttpClient): RemoteDataRepository =
        RemoteDataRepositoryImpl(httpClient)

}