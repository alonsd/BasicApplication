package com.basicapplication.ui.compose.components.compose_layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun PhotographerCardPreview() {
    PhotographerCard()
}

@Composable
fun PhotographerCard() {

    Row {
        Surface(
            modifier = Modifier.size(50.dp),

        ) {
            
        }
    }
    Column {
        Text("Alfred Sisley", fontWeight = FontWeight.Bold)
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text("3 Minutes ago", style = MaterialTheme.typography.body2)
        }
    }

}










