package com.orpopu.finanzas.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.orpopu.finanzas.ui.screens.ConfiguracionScreen
import com.orpopu.finanzas.ui.screens.DashboardScreen
import com.orpopu.finanzas.ui.screens.GastosScreen
import com.orpopu.finanzas.ui.screens.IngresosScreen
import com.orpopu.finanzas.ui.screens.MetasScreen

sealed class FinanzasRoute(val route: String, val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    data object Dashboard : FinanzasRoute("dashboard", "Inicio", Icons.Filled.Home)
    data object Ingresos : FinanzasRoute("ingresos", "Ingresos", Icons.Filled.MonetizationOn)
    data object Gastos : FinanzasRoute("gastos", "Gastos", Icons.Filled.AccountBalance)
    data object Metas : FinanzasRoute("metas", "Metas", Icons.Filled.Flag)
    data object Configuracion : FinanzasRoute("configuracion", "Ajustes", Icons.Filled.Settings)
}

private val bottomItems = listOf(
    FinanzasRoute.Dashboard,
    FinanzasRoute.Ingresos,
    FinanzasRoute.Gastos,
    FinanzasRoute.Metas,
    FinanzasRoute.Configuracion
)

@Composable
fun FinanzasNavigation(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = modifier,
        bottomBar = {
            NavigationBar {
                bottomItems.forEach { item ->
                    val selected = currentRoute == item.route
                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            if (!selected) {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                        icon = { androidx.compose.material3.Icon(item.icon, contentDescription = item.label) },
                        label = { androidx.compose.material3.Text(item.label) }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = FinanzasRoute.Dashboard.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(FinanzasRoute.Dashboard.route) {
                DashboardScreen(onNavigate = { navController.navigate(it) })
            }
            composable(FinanzasRoute.Ingresos.route) {
                IngresosScreen(onNavigate = { navController.navigate(it) })
            }
            composable(FinanzasRoute.Gastos.route) {
                GastosScreen(onNavigate = { navController.navigate(it) })
            }
            composable(FinanzasRoute.Metas.route) {
                MetasScreen(onNavigate = { navController.navigate(it) })
            }
            composable(FinanzasRoute.Configuracion.route) {
                ConfiguracionScreen()
            }
        }
    }
}
