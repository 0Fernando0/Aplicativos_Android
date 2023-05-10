package com.example.dizimistafiel.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val navController: NavHostController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {

        BottomNav(navController = navController)

    }

}

@Composable
fun BottomBar(navController: NavHostController) {

    val screen = listOf(
        BottonBarScreen.CalculadoraButton,
        BottonBarScreen.DizimarButton
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screen.forEach {
            screen -> AddItem(screen = screen,
            currentDestination = currentDestination,
            navController = navController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottonBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.label)
        },
        icon = {
            Icon(painter = painterResource(id = screen.icon),
                contentDescription = screen.label,
            modifier = Modifier
                .size(28.dp))
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route)
        },
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled)
    )
}