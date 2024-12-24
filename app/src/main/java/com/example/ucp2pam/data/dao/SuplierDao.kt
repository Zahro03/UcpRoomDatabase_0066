package com.example.ucp2pam.data.dao

import Suplier
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface SuplierDao {

    @Insert
    suspend fun insertSpl(supplier: Suplier)

    @Query("SELECT * FROM tblSupplier ORDER BY nama")
    fun getAllSuplier(): Flow<List<Suplier>>

    @Query("SELECT nama FROM tblSupplier")
    fun getSpl(id: String): Flow<List<String>>

}