package ru.megboyzz.domain.usecases.camera

import ru.megboyzz.domain.repositories.LocalDataRepository

class ChangeCameraNameUseCase(
    private val localDataRepository: LocalDataRepository
) {

    operator fun invoke(cameraId: Int, newName: String): Boolean
            = localDataRepository.setNewNameToCamera(cameraId, newName)



}