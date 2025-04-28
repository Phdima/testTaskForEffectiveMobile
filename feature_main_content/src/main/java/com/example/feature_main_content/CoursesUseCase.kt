package com.example.feature_main_content

import com.example.core_di.CoursesRepository
import com.example.core_network.ApiService
import com.example.core_network.Course
import javax.inject.Inject

class CoursesUseCase @Inject constructor(
    private val repository: CoursesRepository
) {
    suspend fun loadAndCacheCourses() = repository.fetchCourses()
    fun getCachedCourses() = repository.getCachedCourses()
}