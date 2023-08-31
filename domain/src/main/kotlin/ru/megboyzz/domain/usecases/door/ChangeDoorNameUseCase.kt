package ru.megboyzz.domain.usecases.door

import ru.megboyzz.domain.repositories.LocalDataRepository

class ChangeDoorNameUseCase(
    private val localDataRepository: LocalDataRepository
) {

    operator fun invoke(doorId: Int, newName: String): Boolean
        = localDataRepository.setNewNameToDoor(doorId, newName)


}