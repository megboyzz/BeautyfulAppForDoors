package ru.megboyzz.data.db.entities


import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.megboyzz.domain.entites.Camera

@Entity
data class CameraDb(
    @PrimaryKey
    val id: Int,
    val name: String,
    val snapshotImageLink: String,
    val room: String?,
    val favorites: Boolean,
    val rec: Boolean
){
    fun toDomain(): Camera = Camera(
        id = this.id,
        name = this.name,
        snapshotImageLink = this.snapshotImageLink,
        room = this.room,
        favorites = this.favorites,
        rec = this.rec
    )
}

fun Camera.toEntity(): CameraDb = CameraDb(
    id = this.id,
    name = this.name,
    snapshotImageLink = this.snapshotImageLink,
    room = this.room,
    favorites = this.favorites,
    rec = this.rec
)
