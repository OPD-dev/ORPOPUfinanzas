package com.orpopu.finanzas.domain.usecase

import com.orpopu.finanzas.domain.repository.FinanzasRepository

class GetIngresosUseCase(private val repository: FinanzasRepository) {
    operator fun invoke() = repository.ingresos()
}
