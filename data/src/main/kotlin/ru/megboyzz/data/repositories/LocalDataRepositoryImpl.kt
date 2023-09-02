package ru.megboyzz.data.repositories

import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import ru.megboyzz.data.db.entities.CameraRealm
import ru.megboyzz.data.db.entities.DoorRealm
import ru.megboyzz.domain.entites.Camera
import ru.megboyzz.domain.entites.Door
import ru.megboyzz.domain.repositories.LocalDataRepository
import javax.inject.Inject

class LocalDataRepositoryImpl @Inject constructor(
    private val realm: Realm
) : LocalDataRepository {

    override fun addCameraToLocalStorage(camera: Camera) {
        realm.writeBlocking {
            val cameraRealm = CameraRealm(
                id = camera.id,
                name = camera.name,
                snapshot = camera.snapshotImageLink,
                room = camera.room,
                favorites = camera.favorites,
                rec = camera.rec
            )
            copyToRealm(cameraRealm, updatePolicy = UpdatePolicy.ALL)
        }
    }

    override fun addDoorToLocalStorage(door: Door) {
        realm.writeBlocking {
            val doorRealm = DoorRealm(
                id = door.id,
                name = door.name,
                snapshot = door.snapshotImageLink,
                room = door.room,
                favorites = door.favorites,
            )
            copyToRealm(doorRealm, updatePolicy = UpdatePolicy.ALL)
        }
    }

    override fun getAllCamerasLocaly(): List<Camera> {
        val copyFromRealm = realm.copyFromRealm(listOf<CameraRealm>())
        val map = copyFromRealm.map {
            Camera(
                id = it.id,
                name = it.name,
                favorites = it.favorites,
                rec = it.rec,
                room = it.room,
                snapshotImageLink = it.snapshot
            )
        }
        return map
    }

    override fun setNewNameToCamera(cameraId: Int, newName: String): Boolean {
        return realm.writeBlocking {
            val camera = this.query(CameraRealm::class, query = "id == $0", cameraId)
                .first().find()
            if(camera != null){
                camera.name = newName
                return@writeBlocking true
            }else return@writeBlocking false
        }
    }

    override fun setIsFavoriteCamera(cameraId: Int, isFavorite: Boolean): Boolean {
        return realm.writeBlocking {
            val camera = this.query(CameraRealm::class, query = "id == $0", cameraId)
                .first().find()
            if(camera != null){
                camera.favorites = isFavorite
                return@writeBlocking true
            }else return@writeBlocking false
        }
    }

    override fun getAllDoorsLocaly(): List<Door> {
        val copyFromRealm = realm.copyFromRealm(listOf<DoorRealm>())
        val map = copyFromRealm.map {
            Door(
                id = it.id,
                name = it.name,
                favorites = it.favorites,
                room = it.room,
                snapshotImageLink = it.snapshot
            )
        }
        return map
    }

    override fun setNewNameToDoor(doorId: Int, newName: String): Boolean {
        return realm.writeBlocking {
            val door = this.query(DoorRealm::class, query = "id == $0", doorId)
                .first().find()
            if(door != null){
                door.name = newName
                return@writeBlocking true
            }else return@writeBlocking false
        }
    }

    override fun setIsFavoriteDoor(doorId: Int, isFavorite: Boolean): Boolean {
        return realm.writeBlocking {
            val door = this.query(DoorRealm::class, query = "id == $0", doorId)
                .first().find()
            if(door != null){
                door.favorites = isFavorite
                return@writeBlocking true
            }else return@writeBlocking false
        }
    }
}