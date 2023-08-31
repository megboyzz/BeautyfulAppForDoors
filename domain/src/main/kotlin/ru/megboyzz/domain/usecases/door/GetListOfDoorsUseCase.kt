package ru.megboyzz.domain.usecases.door

import ru.megboyzz.domain.entites.Door
import ru.megboyzz.domain.repositories.LocalDataRepository

class GetListOfDoorsUseCase(
    private val updateDoorListUseCase: UpdateDoorListUseCase,
    private val localDataRepository: LocalDataRepository
) {

    operator fun invoke(): List<Door> {

        val localDoors = localDataRepository.getAllDoorsLocaly()

        return localDoors.ifEmpty { updateDoorListUseCase() }

    }

}