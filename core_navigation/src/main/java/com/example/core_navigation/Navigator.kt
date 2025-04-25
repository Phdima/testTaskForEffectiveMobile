package com.example.core_navigation

import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface Navigator {
    fun navigate(route: String)
    fun navigateBack()
    fun setGraph(graph: NavGraphBuilder.() -> Unit)
}

class AppNavigator : Navigator {
    private val navController = mutableStateOf<NavController?>(null)

    override fun navigate(route: String) {
        navController.value?.navigate(route)
    }

    override fun navigateBack() {
        navController.value?.popBackStack()
    }

    override fun setGraph(graph: NavGraphBuilder.() -> Unit) {}

    fun setNavController(controller: NavController) {
        navController.value = controller
    }
}