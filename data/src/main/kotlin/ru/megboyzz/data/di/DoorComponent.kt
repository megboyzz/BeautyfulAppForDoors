package ru.megboyzz.data.di

import dagger.Component
import ru.megboyzz.domain.entites.Door
import ru.megboyzz.domain.usecases.door.AddDoorToFavoritesUseCase
import ru.megboyzz.domain.usecases.door.ChangeDoorNameUseCase
import ru.megboyzz.domain.usecases.door.GetListOfDoorsUseCase
import ru.megboyzz.domain.usecases.door.UpdateDoorListUseCase
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class, DataBaseModule::class, RepositoryModule::class, DoorUseCaseModule::class])
interface DoorComponent {

    val addDoorToFavoritesUseCase: AddDoorToFavoritesUseCase

    val changeDoorNameUseCase: ChangeDoorNameUseCase

    val getListOfDoorsUseCase: GetListOfDoorsUseCase

    val updateDoorListUseCase: UpdateDoorListUseCase

    @Component.Builder
    interface Builder {

        fun dataBaseModule(dataBaseModule: DataBaseModule): Builder
        fun build(): DoorComponent
    }

}