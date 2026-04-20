package com.example.playlistmaker

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.playlistmaker.ui.screen.MainScreen
import com.example.playlistmaker.ui.screen.SearchScreen
import com.example.playlistmaker.ui.screen.SettingsScreen

@Composable
fun PlaylistHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = PlaylistScreen.MAIN.route
    ) {
        composable(route = PlaylistScreen.MAIN.route) {
            MainScreen(
                onSearchClick = { navigateToScreen(navController, PlaylistScreen.SEARCH) },
                onSettingsClick = { navigateToScreen(navController, PlaylistScreen.SETTINGS) }
            )
        }
        composable(route = PlaylistScreen.SEARCH.route) {
            SearchScreen()
        }
        composable(route = PlaylistScreen.SETTINGS.route) {
            SettingsScreen()
        }
    }
}

private fun navigateToScreen(navController: NavController, screen: PlaylistScreen) {
    navController.navigate(screen.route) {
        launchSingleTop = true
        restoreState = true
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
    }
}
