package com.example.ucp2pam.repository

import Suplier
import kotlinx.coroutines.flow.Flow

interface RepositorySpl {
    suspend fun insertSpl(suplier: Suplier)

    fun getAllSuplier(): Flow<List<Suplier>>

    fun getSpl(id: String) : Flow<List<String>>

}