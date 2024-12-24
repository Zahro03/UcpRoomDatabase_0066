package com.example.ucp2pam.data.repository
import com.example.ucp2pam.data.dao.BarangDao
import com.example.ucp2pam.data.model.Barang
import kotlinx.coroutines.flow.Flow

class LocalRepositoryBrg(private val repository: BarangDao) {

    suspend fun insertBarang(barang: Barang) {
        repository.insertBarang(barang)
    }

    suspend fun getAllBrg(): Flow<List<Barang>> {
        return repository.getAllBarang()
    }

    // Ubah tipe data _idBarang menjadi Int
    suspend fun getBrg(_idBarang: String): Flow<Barang> {
        return repository.getBarang(_idBarang)
    }

    suspend fun deleteBarang(barang: Barang) {
        repository.deleteBarang(barang)
    }

    suspend fun updateBarang(barang: Barang) {
        repository.updateBarang(barang)
    }
}
