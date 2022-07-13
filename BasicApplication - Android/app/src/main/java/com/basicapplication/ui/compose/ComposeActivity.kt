package com.basicapplication.ui.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.basicapplication.ui.compose.components.compose_basics.BasicApplicationApp
import com.basicapplication.ui.compose.components.self_tests.StackedModifiers

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StackedModifiers()
        }
    }
}