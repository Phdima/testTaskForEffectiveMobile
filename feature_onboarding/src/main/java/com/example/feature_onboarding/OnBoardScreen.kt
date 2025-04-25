package com.example.feature_onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.Navigator


@Composable
fun OnBoardScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Text(
            "Тысячи курсов  в одном месте",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 140.dp)
        )
        Column(
            modifier = Modifier
                .width(538.dp)
                .height(316.dp)
                .background(color = Color.Cyan)
                .graphicsLayer { clip = false }
                .align(Alignment.Center)

        ) {
            Row(
                modifier = Modifier
                    .wrapContentWidth(unbounded = true)
                    .width(405.dp)
                    .height(60.dp)
                    .background(color = Color.Red)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(208.dp)
                        .height(60.dp)
                ) {}
                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(111.dp)
                        .height(60.dp)
                ) {}
                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(150.dp)
                        .height(60.dp)
                ) {}
            }
            Row(
                modifier = Modifier
                    .wrapContentWidth(unbounded = true)
                    .width(538.dp)
                    .height(52.dp)
                    .background(color = Color.Black)

            ){
                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(121.dp)
                        .height(52.dp)
                ) {}
                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(118.dp)
                        .height(52.dp)
                ) {}
                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(110.dp)
                        .height(52.dp)
                ) {}
                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(177.dp)
                        .height(52.dp)
                ) {}
            }
        }


        Button(
            onClick = {},
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(40.dp)
                .width(328.dp)
                .offset(y = -56.dp)
        ) {

        }
    }
}