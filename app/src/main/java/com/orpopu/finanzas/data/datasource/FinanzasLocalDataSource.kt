package com.orpopu.finanzas.data.datasource

import com.orpopu.finanzas.data.local.FinanzasDao
import com.orpopu.finanzas.data.local.GastoEntity
import com.orpopu.finanzas.data.local.IngresoEntity
import com.orpopu.finanzas.data.local.MetaEntity
import kotlinx.coroutines.flow.Flow

class FinanzasLocalDataSource(private val dao: FinanzasDao) {
    fun getIngresos(): Flow<List<IngresoEntity>> = dao.getIngresos()

    fun getGastos(): Flow<List<GastoEntity>> = dao.getGastos()

    fun getMetas(): Flow<List<MetaEntity>> = dao.getMetas()

    suspend fun insertIngreso(entity: IngresoEntity) = dao.insertIngreso(entity)

    suspend fun insertGasto(entity: GastoEntity) = dao.insertGasto(entity)

    suspend fun insertMeta(entity: MetaEntity) = dao.insertMeta(entity)
}
