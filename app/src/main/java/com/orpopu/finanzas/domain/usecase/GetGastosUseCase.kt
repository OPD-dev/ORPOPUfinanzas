package com.orpopu.finanzas.domain.usecase

import com.orpopu.finanzas.domain.repository.FinanzasRepository

class GetGastosUseCase(private val repository: FinanzasRepository) {
    operator fun invoke() = repository.gastos()
}
