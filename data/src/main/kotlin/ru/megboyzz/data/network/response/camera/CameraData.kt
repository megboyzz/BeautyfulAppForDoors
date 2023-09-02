package ru.megboyzz.data.network.response.camera

data class CameraData(
    val room: List<String>,
    val cameras: List<CameraInfo>
)
