package com.s2b.hayagriva

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HayagrivaApp() {
    var prompt by remember { mutableStateOf("") }
    var messages by remember { mutableStateOf(listOf("Hello! I am S2B Hayagriva.")) }

    MaterialTheme {
        Scaffold(
            topBar = { TopAppBar(title = { Text("S2B Hayagriva") }) }
        ) { padding ->
            Column(
                modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(messages) { message ->
                        Card(modifier = Modifier.fillMaxWidth()) {
                            Text(message, modifier = Modifier.padding(16.dp))
                        }
                    }
                }

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = prompt,
                        onValueChange = { prompt = it },
                        modifier = Modifier.weight(1f),
                        label = { Text("Ask Hayagriva") },
                        singleLine = true
                    )
                    Button(onClick = {
                        if (prompt.isNotBlank()) {
                            messages = messages + "You: $prompt" + "Hayagriva: I received your request. AI services can be connected next."
                            prompt = ""
                        }
                    }) { Text("Send") }
                }
            }
        }
    }
}
