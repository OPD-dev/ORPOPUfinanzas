package com.orpopu.finanzas

import android.app.Application
import com.orpopu.finanzas.data.datasource.FinanzasLocalDataSource
import com.orpopu.finanzas.data.local.AppDatabase
import com.orpopu.finanzas.data.repository.FinanzasRepositoryImpl

class FinanzasApp : Application() {
    private val database by lazy { AppDatabase.build(this) }
    private val localDataSource by lazy { FinanzasLocalDataSource(database.finanzasDao()) }
    val repository by lazy { FinanzasRepositoryImpl(localDataSource) }
}
