package com.example.karier.presentation.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.karier.R
import com.example.karier.presentation.Navigation.NavigationItem
import com.example.karier.ui.theme.PrimaryBlue300
import com.example.karier.ui.theme.PrimaryGreen500
import com.example.karier.ui.theme.SecondaryBackground

@Composable
fun BottomBar(
    navHostController: NavController,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier
            .shadow(
                elevation = 25.dp,
                spotColor = Color.White,
                ambientColor = SecondaryBackground,
                shape = RoundedCornerShape(12.dp),
                clip = true
            )
            .clip(RoundedCornerShape(12.dp)),
        containerColor = PrimaryBlue300,
        contentColor = PrimaryGreen500,
    ) {

        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf<NavigationItem>(
            NavigationItem(
                title = "Beranda",
                icon = ImageVector.vectorResource(id = R.drawable.icon_beranda),
//                screen = Screen.Dashboard,
            ),
            NavigationItem(
                title = "Lowongan",
                icon = ImageVector.vectorResource(id = R.drawable.icon_lowongan),
//                screen = Screen.Lowongan,
            ),
            NavigationItem(
                title = "Pelatihan",
                icon = ImageVector.vectorResource(id = R.drawable.icon_pelatihan),
//                screen = Screen.Pelatihan,
            ),
            NavigationItem(
                title = "Aktifitas",
                icon = ImageVector.vectorResource(id = R.drawable.icon_aktifitas),
//                screen = Screen.Aktifitas,
            ),
            NavigationItem(
                title = "Profil",
                icon = ImageVector.vectorResource(id = R.drawable.icon_akun),
//                screen = Screen.Profil,
            ),
        )

        navigationItems.map { item ->

            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                label = { Text(text = item.title, style = MaterialTheme.typography.labelSmall) },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = PrimaryGreen500,
                    selectedTextColor = PrimaryGreen500,
                    indicatorColor = PrimaryGreen500,
                    unselectedIconColor = PrimaryGreen500,
                    unselectedTextColor = PrimaryGreen500,
                ),
                onClick = {
//                    navHostController.navigate(item.screen.route) {
//                        if (item.screen.route == Screen.Beranda.route) {
//                            popUpTo(navHostController.graph.findStartDestination().id) {
//                                saveState = true
//                            }
//
//                            restoreState = true
//                            launchSingleTop = true
//                        } else {
//                            popUpTo(Screen.Beranda.route) {
//                                saveState = true
//                            }
//
//                            restoreState = true
//                            launchSingleTop = true
//                        }
//                    }
                },
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun BottomBarNavigationPreview() {
    BottomBar(navHostController = rememberNavController())
}