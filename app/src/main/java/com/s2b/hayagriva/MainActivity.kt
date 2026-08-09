package com.s2b.hayagriva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HayagrivaScreen()
        }
    }
}

@Composable
fun HayagrivaScreen() {

    var status by remember {
        mutableStateOf("HAYAGRIV IS READY")
    }

    var thinking by remember {
        mutableStateOf(false)
    }

    MaterialTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "S2B",
                style = MaterialTheme.typography.displayMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "HAYAGRIV AI",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = if (thinking) {
                    "◉\n\nTHINKING...\n\n●  ●  ●"
                } else {
                    "◉\n\nREADY"
                },
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = status,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {
                    thinking = true
                    status = "LISTENING..."
                }
            ) {
                Text("🎙  HEY HAYAGRIV")
            }
        }
    }
}
