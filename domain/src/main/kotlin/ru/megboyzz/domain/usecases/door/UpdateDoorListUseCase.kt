package ru.megboyzz.domain.usecases.door

import ru.megboyzz.domain.entites.Door
import ru.megboyzz.domain.repositories.LocalDataRepository
import ru.megboyzz.domain.repositories.RemoteDataRepository
import ru.megboyzz.domain.repositories.old.DoorsRepository

class UpdateDoorListUseCase(
    private val remoteDataRepository: RemoteDataRepository,
    private val localDataRepository: LocalDataRepository
) {

    operator fun invoke(): List<Door> {

        val allDoorsRemotely = remoteDataRepository.getAllDoorsRemotely()

        allDoorsRemotely.forEach { localDataRepository.addDoorToLocalStorage(it) }

        return allDoorsRemotely

    }

}