package ru.megboyzz.domain.usecases.camera

import ru.megboyzz.domain.entites.Camera
import ru.megboyzz.domain.repositories.LocalDataRepository
import ru.megboyzz.domain.repositories.RemoteDataRepository

class UpdateCamerasListUseCase(
    private val remoteDataRepository: RemoteDataRepository,
    private val localDataRepository: LocalDataRepository
) {

    operator fun invoke(): List<Camera> {
        val allCamerasRemotely = remoteDataRepository.getAllCamerasRemotely()

        allCamerasRemotely.forEach { localDataRepository.addCameraToLocalStorage(it) }

        return allCamerasRemotely
    }

}