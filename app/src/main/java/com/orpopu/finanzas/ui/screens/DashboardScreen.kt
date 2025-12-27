package com.orpopu.finanzas.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.orpopu.finanzas.FinanzasApp
import com.orpopu.finanzas.ui.navigation.FinanzasRoute
import com.orpopu.finanzas.viewmodel.DashboardViewModel
import com.orpopu.finanzas.viewmodel.FinanzasViewModelFactory

@Composable
fun DashboardScreen(onNavigate: (String) -> Unit) {
    val context = LocalContext.current
    val viewModel: DashboardViewModel = viewModel(
        factory = FinanzasViewModelFactory((context.applicationContext as FinanzasApp).repository)
    )
    val uiState = viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Dashboard",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Resumen general de tus finanzas y distribución del ingreso.",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Ingresos registrados: ${uiState.value.ingresosCount}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Gastos registrados: ${uiState.value.gastosCount}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Metas registradas: ${uiState.value.metasCount}",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { onNavigate(FinanzasRoute.Ingresos.route) }) {
            Text("Ver ingresos")
        }
        Button(onClick = { onNavigate(FinanzasRoute.Gastos.route) }) {
            Text("Ver gastos")
        }
        Button(onClick = { onNavigate(FinanzasRoute.Metas.route) }) {
            Text("Ver metas")
        }
    }
}
