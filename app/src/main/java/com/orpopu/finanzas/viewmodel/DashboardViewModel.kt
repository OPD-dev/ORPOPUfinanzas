package com.orpopu.finanzas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orpopu.finanzas.domain.usecase.GetGastosUseCase
import com.orpopu.finanzas.domain.usecase.GetIngresosUseCase
import com.orpopu.finanzas.domain.usecase.GetMetasUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

data class DashboardUiState(
    val ingresosCount: Int = 0,
    val gastosCount: Int = 0,
    val metasCount: Int = 0
)

class DashboardViewModel(
    getIngresosUseCase: GetIngresosUseCase,
    getGastosUseCase: GetGastosUseCase,
    getMetasUseCase: GetMetasUseCase
) : ViewModel() {
    val uiState: StateFlow<DashboardUiState> = combine(
        getIngresosUseCase(),
        getGastosUseCase(),
        getMetasUseCase()
    ) { ingresos, gastos, metas ->
        DashboardUiState(
            ingresosCount = ingresos.size,
            gastosCount = gastos.size,
            metasCount = metas.size
        )
    }.stateIn(viewModelScope, SharingStarted.Lazily, DashboardUiState())
}
