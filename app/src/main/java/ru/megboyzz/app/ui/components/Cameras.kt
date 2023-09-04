package ru.megboyzz.app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox
import ru.megboyzz.app.R
import ru.megboyzz.app.ui.AsImageVector
import ru.megboyzz.app.ui.AsPainter
import ru.megboyzz.app.ui.theme.background
import ru.megboyzz.domain.entites.Camera


@Composable
fun CameraItem(
    camera: Camera,
    onSwipe: () -> Unit,
    onEditName: (String) -> Unit,
    onDismissSwipe: () -> Unit
) {

    var isEditing by remember { mutableStateOf(false) }
    var cameraName by remember { mutableStateOf(camera.name) }

    val focusRequester = remember { FocusRequester() }

    val swipeAction = SwipeAction(
        onSwipe = onSwipe,
        icon = rememberVectorPainter(image = R.drawable.star.AsImageVector()),
        background = background
    )

    val editAction = SwipeAction(
        onSwipe = { isEditing = !isEditing },
        icon = rememberVectorPainter(image = R.drawable.edit.AsImageVector()),
        background = background
    )

    val dismissAction = SwipeAction(
        onSwipe = onDismissSwipe,
        icon = rememberVectorPainter(image = Icons.Filled.Close),
        background = background
    )

    SwipeableActionsBox(
        endActions = listOf(swipeAction, editAction),
        startActions = listOf(dismissAction)
    ) {

        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(contentAlignment = Alignment.TopEnd) {
                ImageOnCard(link = camera.snapshotImageLink)
                if (camera.favorites) {
                    Image(
                        painter = R.drawable.star.AsPainter(),
                        contentDescription = "",
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
            Row(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if(isEditing){
                    BasicTextField(
                        value = cameraName,
                        onValueChange = {
                            cameraName = it
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    IconButton(
                        onClick = {
                            isEditing =! isEditing
                            onEditName(cameraName)
                            cameraName = camera.name
                        }
                    ) {
                        Icon(imageVector = Icons.Filled.Check, contentDescription = "")
                    }
                    LaunchedEffect(Unit){
                        focusRequester.requestFocus()
                    }
                }else Text(text = camera.name)
            }
        }

    }

}