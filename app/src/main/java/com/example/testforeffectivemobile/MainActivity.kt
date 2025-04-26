package com.example.testforeffectivemobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core_navigation.AppNavigator
import com.example.core_navigation.NavRoute
import com.example.core_navigation.Navigator
import com.example.core_ui.theme.Theme
import com.example.feature_login.LoginScreen
import com.example.feature_onboarding.OnBoardScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigator: AppNavigator


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                android.graphics.Color.TRANSPARENT,
            )
        )

        setContent {
            Theme {
                val navController = rememberNavController()
                navigator.setNavController(navController)

                NavHost(
                    navController = navController,
                    startDestination = NavRoute.Onboard.route
                ) {
                    composable(NavRoute.Onboard.route) {
                        OnBoardScreen(navigator)
                    }

                    composable(NavRoute.Login.route){
                        LoginScreen(navigator)
                    }

                }
            }
        }
    }
}

