package com.orpopu.finanzas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orpopu.finanzas.domain.usecase.GetMetasUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class MetasUiState(
    val totalMetas: Int = 0
)

class MetasViewModel(getMetasUseCase: GetMetasUseCase) : ViewModel() {
    val uiState: StateFlow<MetasUiState> = getMetasUseCase()
        .map { metas -> MetasUiState(totalMetas = metas.size) }
        .stateIn(viewModelScope, SharingStarted.Lazily, MetasUiState())
}
