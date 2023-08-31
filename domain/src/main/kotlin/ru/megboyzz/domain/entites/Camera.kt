package ru.megboyzz.domain.entites

data class Camera(
    val id: Int,
    val name: String,
    val snapshotImageLink: String,
    val room: String?,
    val favorites: Boolean,
    val rec: Boolean
)
