package com.basicapplication.ui.compose.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.basicapplication.ui.compose.theme.BasicApplicationTheme

@Preview
@Composable
fun BasicApplicationAppPreview() {
    BasicApplicationApp()
}

@Composable
fun BasicApplicationApp() {
    BasicApplicationTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
//            Greeting("Android")
            ForLoop(names = listOf("Alon", "Itay", "Moshe", "Yaakov", "Bar"))
        }
    }
}