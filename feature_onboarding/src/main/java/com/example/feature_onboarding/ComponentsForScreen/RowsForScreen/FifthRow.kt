package com.example.feature_onboarding.ComponentsForScreen.RowsForScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core_ui.components.DefaultButton
import com.example.core_ui.components.ObliqueButton

@Composable
fun FifthRow(){

        DefaultButton(
            text = "Webflow",
            modifier = Modifier
                .height(60.dp)
        )
        ObliqueButton(
            text = "Three.js",
            isLeftCornerFlight = false,
            modifier = Modifier
                .offset(y = (-10).dp)
                .height(60.dp)
        )
        DefaultButton(
            text = "Парсинг",
            modifier = Modifier
                .height(60.dp)
        )
        DefaultButton(
            text = "Python-разработка",
            modifier = Modifier
                .height(60.dp)
        )

}