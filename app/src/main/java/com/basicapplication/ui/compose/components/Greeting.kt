package com.basicapplication.ui.compose.components

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
import androidx.compose.ui.unit.dp
import com.basicapplication.ui.compose.theme.BasicApplicationTheme

@Preview(showBackground = true)
@Preview(showBackground = true,
    name = "GreetingPreviewDark",
    uiMode = UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    BasicApplicationTheme {
        Greeting("world")
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

//@Composable
//fun Greeting(name: String) {
//
//    var expanded by remember { mutableStateOf(false) }
//
//    val extraPadding by animateDpAsState(
//        if (expanded) 48.dp else 0.dp,
//        animationSpec = spring(
//            dampingRatio = Spring.DampingRatioMediumBouncy,
//            stiffness = Spring.StiffnessLow
//        )
//    )
//    Surface(
//        color = MaterialTheme.colors.primary,
//        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//    ) {
//        Row(modifier = Modifier.padding(24.dp)) {
//            Column(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
//            ) {
//                Text(text = "Hello, ")
//                Text(text = name)
//            }
//            OutlinedButton(
//                onClick = { expanded = !expanded }
//            ) {
//                Text(if (expanded) "Show less" else "Show more")
//            }
//        }
//    }
//}