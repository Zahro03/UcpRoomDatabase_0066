package com.example.ucp2pam.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import brgUIState

@Entity(tableName = "tblBarang")
data class Barang(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val namaBarang: String,
    val deskripsi: String,
    val harga: Int,
    val stok: Int,
    val namaSuplier: String
)