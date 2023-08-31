package ru.megboyzz.domain.entites

data class Door(
    val id: Int,
    val name: String,
    val snapshotImageLink: String?,
    val room: String?,
    val favorites: Boolean
)
