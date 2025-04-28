package com.example.core_network

import java.time.LocalDate

data class CoursesResponse(
    val courses: List<Course>
)

data class Course(
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    var hasLike: Boolean,
    val publishDate: String,
)

