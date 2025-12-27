package com.orpopu.finanzas.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.orpopu.finanzas.FinanzasApp
import com.orpopu.finanzas.viewmodel.FinanzasViewModelFactory
import com.orpopu.finanzas.viewmodel.MetasViewModel

@Composable
fun MetasScreen(onNavigate: (String) -> Unit) {
    val context = LocalContext.current
    val viewModel: MetasViewModel = viewModel(
        factory = FinanzasViewModelFactory((context.applicationContext as FinanzasApp).repository)
    )
    val uiState = viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Metas",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Define y monitorea tus metas de ahorro e inversión.",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Metas creadas: ${uiState.value.totalMetas}",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
