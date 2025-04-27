package com.example.core_navigation

sealed class NavRoute(val route: String) {
    object Onboard : NavRoute("onboarding")
    object Login : NavRoute("login")
    object Main : NavRoute("main")
    object Favorite : NavRoute("favorite")
    object Account : NavRoute("account")

    companion object {
        val bottomBarRoutes = setOf(Main, Favorite, Account)
    }
}