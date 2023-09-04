package ru.megboyzz.data

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import ru.megboyzz.data.di.DaggerDoorComponent
import ru.megboyzz.data.di.DataBaseModule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private val context = InstrumentationRegistry.getInstrumentation().context

    private val doorComponent = DaggerDoorComponent.builder().dataBaseModule(DataBaseModule(context)).build()
    @Test
    fun useAppContext() {


        val getListOfDoorsUseCase = doorComponent.getListOfDoorsUseCase

        val listOfDoors = getListOfDoorsUseCase()

        assertEquals(listOfDoors.size, 4)
    }

    @Test
    fun copyToRealmAndGetFromIt(){

        val getListOfDoorsUseCase = doorComponent.getListOfDoorsUseCase

        val listOfDoors = getListOfDoorsUseCase()

        val doorId = listOfDoors[0].id

        val newName = "Hehe1"

        doorComponent.changeDoorNameUseCase(doorId, newName)

        val newList = getListOfDoorsUseCase()

        val changedNameDoor = newList.find { it.id == doorId }

        assert(changedNameDoor != null)

        assertEquals(newName, changedNameDoor!!.name)

    }
}