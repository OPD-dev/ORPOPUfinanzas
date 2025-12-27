package com.orpopu.finanzas.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FinanzasDao {
    @Query("SELECT * FROM ingresos ORDER BY fecha DESC")
    fun getIngresos(): Flow<List<IngresoEntity>>

    @Query("SELECT * FROM gastos ORDER BY fecha DESC")
    fun getGastos(): Flow<List<GastoEntity>>

    @Query("SELECT * FROM metas ORDER BY id DESC")
    fun getMetas(): Flow<List<MetaEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIngreso(entity: IngresoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGasto(entity: GastoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeta(entity: MetaEntity)
}
