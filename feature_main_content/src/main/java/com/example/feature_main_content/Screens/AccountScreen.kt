package com.example.feature_main_content.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun AccountScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text("заглушка", modifier = Modifier.align(Alignment.Center), color = MaterialTheme.colorScheme.secondary, fontSize = 20.sp)
    }
}