package com.example.feature_onboarding.ComponentsForScreen.RowsForScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.core_ui.components.DefaultButton

@Composable
fun SecondRow(){
    Row(
        modifier = Modifier
            .wrapContentWidth(unbounded = true)
            .fillMaxWidth()
            .zIndex(1f)
            .padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        DefaultButton(
            text = "Контент маркетинг",
            modifier = Modifier
                .height(52.dp)
        )
        DefaultButton(
            text = "B2B маркетинг",
            modifier = Modifier
                .height(52.dp)
        )
        DefaultButton(
            text = "Google Аналитика",
            modifier = Modifier
                .height(52.dp)
        )
    }
}