package com.example.feature_main_content.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core_navigation.Navigator
import com.example.core_retrofit.Course
import com.example.core_ui.components.CourseCard
import com.example.feature_main_content.CoursesViewModel
import com.example.feature_main_content.R

@Composable
fun MainScreen() {
    var textForTextField by remember { mutableStateOf("") }
    val viewModel: CoursesViewModel = hiltViewModel()
    val courses by viewModel.courses.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(top = 56.dp),
    ) {
        LazyColumn {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    TextField(
                        value = textForTextField,
                        onValueChange = { textForTextField = it },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "кнопка поиска",
                                tint = MaterialTheme.colorScheme.onPrimary,
                            )
                        },
                        placeholder = {
                            Text(
                                "Search courses...",
                                fontSize = 14.sp,
                                maxLines = 1,
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = MaterialTheme.colorScheme.inversePrimary,
                            unfocusedContainerColor = MaterialTheme.colorScheme.inversePrimary,
                            focusedTextColor = MaterialTheme.colorScheme.onPrimary,
                            unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
                            focusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary,
                            unfocusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        textStyle = LocalTextStyle.current.copy(
                            fontSize = 14.sp,
                        ),
                        singleLine = true,
                        modifier = Modifier
                            .padding(end = 4.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .height(56.dp)
                            .width(264.dp)


                    )
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .height(56.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .background(
                                color =
                                MaterialTheme.colorScheme.inversePrimary
                            )
                    ) {
                        Icon(
                            painter = painterResource(com.example.core_ui.R.drawable.outline_filter_alt_24),
                            contentDescription = "Фильтр",
                            tint = MaterialTheme.colorScheme.onPrimary,
                        )
                    }
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp, end = 16.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "По дате добавления",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .clickable {
                                courses.sortedByDescending { course -> course.publishDate }
                            }
                            .padding(4.dp)
                    )
                    Icon(
                        imageVector = Icons.Outlined.ArrowDropDown,
                        contentDescription = "Фильтр",
                        tint = MaterialTheme.colorScheme.onPrimary,
                    )
                }
            }


            items(courses) { course ->
                Box(
                    modifier = Modifier
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                )
                {
                    CourseCard(
                        course = course,
                        onLikeClick = { courseId -> viewModel.toggleLike(courseId) },
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                }
            }


        }
    }
}