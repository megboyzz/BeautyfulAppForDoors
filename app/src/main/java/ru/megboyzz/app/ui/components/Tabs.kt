package ru.megboyzz.app.ui.components

import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import ru.megboyzz.app.MainActivity
import ru.megboyzz.app.ui.AppViewModel
import ru.megboyzz.app.ui.ViewModelFactory
import ru.megboyzz.app.ui.tabs.CamerasTab
import ru.megboyzz.app.ui.tabs.DoorsTab
import ru.megboyzz.app.ui.theme.background
import ru.megboyzz.data.App

@Preview
@Composable
fun TabsScreen() {

    val mainActivity = LocalContext.current as MainActivity

    val viewModel: AppViewModel by mainActivity.viewModels {
        ViewModelFactory {
            AppViewModel(mainActivity.application as App)
        }
    }

    var tabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Камеры", "Двери")

    Column(
        modifier = Modifier.fillMaxSize().background(background)
    ) {
        TabRow(
            modifier = Modifier.shadow(elevation = 4.dp),
            containerColor = background,
            selectedTabIndex = tabIndex,
            divider = {},
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title) },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index }
                )
            }
        }
        when (tabIndex) {
            0 -> CamerasTab(viewModel)
            1 -> DoorsTab(viewModel)
        }
    }

}
