package com.orpopu.finanzas.domain.repository

import com.orpopu.finanzas.data.local.GastoEntity
import com.orpopu.finanzas.data.local.IngresoEntity
import com.orpopu.finanzas.data.local.MetaEntity
import kotlinx.coroutines.flow.Flow

interface FinanzasRepository {
    fun ingresos(): Flow<List<IngresoEntity>>
    fun gastos(): Flow<List<GastoEntity>>
    fun metas(): Flow<List<MetaEntity>>

    suspend fun addIngreso(entity: IngresoEntity)
    suspend fun addGasto(entity: GastoEntity)
    suspend fun addMeta(entity: MetaEntity)
}
