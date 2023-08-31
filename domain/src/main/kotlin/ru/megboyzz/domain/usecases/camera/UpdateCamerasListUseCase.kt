package ru.megboyzz.domain.usecases.camera

import ru.megboyzz.domain.entites.Camera
import ru.megboyzz.domain.repositories.RemoteDataRepository

class UpdateCamerasListUseCase(
    private val remoteDataRepository: RemoteDataRepository
) {

    operator fun invoke(): List<Camera>
        = remoteDataRepository.getAllCamerasRemotely()

}