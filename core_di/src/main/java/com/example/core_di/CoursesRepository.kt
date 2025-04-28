package com.example.core_di

import com.example.core_network.ApiService
import com.example.core_network.Course
import javax.inject.Inject

interface CoursesRepository {
    suspend fun fetchCourses(): List<Course>
    fun getCachedCourses(): List<Course>
}

class CoursesRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : CoursesRepository {
    private var cachedCourses: List<Course> = emptyList()

    override suspend fun fetchCourses(): List<Course> {
        return apiService.getCourses().courses
            .map { it.copy(hasLike = false) }
            .also { cachedCourses = it }
    }

    override fun getCachedCourses(): List<Course> = cachedCourses
}