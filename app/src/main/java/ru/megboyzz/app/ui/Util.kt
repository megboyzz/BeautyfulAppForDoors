package ru.megboyzz.app.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource

@Composable
fun Int.AsPainter() = painterResource(this)

@Composable
fun Int.AsImageVector() = ImageVector.vectorResource(id = this)

fun Context.makeText(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()