package ru.megboyzz.domain.repositories.old

import ru.megboyzz.domain.entites.Door

interface DoorsRepository {

    fun getAllLocalDoors(): List<Door>

    fun setNewNameToDoor(doorId: Int, newName: String): Boolean

    fun setIsFavoriteDoor(doorId: Int, isFavorite: Boolean): Boolean

    fun getAllRemoteDoors(): List<Door>

}