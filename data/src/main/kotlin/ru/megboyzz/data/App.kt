package ru.megboyzz.data

import android.app.Application
import android.util.Log
import io.realm.kotlin.log.LogLevel
import io.realm.kotlin.log.RealmLog
import ru.megboyzz.data.di.CameraComponent
import ru.megboyzz.data.di.DaggerCameraComponent
import ru.megboyzz.data.di.DaggerDoorComponent
import ru.megboyzz.data.di.DataBaseModule
import ru.megboyzz.data.di.DoorComponent

class App : Application() {

    lateinit var cameraComponent: CameraComponent
    lateinit var doorComponent: DoorComponent

    override fun onCreate() {

        super.onCreate()
        cameraComponent = DaggerCameraComponent.builder().dataBaseModule(DataBaseModule(this)).build()
        doorComponent = DaggerDoorComponent.builder().dataBaseModule(DataBaseModule(this)).build()

    }

}