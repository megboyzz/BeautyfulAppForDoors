package ru.megboyzz.data.db.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ru.megboyzz.data.db.entities.CameraDb

@Dao
interface CameraDao {

    @get:Query("SELECT * FROM cameradb")
    val allCameras: List<CameraDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCamera(camera: CameraDb)

    @Query("SELECT * FROM cameradb WHERE id = :cameraId")
    fun getCameraById(cameraId: Int): CameraDb

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCamera(camera: CameraDb)

}