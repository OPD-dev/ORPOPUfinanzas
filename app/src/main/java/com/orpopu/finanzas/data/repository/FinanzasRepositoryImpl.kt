package com.orpopu.finanzas.data.repository

import com.orpopu.finanzas.data.datasource.FinanzasLocalDataSource
import com.orpopu.finanzas.data.local.GastoEntity
import com.orpopu.finanzas.data.local.IngresoEntity
import com.orpopu.finanzas.data.local.MetaEntity
import com.orpopu.finanzas.domain.repository.FinanzasRepository
import kotlinx.coroutines.flow.Flow

class FinanzasRepositoryImpl(
    private val localDataSource: FinanzasLocalDataSource
) : FinanzasRepository {
    override fun ingresos(): Flow<List<IngresoEntity>> = localDataSource.getIngresos()

    override fun gastos(): Flow<List<GastoEntity>> = localDataSource.getGastos()

    override fun metas(): Flow<List<MetaEntity>> = localDataSource.getMetas()

    override suspend fun addIngreso(entity: IngresoEntity) = localDataSource.insertIngreso(entity)

    override suspend fun addGasto(entity: GastoEntity) = localDataSource.insertGasto(entity)

    override suspend fun addMeta(entity: MetaEntity) = localDataSource.insertMeta(entity)
}
