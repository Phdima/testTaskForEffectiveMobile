package com.example.core_ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate

@Composable
fun ObliqueButton(
    text: String,
    modifier: Modifier,
    isLeftCornerFlight: Boolean
) {
    Button(
        onClick = {},
        modifier = modifier.rotate(
            if (isLeftCornerFlight) 15f
            else -15f
        ),
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.secondary,
            disabledContentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Text(text = text, maxLines = 1)
    }
}