package ru.megboyzz.domain.repositories

import ru.megboyzz.domain.entites.Camera
import ru.megboyzz.domain.entites.Door

interface LocalDataRepository {

    fun getAllLocalCameras(): List<Camera>

    fun setNewNameToCamera(cameraId: Int, newName: String): Boolean

    fun setIsFavoriteCamera(cameraId: Int, isFavorite: Boolean): Boolean

    fun getAllDoorsLocaly(): List<Door>

    fun setNewNameToDoor(doorId: Int, newName: String): Boolean

    fun setIsFavoriteDoor(doorId: Int, isFavorite: Boolean): Boolean

}