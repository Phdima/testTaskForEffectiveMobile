package com.example.feature_main_content

import com.example.core_retrofit.ApiService
import com.example.core_retrofit.Course
import javax.inject.Inject

class CoursesUseCase @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCourses(): List<Course> {
        return try {
            apiService.getCourses().courses
        } catch (e: Exception) {
            emptyList()
        }
    }
}