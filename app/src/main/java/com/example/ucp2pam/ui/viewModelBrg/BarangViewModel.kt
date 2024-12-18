package com.example.ucp2pam.ui.viewModelBrg

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2pam.data.entity.Barang
import com.example.ucp2pam.data.repository.RepositoryBrg
import kotlinx.coroutines.launch

class BarangViewModel(private val repositoryBarang: RepositoryBrg) : ViewModel() {
    var uiState by mutableStateOf(BarangUIState())

    // Memperbarui state berdasarkan input pengguna
  fun updateState(barangEvent: BarangEvent){
      uiState = uiState.copy(
          barangEvent = barangEvent
      )
  }
    // Validasi data input pengguna
    private fun validateFields(): Boolean{
        val event = uiState.barangEvent
        val errorState = FormErrorState(
            nama = if (event.nama.isNotEmpty()) null else "Nama tidak boleh kosong",
            deskripsi = if (event.deskripsi.isNotEmpty()) null else "Deskripsi tidak boleh kosong",
            harga = if (event.harga > 0) null else "Stok tidak boleh negatif",
            stok = if (event.stok >= 0) null else "Stok tidak boleh kosong",
            namaSuplier = if (event.namaSuplier.isNotEmpty()) null else "Nama Suplier tidak boleh kosong"
        )
    }

    // Menyimpan data ke repository
    fun saveData() {
        val currentEvent = uiState.barangEvent

        if (validateFields()) {
            viewModelScope.launch {
                try {
                    repositoryBarang.insertBarang(currentEvent.toBarangEntity())
                    uiState = uiState.copy(
                        snackBarMessage = "Data berhasil disimpan",
                        barangEvent = BarangEvent(), // Reset input Form
                        isEntryValid = FormErrorState() // Reset error state
                    )
                } catch (e: Exception) {
                    uiState = uiState.copy(
                        snackBarMessage = "Data Gagal Disimpan"
                    )
                }
            }
        } else {
            uiState = uiState.copy(
                snackBarMessage = "Input tidak valid. Periksa kembali data anda."
            )
        }
    }

    fun resetSnackBarMessage() {
        uiState = uiState.copy(snackBarMessage = null)
    }
}

// Menyimpan input form ke dalam entity
fun BarangEvent.toBarangEntity(): Barang = Barang(
    id = id,
    nama = nama,
    deskripsi = deskripsi,
    harga = harga,
    stok = stok,
    namaSuplier = namaSuplier
)

data class BarangEvent(
    val id: Int = 0,
    val nama: String = "",
    val deskripsi: String = "",
    val harga: Double = 0.0,
    val stok: Int = 0,
    val namaSuplier: String = "",
)

// Bedanya event dan state
// Event adalah aksi yang merubah kondisi
// dan state merupakan keadaan yang terjadi setelah ada trigger dari event
data class BarangUIState(
    val barangEvent: BarangEvent = BarangEvent(),
    val isEntryValid: FormErrorState = FormErrorState(),
    val snackBarMessage: String? = null
)

data class FormErrorState(
    val nama: String? = null,
    val deskripsi: String? = null,
    val harga: String? = null,
    val stok: String? = null,
    val namaSuplier: String? = null,
) {
    fun isValid(): Boolean {
        return nama == null && deskripsi == null && harga == null &&
                stok == null && namaSuplier == null
    }
}