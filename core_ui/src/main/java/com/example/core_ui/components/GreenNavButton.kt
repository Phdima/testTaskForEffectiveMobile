package com.example.core_ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core_navigation.Navigator

@Composable
fun GreenNavButton(
    onCompleted: () -> Unit,
    navigator: Navigator,
    destination: String,
    modifier: Modifier,
    text: String
) {


    Button(
        onClick = {
            onCompleted()
            navigator.navigate(destination)
        },
        modifier = modifier
            .height(40.dp),
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.secondary,
            disabledContentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Text(text)
    }

}
