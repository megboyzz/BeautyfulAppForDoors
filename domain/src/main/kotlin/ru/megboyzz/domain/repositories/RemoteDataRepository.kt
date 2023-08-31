package ru.megboyzz.domain.repositories

import ru.megboyzz.domain.entites.Camera
import ru.megboyzz.domain.entites.Door

interface RemoteDataRepository {

    fun getAllCamerasRemotely(): List<Camera>

    fun getAllDoorsRemotely(): List<Door>

}