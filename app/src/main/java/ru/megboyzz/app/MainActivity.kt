package ru.megboyzz.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import ru.megboyzz.app.ui.AppViewModel
import ru.megboyzz.app.ui.ViewModelFactory
import ru.megboyzz.app.ui.components.MainScaffold
import ru.megboyzz.app.ui.components.TabsScreen
import ru.megboyzz.data.App
import ru.megboyzz.data.di.DaggerDoorComponent
import kotlin.concurrent.thread

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScaffold {
                TabsScreen()
            }
        }
    }
}
