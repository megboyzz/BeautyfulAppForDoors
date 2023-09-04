package ru.megboyzz.app.ui.components

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import ru.megboyzz.app.R
import ru.megboyzz.app.ui.AsPainter

@Composable
fun ImageOnCard(
    link: String
) {
    Box(contentAlignment = Alignment.Center) {
        AsyncImage(
            model = link,
            contentScale = ContentScale.FillWidth,
            contentDescription = "",
            modifier = Modifier.fillMaxWidth()
        )
        Image(
            painter = R.drawable.play_button.AsPainter(),
            contentDescription = null,
        )
    }
}