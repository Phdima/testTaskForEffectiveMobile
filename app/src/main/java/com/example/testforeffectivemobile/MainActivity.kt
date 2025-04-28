package com.example.testforeffectivemobile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.core_navigation.AppNavigator
import com.example.core_navigation.NavRoute
import com.example.core_ui.theme.Theme
import com.example.feature_login.LoginScreen
import com.example.feature_main_content.CoursesUseCase
import com.example.feature_main_content.Screens.AccountScreen
import com.example.feature_main_content.Screens.FavoritesScreen
import com.example.feature_main_content.Screens.MainScreen
import com.example.feature_onboarding.AppPreferences
import com.example.feature_onboarding.OnBoardScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigator: AppNavigator
    @Inject
    lateinit var coursesUseCase: CoursesUseCase
    @Inject
    lateinit var appPreferences: AppPreferences

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            lifecycleScope.launch {
                coursesUseCase.loadAndCacheCourses()
            }


            Theme {
                val navController = rememberNavController()
                navigator.setNavController(navController)

                val startDestination = if (appPreferences.isFirstLaunch) {
                    NavRoute.Onboard.route
                } else {
                    NavRoute.Login.route
                }

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
                        startDestination = startDestination,
                        modifier = Modifier.padding(padding)
                    ) {
                        composable(NavRoute.Onboard.route) {
                            OnBoardScreen(
                                navigator,
                                onCompleted = { appPreferences.isFirstLaunch = false })
                        }
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
