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
fun FourthRow(){

        DefaultButton(
            text = "Геймдизайн",
            modifier = Modifier
                .height(52.dp)
        )
        DefaultButton(
            text = "Веб-дизайн",
            modifier = Modifier
                .height(52.dp)
        )
        DefaultButton(
            text = "Cinema 4D",
            modifier = Modifier
                .height(52.dp)
        )
        DefaultButton(
            text = "Промпт инженеринг",
            modifier = Modifier
                .height(52.dp)
        )

}