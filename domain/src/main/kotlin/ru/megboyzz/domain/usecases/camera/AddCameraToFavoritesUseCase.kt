package ru.megboyzz.domain.usecases.camera

import ru.megboyzz.domain.repositories.LocalDataRepository

class AddCameraToFavoritesUseCase(
    private val localDataRepository: LocalDataRepository
) {

    operator fun invoke(cameraId: Int, isFavorite: Boolean): Boolean
            = localDataRepository.setIsFavoriteCamera(cameraId, isFavorite)

}