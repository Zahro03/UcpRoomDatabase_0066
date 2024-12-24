package com.example.ucp2pam.data.dao

import androidx.room.*
import com.example.ucp2pam.data.model.Barang
import kotlinx.coroutines.flow.Flow

@Dao
interface BarangDao {
    @Insert
    suspend fun insertBarang(barang: Barang)

    @Update
    suspend fun updateBarang(barang: Barang)

    @Delete
    suspend fun deleteBarang(barang: Barang)

    @Query("SELECT * FROM tblBarang ORDER BY namaBarang")
    fun getAllBarang(): Flow<List<Barang>>

    @Query("SELECT * FROM tblBarang WHERE id = :id")
    fun getBarang(id: String): Flow<Barang>
}
