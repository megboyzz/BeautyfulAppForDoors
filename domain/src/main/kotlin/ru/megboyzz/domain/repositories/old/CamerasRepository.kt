package ru.megboyzz.domain.repositories.old

import ru.megboyzz.domain.entites.Camera
import ru.megboyzz.domain.entites.Door

interface CamerasRepository {

    fun getAllLocalCameras(): List<Camera>

    fun setNewNameToCamera(cameraId: Int, newName: String): Boolean

    fun setIsFavoriteCamera(cameraId: Int, isFavorite: Boolean): Boolean

    fun getAllRemoteCamera(): List<Camera>

}