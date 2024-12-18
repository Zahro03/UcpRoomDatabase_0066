package com.example.ucp2pam.data.database

import androidx.room.Database
import com.example.ucp2pam.data.dao.SuplierDao
import com.example.ucp2pam.data.entity.Suplier

@Database(entities = [Suplier::class], version = 1, exportSchema = false)
abstract class SplDatabase(){

    abstract fun SuplierDao():SuplierDao
}