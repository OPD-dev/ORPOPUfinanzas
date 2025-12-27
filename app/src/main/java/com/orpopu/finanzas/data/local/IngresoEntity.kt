package com.orpopu.finanzas.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingresos")
data class IngresoEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val descripcion: String,
    val monto: Double,
    val fecha: String
)
