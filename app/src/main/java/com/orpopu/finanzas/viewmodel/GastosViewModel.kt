package com.orpopu.finanzas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orpopu.finanzas.domain.usecase.GetGastosUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class GastosUiState(
    val totalGastos: Int = 0
)

class GastosViewModel(getGastosUseCase: GetGastosUseCase) : ViewModel() {
    val uiState: StateFlow<GastosUiState> = getGastosUseCase()
        .map { gastos -> GastosUiState(totalGastos = gastos.size) }
        .stateIn(viewModelScope, SharingStarted.Lazily, GastosUiState())
}
