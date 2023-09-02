package ru.megboyzz.data.repositories

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import kotlinx.coroutines.runBlocking
import ru.megboyzz.data.network.response.camera.CameraResponse
import ru.megboyzz.data.network.response.door.DoorResponse
import ru.megboyzz.domain.entites.Camera
import ru.megboyzz.domain.entites.Door
import ru.megboyzz.domain.repositories.RemoteDataRepository
import javax.inject.Inject

class RemoteDataRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient
): RemoteDataRepository {

    private val cameraMethodUrl = "http://cars.cprogroup.ru/api/rubetek/doors/"
    private val doorMethodUrl = "http://cars.cprogroup.ru/api/rubetek/cameras/"
    override fun getAllCamerasRemotely(): List<Camera> {
        val cameraResponse = runBlocking {
            httpClient.get(cameraMethodUrl).body<CameraResponse>()
        }

        if (!cameraResponse.success) return listOf()

        return cameraResponse.data.cameras.map { it.toDomainCamera() }
    }

    override fun getAllDoorsRemotely(): List<Door> {
        val doorResponse = runBlocking {
            httpClient.get(doorMethodUrl).body<DoorResponse>()
        }

        if(!doorResponse.success) return listOf()

        return doorResponse.data.map { it.toDomain() }

    }
}