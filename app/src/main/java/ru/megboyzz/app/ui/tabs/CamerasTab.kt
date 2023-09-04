package ru.megboyzz.app.ui.tabs

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import ru.megboyzz.app.ui.AppViewModel
import ru.megboyzz.app.ui.components.CameraItem
import ru.megboyzz.app.ui.makeText

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CamerasTab(viewModel: AppViewModel) {

    val context = LocalContext.current
    val listOfCameras by viewModel.listOfCameras.observeAsState()
    val isRefreshing by viewModel.isRefreshing.observeAsState()

    val pullRefreshState =
        rememberPullRefreshState(refreshing = isRefreshing!!, onRefresh = viewModel::updateCameras)


    Box(modifier = Modifier.pullRefresh(pullRefreshState)) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.padding(20.dp)
        ) {
            items(listOfCameras!!) { camera ->
                CameraItem(
                    camera = camera,
                    onSwipe = {
                        viewModel.setFavCamera(camera.id, true)
                    },
                    onDismissSwipe = {
                        viewModel.setFavCamera(camera.id, false)
                    },
                    onEditName = {
                        viewModel.renameCamera(camera.id, it)
                    }
                )
            }
        }
        PullRefreshIndicator(isRefreshing!!, pullRefreshState, Modifier.align(Alignment.TopCenter))
    }


}