package com.example.feature_onboarding.ComponentsForScreen

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.feature_onboarding.ComponentsForScreen.RowsForScreen.FifthRow
import com.example.feature_onboarding.ComponentsForScreen.RowsForScreen.FirstRow
import com.example.feature_onboarding.ComponentsForScreen.RowsForScreen.FourthRow
import com.example.feature_onboarding.ComponentsForScreen.RowsForScreen.SecondRow
import com.example.feature_onboarding.ComponentsForScreen.RowsForScreen.ThirdRow

@Composable
fun InfiniteScrollingRows(modifier: Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val offsetX by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = -1f,
        animationSpec = infiniteRepeatable(
            animation = tween(15000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )


    val contentWidth = with(LocalDensity.current) { 600.dp.toPx() }


    Column(
        modifier = modifier
            .clipToBounds()
    )
    {
        Row(
            modifier = Modifier
                .offset { IntOffset((offsetX * contentWidth).toInt(), 0) }
                .wrapContentWidth(unbounded = true)
                .padding(bottom = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            FirstRow()
            FirstRow()
            FirstRow()
            FirstRow()
        }

        Row(
            modifier = Modifier
                .offset { IntOffset((offsetX * contentWidth).toInt(), 0) }
                .wrapContentWidth(unbounded = true)
                .padding(4.dp)
                .zIndex(1f),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            SecondRow()
            SecondRow()
            SecondRow()
            SecondRow()
        }
        Row(
            modifier = Modifier
                .offset { IntOffset((offsetX * contentWidth).toInt(), 0) }
                .wrapContentWidth(unbounded = true)
                .padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            ThirdRow()
            ThirdRow()
            ThirdRow()
            ThirdRow()
        }
        Row(
            modifier = Modifier
                .offset { IntOffset((offsetX * contentWidth).toInt(), 0) }
                .wrapContentWidth(unbounded = true)
                .padding(4.dp)
                .zIndex(1f),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            FourthRow()
            FourthRow()
            FourthRow()
            FourthRow()
        }
        Row(
            modifier = Modifier
                .offset { IntOffset((offsetX * contentWidth).toInt(), 0) }
                .wrapContentWidth(unbounded = true)
                .padding(top = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            FifthRow()
            FifthRow()
            FifthRow()
            FifthRow()
        }
    }

}
