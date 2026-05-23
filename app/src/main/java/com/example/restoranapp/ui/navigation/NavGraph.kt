package com.example.restoranapp.ui.navigation

import androidx.compose.animation.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.restoranapp.data.PreferenceManager
import com.example.restoranapp.ui.screens.*

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Menu : Screen("menu")
    object DetailMenu : Screen("detail/{menuId}") {
        fun createRoute(menuId: Int) = "detail/$menuId"
    }
    object Profile : Screen("profile")
    object EditProfile : Screen("edit_profile")
}

@Composable
fun NavGraph(
    navController: NavHostController,
    prefManager: PreferenceManager,
    isDarkMode: Boolean,
    onThemeToggle: (Boolean) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(onNext = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            })
        }

        composable(
            route = Screen.Home.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            HomeScreen(
                navController = navController,
                prefManager = prefManager,
                isDarkMode = isDarkMode,
                onThemeToggle = onThemeToggle
            )
        }

        composable(
            route = Screen.Menu.route,
            enterTransition = { slideInHorizontally { it } + fadeIn() },
            exitTransition = { slideOutHorizontally { -it } + fadeOut() }
        ) {
            MenuScreen(navController = navController)
        }

        composable(
            route = Screen.DetailMenu.route,
            arguments = listOf(navArgument("menuId") { type = NavType.IntType }),
            enterTransition = { slideInHorizontally { it } + fadeIn() },
            exitTransition = { slideOutHorizontally { -it } + fadeOut() }
        ) { backStackEntry ->
            val menuId = backStackEntry.arguments?.getInt("menuId") ?: 0
            DetailMenuScreen(menuId = menuId, navController = navController)
        }

        composable(
            route = Screen.Profile.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            ProfileScreen(navController = navController, prefManager = prefManager)
        }

        composable(
            route = Screen.EditProfile.route,
            enterTransition = { slideInHorizontally { it } + fadeIn() },
            exitTransition = { slideOutHorizontally { -it } + fadeOut() }
        ) {
            EditProfileScreen(navController = navController, prefManager = prefManager)
        }
    }
}
