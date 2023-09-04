package ru.megboyzz.app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox
import ru.megboyzz.app.R
import ru.megboyzz.app.ui.AsImageVector
import ru.megboyzz.app.ui.AsPainter
import ru.megboyzz.app.ui.makeText
import ru.megboyzz.app.ui.theme.background
import ru.megboyzz.domain.entites.Door

@Composable
fun DoorBack(door: Door) {

}

@Composable
fun DoorItem(
    door: Door,
    onEditClick: (String) -> Unit,
    onUnFavClick: () -> Unit,
    onFavClick: () -> Unit
) {

    var isEditing by remember { mutableStateOf(false) }
    var doorName by remember { mutableStateOf(door.name) }

    val focusRequester = remember { FocusRequester() }

    val favAction = SwipeAction(
        onSwipe = onFavClick,
        background = background,
        icon = rememberVectorPainter(image = R.drawable.star.AsImageVector())
    )

    val unFavAction = SwipeAction(
        onSwipe = onUnFavClick,
        background = background,
        icon = rememberVectorPainter(image = Icons.Filled.Close)
    )

    val editText = SwipeAction(
        onSwipe = {
            isEditing =! isEditing
        },
        background = background,
        icon = rememberVectorPainter(image = R.drawable.edit.AsImageVector())
    )

    SwipeableActionsBox(
        endActions = listOf(favAction, editText),
        startActions = listOf(unFavAction)
    ) {
        Card(
            shape = RoundedCornerShape(10.dp)
        ){
            Column {
                if (door.snapshotImageLink != null)
                    ImageOnCard(link = door.snapshotImageLink!!)
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .height(72.dp)
                        .fillMaxWidth()
                        .padding(24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    if(isEditing){
                        BasicTextField(
                            value = doorName,
                            onValueChange = {
                                doorName = it
                            },
                            modifier = Modifier.focusRequester(focusRequester)
                        )
                        IconButton(
                            onClick = {
                                isEditing =! isEditing
                                onEditClick(doorName)
                                doorName = door.name
                            }
                        ) {
                            Icon(imageVector = Icons.Filled.Check, contentDescription = "")
                        }
                        LaunchedEffect(Unit){
                            focusRequester.requestFocus()
                        }
                    }else{
                        Text(door.name)
                        Image(
                            painter = R.drawable.lockoff.AsPainter(),
                            contentDescription = null
                        )
                    }

                }
            }
        }
    }

}

@Preview
@Composable
fun DoorItemPreview() {

    val context = LocalContext.current

    val door = Door(
        id = 1,
        name = "Door",
        room = "hhh",
        snapshotImageLink = "https://serverspace.ru/wp-content/uploads/2019/06/backup-i-snapshot.png",
        favorites = true
    )

    Box(modifier = Modifier
        .background(background)
        .fillMaxSize()){
        
    }

}