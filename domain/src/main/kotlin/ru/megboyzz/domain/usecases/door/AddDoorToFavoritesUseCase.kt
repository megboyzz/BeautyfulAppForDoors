package ru.megboyzz.domain.usecases.door

import ru.megboyzz.domain.repositories.LocalDataRepository

class AddDoorToFavoritesUseCase(
    private val localDataRepository: LocalDataRepository
) {

    operator fun invoke(doorId: Int, isFavorite: Boolean): Boolean
        = localDataRepository.setIsFavoriteDoor(doorId, isFavorite)

}