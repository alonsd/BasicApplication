package com.basicapplication.ui.compose.components.compose_basics

import android.content.res.Configuration.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.basicapplication.ui.compose.theme.BasicApplicationTheme

@Preview(showBackground = true)
@Preview(showBackground = true,
    name = "GreetingPreviewDark",
    uiMode = UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview(@PreviewParameter(NamePreviewParameter::class) name : String) {
    BasicApplicationTheme {
        Greeting(name)
    }
}

@Composable
fun Greeting(name: String) {
     Card(
         backgroundColor = MaterialTheme.colors.primary,
         modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
     ) {
         GreetingCardContent(name = name)
     }
}

class NamePreviewParameter : PreviewParameterProvider<String>{
    override val values: Sequence<String>
        get() = sequenceOf("alon", "moti")

}
