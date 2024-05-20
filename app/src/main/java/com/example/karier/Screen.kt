package com.example.karier

sealed class Screen(val route: String) {
    data object Register : Screen("register")
    data object Login : Screen("login")
    data object Dashboard: Screen("dashboard")
    data object PilihanMinat: Screen("pilihanMinat")
    data object FillUserProfil: Screen("fillUserProfit")
    data object Artikel: Screen("artikel")
    data object JobList: Screen("jobList")

    data object Notification: Screen("notification")
}