package com.example.core_navigation

sealed class NavRoute(val route: String) {
    object Onboard : NavRoute("onboarding")
    object Login : NavRoute("login")
}