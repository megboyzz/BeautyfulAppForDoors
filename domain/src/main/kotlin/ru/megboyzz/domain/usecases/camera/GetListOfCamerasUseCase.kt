package ru.megboyzz.domain.usecases.camera

import ru.megboyzz.domain.entites.Camera
import ru.megboyzz.domain.repositories.LocalDataRepository

class GetListOfCamerasUseCase(
    private val updateCameraListUseCase: UpdateCamerasListUseCase,
    private val localDataRepository: LocalDataRepository
) {

    operator fun invoke(): List<Camera> {

        val cameras = localDataRepository.getAllLocalCameras()

        return cameras.ifEmpty { updateCameraListUseCase() }

    }

}