package ru.megboyzz.data.network.response.door

import ru.megboyzz.domain.entites.Door

data class DoorData(
    val id: Int,
    val name: String,
    val snapshotImageLink: String?,
    val room: String?,
    val favorites: Boolean
){
    fun toDomain(): Door = Door(
        id = this.id,
        name = this.name,
        snapshotImageLink = this.snapshotImageLink,
        room = this.room,
        favorites = this.favorites
    )
}
