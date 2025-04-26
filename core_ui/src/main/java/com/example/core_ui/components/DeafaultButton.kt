package com.example.core_ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun DefaultButton(
    text: String,
    modifier: Modifier,
) {

    Box() {
        Box(
            modifier = Modifier
                .matchParentSize()
                .blur(21.dp, edgeTreatment = BlurredEdgeTreatment(MaterialTheme.shapes.extraLarge))
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = MaterialTheme.shapes.extraLarge
                )


        )
        Button(
            onClick = {  },
            modifier = modifier,
            colors = ButtonColors(
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {

            Text(text = text, maxLines = 1)
        }
    }

}

