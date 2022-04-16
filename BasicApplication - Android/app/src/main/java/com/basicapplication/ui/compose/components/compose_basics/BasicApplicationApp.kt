package com.basicapplication.ui.compose.components.compose_basics

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.basicapplication.ui.compose.theme.BasicApplicationTheme

@Preview
@Composable
fun MainScreenPreview() {
    BasicApplicationApp()
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DarkListPreview() {
    BasicApplicationTheme {
        GreetingsList()
    }
}

@Composable
fun BasicApplicationApp() {

    var shouldShowOnBoarding by rememberSaveable { mutableStateOf(true) }

    BasicApplicationTheme {
        if (shouldShowOnBoarding) {
            OnBoardingScreen {
                shouldShowOnBoarding = false
            }
         } else {
            GreetingsList()
        }

    }
}

