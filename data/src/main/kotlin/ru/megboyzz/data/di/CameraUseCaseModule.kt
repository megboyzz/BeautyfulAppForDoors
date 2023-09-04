package ru.megboyzz.data.di

import dagger.Module
import dagger.Provides
import ru.megboyzz.domain.repositories.LocalDataRepository
import ru.megboyzz.domain.repositories.RemoteDataRepository
import ru.megboyzz.domain.usecases.camera.AddCameraToFavoritesUseCase
import ru.megboyzz.domain.usecases.camera.ChangeCameraNameUseCase
import ru.megboyzz.domain.usecases.camera.GetListOfCamerasUseCase
import ru.megboyzz.domain.usecases.camera.UpdateCamerasListUseCase

@Module
class CameraUseCaseModule {

    @Provides
    fun providesAddCameraToFavUseCase(localDataRepository: LocalDataRepository): AddCameraToFavoritesUseCase =
        AddCameraToFavoritesUseCase(localDataRepository)


    @Provides
    fun providesChangeCameraNameUseCase(localDataRepository: LocalDataRepository): ChangeCameraNameUseCase =
        ChangeCameraNameUseCase(localDataRepository)


    @Provides
    fun providesGetListOfCamerasUseCase(
        updateCamerasListUseCase: UpdateCamerasListUseCase,
        localDataRepository: LocalDataRepository
    ): GetListOfCamerasUseCase =
        GetListOfCamerasUseCase(updateCamerasListUseCase, localDataRepository)


    @Provides
    fun providesUpdateCamerasListUseCase(
        localDataRepository: LocalDataRepository,
        remoteDataRepository: RemoteDataRepository
    ): UpdateCamerasListUseCase =
        UpdateCamerasListUseCase(localDataRepository = localDataRepository, remoteDataRepository = remoteDataRepository)

}