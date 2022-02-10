package com.basicapplication.ui.compose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.basicapplication.ui.application_flow.Greeting

@Preview(showBackground = true, name = "ForLoop")
@Composable
fun ForLoopPreview() {
    ForLoop(names = listOf("Alon", "Itay", "Moshe", "Yaakov", "Bar"))
}

@Composable
fun ForLoop(names : List<String> = listOf("Alon, Itay, Moshe")) {
    Column {
        for (name in names) {
            Greeting(name = name)
        }
    }
}