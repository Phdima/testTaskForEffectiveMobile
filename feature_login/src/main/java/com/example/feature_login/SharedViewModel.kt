package com.example.feature_login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val isError = mutableStateOf(false)
}