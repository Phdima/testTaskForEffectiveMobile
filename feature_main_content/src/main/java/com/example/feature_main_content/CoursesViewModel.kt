package com.example.feature_main_content


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_network.Course
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoursesViewModel @Inject constructor(
    private val coursesUseCase: CoursesUseCase
) : ViewModel() {

    private val _courses = MutableStateFlow<List<Course>>(emptyList())
    val courses: StateFlow<List<Course>> = _courses.asStateFlow()

    init { loadCourses() }

    private fun loadCourses() {
        viewModelScope.launch {
            _courses.value = coursesUseCase.getCourses()
        }
    }

    fun toggleLike(courseId: Int) {
        _courses.update { current ->
            current.map {
                if (it.id == courseId) it.copy(hasLike = !it.hasLike)
                else it
            }
        }
    }
}