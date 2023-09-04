package ru.megboyzz.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.megboyzz.data.db.dao.CameraDao
import ru.megboyzz.data.db.dao.DoorDao
import ru.megboyzz.data.db.entities.CameraDb
import ru.megboyzz.data.db.entities.DoorDb

@Database(entities = [CameraDb::class, DoorDb::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun cameraDao(): CameraDao
    abstract fun doorDao(): DoorDao
}