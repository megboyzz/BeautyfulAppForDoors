package ru.megboyzz.data.db.entities


import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.megboyzz.domain.entites.Door


@Entity
data class DoorDb(
    @PrimaryKey
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
        room = this.snapshotImageLink,
        favorites = this.favorites
    )
}

fun Door.toEntity(): DoorDb = DoorDb(
    id = this.id,
    name = this.name,
    snapshotImageLink = this.snapshotImageLink,
    room = this.snapshotImageLink,
    favorites = this.favorites
)