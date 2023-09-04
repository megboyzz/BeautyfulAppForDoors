package ru.megboyzz.data.repositories

import ru.megboyzz.data.db.AppDataBase
import ru.megboyzz.data.db.entities.toEntity
import ru.megboyzz.domain.entites.Camera
import ru.megboyzz.domain.entites.Door
import ru.megboyzz.domain.repositories.LocalDataRepository
import javax.inject.Inject

class LocalDataRepositoryImpl @Inject constructor(
    private val dataBase: AppDataBase
) : LocalDataRepository {

    private val cameraDao = dataBase.cameraDao()
    private val doorDao = dataBase.doorDao()

    override fun addCameraToLocalStorage(camera: Camera) {
        cameraDao.insertCamera(camera.toEntity())
    }

    override fun addDoorToLocalStorage(door: Door) {
        doorDao.insertDoor(door.toEntity())
    }

    override fun getAllCamerasLocaly(): List<Camera> =
        cameraDao.allCameras.map { it.toDomain() }

    override fun setNewNameToCamera(cameraId: Int, newName: String): Boolean {
        val cameraById = cameraDao.getCameraById(cameraId)
        val camera = cameraById.copy(name = newName)
        cameraDao.updateCamera(camera)
        return true
    }

    override fun setIsFavoriteCamera(cameraId: Int, isFavorite: Boolean): Boolean {
        val cameraById = cameraDao.getCameraById(cameraId)
        val camera = cameraById.copy(favorites = isFavorite)
        cameraDao.updateCamera(camera)
        return true
    }

    override fun getAllDoorsLocaly(): List<Door> =
        doorDao.allDoors.map { it.toDomain() }

    override fun setNewNameToDoor(doorId: Int, newName: String): Boolean {
        val doorById = doorDao.getDoorById(doorId)
        val door = doorById.copy(name = newName)
        doorDao.updateDoor(door)
        doorDao.updateDoor(door)
        return true
    }

    override fun setIsFavoriteDoor(doorId: Int, isFavorite: Boolean): Boolean {
        val doorById = doorDao.getDoorById(doorId)
        val door = doorById.copy(favorites = isFavorite)
        doorDao.updateDoor(door)
        return true
    }
}