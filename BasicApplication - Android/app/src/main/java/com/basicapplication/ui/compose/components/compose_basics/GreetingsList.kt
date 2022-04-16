package com.basicapplication.ui.compose.components.compose_basics

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.basicapplication.ui.compose.theme.BasicApplicationTheme

@Preview(showBackground = true, name = "GreetingsListPreviewDark", uiMode = UI_MODE_NIGHT_YES)
@Preview(showBackground = true, name = "GreetingsListPreview", uiMode = UI_MODE_NIGHT_NO)
@Composable
fun GreetingsListPreview() {
    BasicApplicationTheme {
        GreetingsList()
    }
}


@Composable
fun GreetingsList(names: List<String> = List(1000) { "$it" }) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}