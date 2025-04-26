package com.example.feature_onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.sp
import com.example.core_navigation.Navigator
import com.example.core_ui.components.GreenNavButton
import com.example.feature_onboarding.ComponentsForScreen.InfiniteScrollingRows


@Composable
fun OnBoardScreen(navigator: Navigator) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {

        Text(
            "Тысячи курсов \n в одном месте",
            fontSize = 28.sp,
            lineHeight = 36.sp,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 140.dp),
            color = MaterialTheme.colorScheme.onPrimary
        )
        InfiniteScrollingRows(
            modifier = Modifier
                .width(538.dp)
                .height(316.dp)
                .align(Alignment.Center)
        )
        GreenNavButton(modifier = Modifier.width(328.dp).align(Alignment.BottomCenter).offset(y = -56.dp), navigator = navigator, text = "Продолжить")
    }
}