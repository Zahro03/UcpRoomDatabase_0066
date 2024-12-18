package com.example.ucp2pam.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ucp2pam.data.dao.BarangDao
import com.example.ucp2pam.data.entity.Barang

@Database(entities = [Barang::class], version = 1, exportSchema = false)
abstract class TokoDatabase: RoomDatabase(){

    abstract fun BarangDao():BarangDao
}