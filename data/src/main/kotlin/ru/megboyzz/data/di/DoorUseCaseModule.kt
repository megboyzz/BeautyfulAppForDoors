package ru.megboyzz.data.di

import dagger.Module
import dagger.Provides
import ru.megboyzz.domain.repositories.LocalDataRepository
import ru.megboyzz.domain.repositories.RemoteDataRepository
import ru.megboyzz.domain.usecases.camera.GetListOfCamerasUseCase
import ru.megboyzz.domain.usecases.camera.UpdateCamerasListUseCase
import ru.megboyzz.domain.usecases.door.AddDoorToFavoritesUseCase
import ru.megboyzz.domain.usecases.door.ChangeDoorNameUseCase
import ru.megboyzz.domain.usecases.door.GetListOfDoorsUseCase
import ru.megboyzz.domain.usecases.door.UpdateDoorListUseCase

@Module
class DoorUseCaseModule {

    @Provides
    fun providesAddDoorToFavUseCase(localDataRepository: LocalDataRepository): AddDoorToFavoritesUseCase =
        AddDoorToFavoritesUseCase(localDataRepository)


    @Provides
    fun providesChangeDoorNameUseCase(localDataRepository: LocalDataRepository): ChangeDoorNameUseCase =
        ChangeDoorNameUseCase(localDataRepository)


    @Provides
    fun providesGetListOfDoorsUseCase(
        updateDoorsListUseCase: UpdateDoorListUseCase,
        localDataRepository: LocalDataRepository
    ): GetListOfDoorsUseCase =
        GetListOfDoorsUseCase(updateDoorsListUseCase, localDataRepository)


    @Provides
    fun providesUpdateDoorsListUseCase(
        localDataRepository: LocalDataRepository,
        remoteDataRepository: RemoteDataRepository
    ): UpdateDoorListUseCase =
        UpdateDoorListUseCase(localDataRepository = localDataRepository, remoteDataRepository = remoteDataRepository)

}