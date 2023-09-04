package ru.megboyzz.app.ui

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.megboyzz.data.App
import ru.megboyzz.domain.entites.Camera
import ru.megboyzz.domain.entites.Door

class AppViewModel(private val app: App) : AndroidViewModel(app) {


    private val _listOfCameras = MutableLiveData<List<Camera>>(listOf())
    val listOfCameras: LiveData<List<Camera>> = _listOfCameras

    private val _listOfDoors = MutableLiveData<List<Door>>(listOf())
    val listOfDoors: LiveData<List<Door>> = _listOfDoors

    private val _isRefreshing = MutableLiveData(false)
    val isRefreshing: LiveData<Boolean> = _isRefreshing
    init {
        getCameras()
        getDoors()
    }

    fun getCameras(){
        viewModelScope.launch(Dispatchers.IO) {
            _listOfCameras.postValue(app.cameraComponent.getListOfCamerasUseCase())
        }
    }

    fun renameCamera(cameraId: Int, newName: String){
        viewModelScope.launch(Dispatchers.IO) {
            app.cameraComponent.changeCameraNameUseCase(cameraId, newName)
            getCameras()
        }
    }

    fun setFavCamera(cameraId: Int, isFav: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            app.cameraComponent.addCameraToFavoritesUseCase(cameraId, isFav)
            getCameras()
        }
    }



    fun updateCameras(){
        viewModelScope.launch(Dispatchers.IO) {
            _isRefreshing.postValue(true)
            _listOfCameras.postValue(app.cameraComponent.updateCamerasListUseCase())
            _isRefreshing.postValue(false)
        }
    }

    fun getDoors(){
        viewModelScope.launch(Dispatchers.IO) {
            _listOfDoors.postValue(app.doorComponent.getListOfDoorsUseCase())
        }
    }

    fun setNewNameDoor(doorId: Int, newName: String){
        viewModelScope.launch(Dispatchers.IO) {
            app.doorComponent.changeDoorNameUseCase(doorId, newName)
            getDoors()
        }
    }


    fun setDoorIsFav(doorId: Int, isFav: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            app.doorComponent.addDoorToFavoritesUseCase(doorId, isFav)
            getDoors()
        }
    }

    fun updateDoors(){
        viewModelScope.launch(Dispatchers.IO) {
            _isRefreshing.postValue(true)
            _listOfDoors.postValue(app.doorComponent.updateDoorListUseCase())
            _isRefreshing.postValue(false)
        }
    }

}

class ViewModelFactory<T: ViewModel>(private val create: () -> T) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = create.invoke() as T
}