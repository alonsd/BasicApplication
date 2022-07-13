package com.basicapplication.ui.compose.components.self_tests

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun StackModifiersTest() {
    StackedModifiers()
}


@Composable
fun StackedModifiers(sizeCap : Int = 3) {

    var sizeState by remember { mutableStateOf(9.dp) }
    var currentSizeCounter by remember() { mutableStateOf(0)}
    val size by animateDpAsState(
        targetValue = sizeState,
        spring(Spring.DampingRatioHighBouncy)
    )
    val color by rememberInfiniteTransition()
        .animateColor(initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 400), repeatMode = RepeatMode.Reverse
        ))
    val color2 by rememberInfiniteTransition()
        .animateColor(initialValue = Color.Magenta,
        targetValue = Color.Yellow,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 800, easing = FastOutLinearInEasing)
        ))
    val color3 by rememberInfiniteTransition()
        .animateColor(initialValue = Color.Gray,
        targetValue = Color.Cyan,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 1200)
        ))
    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(width = size, color = color)
            .padding(16.dp)
            .border(width = size, color = color2)
            .padding(16.dp)
            .border(width = size, color = color3)
            .padding(16.dp)
            .border(width = size, color = color)
            .padding(16.dp)
            .border(width = size, color = color2)
            .padding(16.dp)
            .border(width = size, color = color3)
            .padding(16.dp)
            .border(width = size, color = color)
            .padding(16.dp)
            .clickable {
                if (currentSizeCounter == sizeCap) {
                    currentSizeCounter = 0
                    sizeState -= (40 * sizeCap).dp
                    return@clickable
                }
                currentSizeCounter++
                sizeState += 40.dp
            }
    )
}