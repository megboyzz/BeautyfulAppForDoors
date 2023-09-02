package ru.megboyzz.data.network.response.camera

import ru.megboyzz.domain.entites.Camera

data class CameraInfo(
    val id: Int,
    val name: String,
    val snapshotImageLink: String,
    val room: String?,
    val favorites: Boolean,
    val rec: Boolean
){
    fun toDomainCamera(): Camera = Camera(
        id = this.id,
        name = this.name,
        snapshotImageLink = this.snapshotImageLink,
        room = this.room,
        favorites = this.favorites,
        rec = this.rec
    )
}