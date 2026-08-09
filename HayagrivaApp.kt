package com.s2b.hayagriva.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.animation.core.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.s2b.hayagriva.ui.theme.HayagrivaTheme
import com.s2b.hayagriva.viewmodel.HayagrivaViewModel

@Composable
fun HayagrivaApp(vm: HayagrivaViewModel = viewModel()) {
    HayagrivaTheme {
        var selected by remember { mutableIntStateOf(0) }

        Scaffold(
            containerColor = Color(0xFF08090D),
            bottomBar = {
                NavigationBar(containerColor = Color(0xFF0D0F15)) {
                    val items = listOf(
                        Icons.Default.Home to "Home",
                        Icons.Default.Mic to "Voice",
                        Icons.Default.Visibility to "Vision",
                        Icons.Default.Settings to "Settings"
                    )
                    items.forEachIndexed { index, (icon, label) ->
                        NavigationBarItem(
                            selected = selected == index,
                            onClick = { selected = index },
                            icon = { Icon(icon, null) },
                            label = { Text(label) }
                        )
                    }
                }
            }
        ) { padding ->
            Box(Modifier.padding(padding).fillMaxSize()) {
                when (selected) {
                    0 -> HomeScreen(vm)
                    1 -> VoiceScreen(vm)
                    2 -> VisionScreen(vm)
                    3 -> SettingsScreen()
                }
            }
        }
    }
}

@Composable
private fun HomeScreen(vm: HayagrivaViewModel) {
    Column(
        Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(28.dp))
        Text("S2B", color = Color(0xFFD8B36A), fontWeight = FontWeight.Bold)
        Text("HAYAGRIVA", color = Color.White, style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(28.dp))

        AiCore(state = vm.state)

        Spacer(Modifier.height(24.dp))
        Text(
            text = vm.greeting,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(Modifier.height(18.dp))

        OutlinedTextField(
            value = vm.input,
            onValueChange = vm::setInput,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Ask Hayagriva anything…") },
            trailingIcon = {
                IconButton(onClick = vm::send) {
                    Icon(Icons.Default.Send, contentDescription = "Send")
                }
            },
            singleLine = false
        )

        Spacer(Modifier.height(14.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            AssistChip(onClick = { vm.quick("Solve this maths problem") },
                label = { Text("Math") }, leadingIcon = { Icon(Icons.Default.Calculate, null) })
            AssistChip(onClick = { vm.quick("Start coding mode") },
                label = { Text("Code") }, leadingIcon = { Icon(Icons.Default.Code, null) })
            AssistChip(onClick = { vm.quick("Start research mode") },
                label = { Text("Research") }, leadingIcon = { Icon(Icons.Default.Search, null) })
        }
    }
}

@Composable
private fun VoiceScreen(vm: HayagrivaViewModel) {
    Column(Modifier.fillMaxSize().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(35.dp))
        Text("VOICE MODE", color = Color(0xFFD8B36A), fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(28.dp))
        AiCore(vm.state)
        Spacer(Modifier.height(28.dp))
        Text("Say “Hey Hayagriv”", color = Color.White, style = MaterialTheme.typography.headlineSmall)
        Text("Wake-word engine scaffold is ready for integration.", color = Color.Gray)
        Spacer(Modifier.height(20.dp))
        Button(onClick = vm::toggleListening) {
            Icon(if (vm.listening) Icons.Default.Stop else Icons.Default.Mic, null)
            Spacer(Modifier.width(8.dp))
            Text(if (vm.listening) "Stop Listening" else "Start Listening")
        }
    }
}

@Composable
private fun VisionScreen(vm: HayagrivaViewModel) {
    Column(Modifier.fillMaxSize().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(35.dp))
        Text("VISION", color = Color(0xFFD8B36A), fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(30.dp))
        Icon(Icons.Default.CameraAlt, null, tint = Color.White, modifier = Modifier.size(90.dp))
        Spacer(Modifier.height(20.dp))
        Text("Visual Look-Up & Screen Intelligence", color = Color.White, style = MaterialTheme.typography.headlineSmall)
        Text("CameraX / multimodal model integration point.", color = Color.Gray)
        Spacer(Modifier.height(25.dp))
        Button(onClick = { vm.state = "VISION" }) { Text("Analyze Image") }
    }
}

@Composable
private fun SettingsScreen() {
    Column(Modifier.fillMaxSize().padding(24.dp)) {
        Text("HAYAGRIVA SETTINGS", color = Color(0xFFD8B36A), fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(24.dp))
        SettingRow("Language", "English • தமிழ் • हिन्दी")
        SettingRow("Persona", "Friendly")
        SettingRow("Dark Mode", "Always On")
        SettingRow("Wake Word", "Hey Hayagriv")
        SettingRow("AI Provider", "Backend integration required")
    }
}

@Composable
private fun SettingRow(title: String, value: String) {
    ListItem(
        headlineContent = { Text(title, color = Color.White) },
        supportingContent = { Text(value, color = Color.Gray) },
        containerColor = Color.Transparent
    )
}

@Composable
private fun AiCore(state: String) {
    val isThinking = state == "THINKING"
    var rotation by remember { mutableFloatStateOf(0f) }
    var tilt by remember { mutableFloatStateOf(0f) }

    LaunchedEffect(isThinking) {
        if (isThinking) {
            val infinite = AnimationState(0f)
            while (true) {
                rotation = (rotation + 1.2f) % 360f
                tilt = 8f * kotlin.math.sin(Math.toRadians(rotation.toDouble())).toFloat()
                kotlinx.coroutines.delay(16L)
            }
        } else {
            rotation = 0f
            tilt = 0f
        }
    }

    Box(
        modifier = Modifier.size(230.dp),
        contentAlignment = Alignment.Center
    ) {
        if (isThinking) {
            Image(
                painter = painterResource(com.s2b.hayagriva.R.drawable.hayagriva_thinking_hud),
                contentDescription = "Hayagriva thinking interface",
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        rotationY = rotation
                        rotationX = tilt
                        cameraDistance = 18f * density
                    }
            )
        } else {
            Surface(
                modifier = Modifier.size(190.dp),
                shape = MaterialTheme.shapes.extraLarge,
                color = Color(0xFF11131B),
                tonalElevation = 8.dp
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        Icons.Default.AutoAwesome,
                        contentDescription = null,
                        tint = Color(0xFFD8B36A),
                        modifier = Modifier.size(72.dp)
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(top = 95.dp)
                    ) {
                        Text(state, color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

