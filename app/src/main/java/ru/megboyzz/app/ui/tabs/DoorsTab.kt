package ru.megboyzz.app.ui.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
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
import ru.megboyzz.app.ui.components.DoorItem

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DoorsTab(viewModel: AppViewModel) {

    val listOfDoors by viewModel.listOfDoors.observeAsState()
    val context = LocalContext.current
    val isRefreshing by viewModel.isRefreshing.observeAsState()

    val pullRefreshState =
        rememberPullRefreshState(refreshing = isRefreshing!!, onRefresh = viewModel::updateDoors)



    Box(modifier = Modifier.pullRefresh(pullRefreshState)) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.padding(20.dp)
        ) {
            //item { Spacer(modifier = Modifier.height(1.dp)) }
            items(listOfDoors!!){ door ->
                DoorItem(
                    door = door,
                    onEditClick = { newName ->
                        viewModel.setNewNameDoor(door.id, newName)
                    },
                    onFavClick = {
                        viewModel.setDoorIsFav(door.id, true)
                    },
                    onUnFavClick = {
                        viewModel.setDoorIsFav(door.id, false)
                    }
                )
            }
            item { Spacer(modifier = Modifier.height(1.dp)) }
        }
        PullRefreshIndicator(isRefreshing!!, pullRefreshState, Modifier.align(Alignment.TopCenter))
    }

}