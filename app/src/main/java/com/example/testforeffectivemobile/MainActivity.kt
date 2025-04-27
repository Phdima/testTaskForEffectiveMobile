package com.example.testforeffectivemobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.core_navigation.AppNavigator
import com.example.core_navigation.NavRoute
import com.example.core_ui.theme.Theme
import com.example.feature_login.LoginScreen
import com.example.feature_main_content.Screens.AccountScreen
import com.example.feature_main_content.Screens.FavoritesScreen
import com.example.feature_main_content.Screens.MainScreen
import com.example.feature_onboarding.OnBoardScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.selects.select
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Theme {
                val navController = rememberNavController()
                navigator.setNavController(navController)

                val currentBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute =
                    currentBackStackEntry?.destination?.route ?: NavRoute.Onboard.route

                Scaffold(
                    bottomBar = {
                        if (NavRoute.bottomBarRoutes.any { it.route == currentRoute }) {
                            NavigationBar(containerColor = MaterialTheme.colorScheme.surfaceContainer) {
                                NavRoute.bottomBarRoutes.forEach() { screen ->
                                    NavigationBarItem(
                                        selected = currentRoute == screen.route,
                                        onClick = { navigator.navigate(screen.route) },
                                        icon = {
                                            Icon(
                                                imageVector = when (screen) {
                                                    NavRoute.Main -> Icons.Outlined.Home
                                                    NavRoute.Favorite -> Icons.Outlined.FavoriteBorder
                                                    NavRoute.Account -> Icons.Outlined.Person
                                                    else -> Icons.Filled.Info
                                                },
                                                contentDescription = screen.route,
                                                tint = if (currentRoute == screen.route) {
                                                    MaterialTheme.colorScheme.secondary
                                                } else MaterialTheme.colorScheme.onPrimary,
                                            )
                                        },
                                        label = { Text(screen.route.replaceFirstChar { it.uppercase() }) },
                                        colors = NavigationBarItemDefaults.colors(
                                            indicatorColor = MaterialTheme.colorScheme.inversePrimary,
                                            unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
                                            selectedTextColor = MaterialTheme.colorScheme.secondary
                                        )
                                    )
                                }
                            }
                        }
                    }
                ) { padding ->
                    NavHost(
                        navController = navController,
                        startDestination = NavRoute.Onboard.route,
                        modifier = Modifier.padding(padding)
                    ) {
                        composable(NavRoute.Onboard.route) { OnBoardScreen(navigator) }
                        composable(NavRoute.Login.route) { LoginScreen(navigator) }
                        composable(NavRoute.Main.route) { MainScreen() }
                        composable(NavRoute.Favorite.route) { FavoritesScreen() }
                        composable(NavRoute.Account.route) { AccountScreen() }
                    }
                }
            }
        }
    }
}
