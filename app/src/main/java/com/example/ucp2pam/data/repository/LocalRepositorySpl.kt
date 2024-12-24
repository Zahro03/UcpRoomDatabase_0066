package com.example.ucp2pam.repository

import Suplier
import com.example.ucp2pam.data.dao.SuplierDao
import kotlinx.coroutines.flow.Flow

class LocalRepositorySpl (
    private val suplierDao: SuplierDao
) : RepositorySpl {
    override suspend fun insertSpl(suplier: Suplier) {
        suplierDao.insertSpl(suplier)
    }

    override fun getAllSuplier(): Flow<List<Suplier>> {
       return suplierDao.getAllSuplier()
    }

    override fun getSpl(id: String): Flow<List<String>> {
        return suplierDao.getSpl(id)
    }
}