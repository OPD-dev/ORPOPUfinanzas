package com.orpopu.finanzas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.orpopu.finanzas.domain.repository.FinanzasRepository
import com.orpopu.finanzas.domain.usecase.GetGastosUseCase
import com.orpopu.finanzas.domain.usecase.GetIngresosUseCase
import com.orpopu.finanzas.domain.usecase.GetMetasUseCase

class FinanzasViewModelFactory(
    private val repository: FinanzasRepository
) : ViewModelProvider.Factory {
    private val getIngresosUseCase = GetIngresosUseCase(repository)
    private val getGastosUseCase = GetGastosUseCase(repository)
    private val getMetasUseCase = GetMetasUseCase(repository)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DashboardViewModel::class.java) -> {
                DashboardViewModel(getIngresosUseCase, getGastosUseCase, getMetasUseCase) as T
            }
            modelClass.isAssignableFrom(IngresosViewModel::class.java) -> {
                IngresosViewModel(getIngresosUseCase) as T
            }
            modelClass.isAssignableFrom(GastosViewModel::class.java) -> {
                GastosViewModel(getGastosUseCase) as T
            }
            modelClass.isAssignableFrom(MetasViewModel::class.java) -> {
                MetasViewModel(getMetasUseCase) as T
            }
            modelClass.isAssignableFrom(ConfiguracionViewModel::class.java) -> {
                ConfiguracionViewModel() as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
