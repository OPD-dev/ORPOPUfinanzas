package com.orpopu.finanzas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orpopu.finanzas.domain.usecase.GetIngresosUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class IngresosUiState(
    val totalIngresos: Int = 0
)

class IngresosViewModel(getIngresosUseCase: GetIngresosUseCase) : ViewModel() {
    val uiState: StateFlow<IngresosUiState> = getIngresosUseCase()
        .map { ingresos -> IngresosUiState(totalIngresos = ingresos.size) }
        .stateIn(viewModelScope, SharingStarted.Lazily, IngresosUiState())
}
