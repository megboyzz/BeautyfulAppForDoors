package ru.megboyzz.data.di

import dagger.Component
import ru.megboyzz.domain.usecases.camera.AddCameraToFavoritesUseCase
import ru.megboyzz.domain.usecases.camera.ChangeCameraNameUseCase
import ru.megboyzz.domain.usecases.camera.GetListOfCamerasUseCase
import ru.megboyzz.domain.usecases.camera.UpdateCamerasListUseCase
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class, DataBaseModule::class, RepositoryModule::class, CameraUseCaseModule::class])
interface CameraComponent {

    val addCameraToFavoritesUseCase: AddCameraToFavoritesUseCase

    val changeCameraNameUseCase: ChangeCameraNameUseCase

    val getListOfCamerasUseCase: GetListOfCamerasUseCase

    val updateCamerasListUseCase: UpdateCamerasListUseCase

    @Component.Builder
    interface Builder {
        fun dataBaseModule(dataBaseModule: DataBaseModule): Builder
        fun build(): CameraComponent
    }

}