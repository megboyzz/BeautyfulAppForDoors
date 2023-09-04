package ru.megboyzz.data.db.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ru.megboyzz.data.db.entities.CameraDb
import ru.megboyzz.data.db.entities.DoorDb

@Dao
interface DoorDao {

    @get:Query("SELECT * FROM doordb")
    val allDoors: List<DoorDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDoor(door: DoorDb)

    @Query("SELECT * FROM doordb WHERE id = :doorId")
    fun getDoorById(doorId: Int): DoorDb

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateDoor(door: DoorDb)

}