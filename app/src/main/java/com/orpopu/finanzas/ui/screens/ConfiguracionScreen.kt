package com.orpopu.finanzas.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.orpopu.finanzas.FinanzasApp
import com.orpopu.finanzas.viewmodel.ConfiguracionViewModel
import com.orpopu.finanzas.viewmodel.FinanzasViewModelFactory

@Composable
fun ConfiguracionScreen() {
    val context = LocalContext.current
    val viewModel: ConfiguracionViewModel = viewModel(
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
            text = "Configuración",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Personaliza moneda, notificaciones y privacidad.",
            style = MaterialTheme.typography.bodyLarge
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Notificaciones y alertas", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.width(12.dp))
            Switch(
                checked = uiState.value.notificacionesActivas,
                onCheckedChange = viewModel::toggleNotificaciones
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Modo oscuro", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.width(12.dp))
            Switch(
                checked = uiState.value.modoOscuro,
                onCheckedChange = viewModel::toggleModoOscuro
            )
        }
    }
}
