package com.example.core_ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core_retrofit.Course
import com.example.core_ui.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.random.Random

@Composable
fun CourseCard(
    course: Course,
    onLikeClick: (Int) -> Unit,
    modifier: Modifier,
) {

    Column(
        modifier = modifier
            .height(236.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = MaterialTheme.colorScheme.surfaceContainer)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(114.dp)
        ) {

            Image(
                painter = painterResource(R.mipmap.javacourse_foreground),
                contentDescription = "JavaCourse",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopStart
            )


            Row(
                modifier = Modifier
                    .height(22.dp)
                    .align(Alignment.BottomStart)
                    .padding(horizontal = 8.dp),
            ) {
                Row(
                    modifier = Modifier
                        .height(22.dp)
                        .padding(end = 4.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(color = MaterialTheme.colorScheme.primary),

                    ) {

                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star",
                        tint = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(horizontal = 4.dp)
                    )

                    Text(
                        course.rate,
                        maxLines = 1,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 12.sp, modifier = Modifier.padding(end = 4.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .height(22.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(color = MaterialTheme.colorScheme.primary)

                ) {
                    Text(
                        course.startDate.toFormattedDate(),
                        maxLines = 1,
                        color = MaterialTheme.colorScheme.onPrimary, fontSize = 12.sp
                    )
                }

            }

            Button(
                onClick = { onLikeClick(course.id) },
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .align(Alignment.TopEnd),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = if (course.hasLike) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onPrimary,
                    disabledContentColor = if (course.hasLike) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onPrimary
                )

            ) {
                Icon(
                    imageVector = if (course.hasLike) Icons.Outlined.FavoriteBorder else Icons.Default.FavoriteBorder,
                    contentDescription = "Star",
                    modifier = Modifier

                )
            }

        }

        Column(
            Modifier
                .padding(14.dp)

        ) {
            Text(
                text = course.title,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = course.text,
                modifier = Modifier
                    .fillMaxWidth(),
                fontSize = 12.sp,
                maxLines = 2,
                color = MaterialTheme.colorScheme.onTertiary
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = course.price,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onPrimary,
                )
                Row(modifier = Modifier.clickable { }) {
                    Text(
                        text = "Подробнее ",
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.secondary,

                        )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "arrow",
                        tint = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }
        }

    }
}


@SuppressLint("NewApi")
fun String.toFormattedDate(): String {
    return try {
        val formatterInput = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = LocalDate.parse(this, formatterInput)

        val formatterOutput = DateTimeFormatter.ofPattern(
            "d MMMM yyyy",
            java.util.Locale("ru", "RU")
        )
        date.format(formatterOutput)
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    } catch (e: Exception) {
        this
    }
}