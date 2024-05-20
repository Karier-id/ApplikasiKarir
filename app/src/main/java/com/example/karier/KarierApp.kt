package com.example.karier

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.karier.presentation.Artikel.ArtikelScreen
import com.example.karier.presentation.Dashboard.DashboardScreen
import com.example.karier.presentation.JobList.JobListScreen
import com.example.karier.presentation.Login.LoginScreen
import com.example.karier.presentation.PilihanMinat.PilihanMinatScreen
import com.example.karier.presentation.Profil.UserFillProfileScreen
import com.example.karier.presentation.Register.RegistrasiScreen
import com.example.karier.presentation.component.BottomBar

@Composable
fun KarierApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (
                currentRoute == Screen.Dashboard.route
                || currentRoute == Screen.JobList.route
            ) {
                BottomBar(navHostController = navController)
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = Screen.Login.route) {
                LoginScreen(navigateToRegister = {
                    navController.navigate(route = Screen.Register.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                    navigateToDashboard = { navController.navigate(Screen.Dashboard.route) })
            }
            composable(route = Screen.Register.route) {
                RegistrasiScreen(navigateBack = {
                    navController.navigateUp()
                },
                    navigateToPilihanMinat = { navController.navigate(Screen.PilihanMinat.route) })
            }
            composable(route = Screen.Dashboard.route) {
                DashboardScreen(navigateToDetail = {
                    navController.navigate(Screen.Artikel.route)
                },
                    navigateToJobList = { navController.navigate(Screen.JobList.route) },
                    navigateToNotification = { navController.navigate(Screen.Notification.route)}
                )
            }
            composable(route = Screen.PilihanMinat.route) {
                PilihanMinatScreen(navigateBack = {
                    navController.navigateUp()
                },
                    navigateToFillProfile = {
                        navController.navigate(Screen.FillUserProfil.route)
                    }
                )
            }
            composable(route = Screen.FillUserProfil.route) {
                UserFillProfileScreen(
                    navigateBack = {
                        navController.navigateUp()
                    }, navigateDashboard = {
                        navController.navigate(Screen.Dashboard.route)
                    }
                )
            }
            composable(route = Screen.Artikel.route) {
                ArtikelScreen(
                    navigateBack = { navController.navigateUp() }
                )
            }
            composable(route = Screen.JobList.route) {
                JobListScreen(navigationToNotification = {navController.navigate(Screen.Notification.route)})
            }
        }
    }
}