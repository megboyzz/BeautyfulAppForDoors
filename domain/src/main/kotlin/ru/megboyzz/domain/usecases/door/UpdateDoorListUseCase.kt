package ru.megboyzz.domain.usecases.door

import ru.megboyzz.domain.entites.Door
import ru.megboyzz.domain.repositories.RemoteDataRepository
import ru.megboyzz.domain.repositories.old.DoorsRepository

class UpdateDoorListUseCase(
    private val remoteDataRepository: RemoteDataRepository
) {

    operator fun invoke(): List<Door> =
        remoteDataRepository.getAllDoorsRemotely()

}