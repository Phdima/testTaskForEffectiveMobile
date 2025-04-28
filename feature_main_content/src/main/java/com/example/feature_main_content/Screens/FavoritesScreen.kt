package com.example.feature_main_content.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun FavoritesScreen(){
    Box(modifier = Modifier.fillMaxSize()) {
        Text("Здесь должна быть ROOM, но я ее не добавлял", modifier = Modifier.align(Alignment.Center), color = MaterialTheme.colorScheme.secondary, fontSize = 20.sp)
    }
}