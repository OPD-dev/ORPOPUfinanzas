package com.orpopu.finanzas.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class ConfiguracionUiState(
    val notificacionesActivas: Boolean = true,
    val modoOscuro: Boolean = false
)

class ConfiguracionViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ConfiguracionUiState())
    val uiState: StateFlow<ConfiguracionUiState> = _uiState

    fun toggleNotificaciones(activo: Boolean) {
        _uiState.value = _uiState.value.copy(notificacionesActivas = activo)
    }

    fun toggleModoOscuro(activo: Boolean) {
        _uiState.value = _uiState.value.copy(modoOscuro = activo)
    }
}
