package com.example.ucp2pam.data

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2pam.ui.viewModel.Supplier.HomeSplViewModel
import com.example.ucp2pam.view.viewmodel.PenyediaViewModel

object NamaSuplier {
    @Composable
    fun options(
        supplierHomeViewModel: HomeSplViewModel = viewModel(factory = PenyediaViewModel.Factory)
    ): List<String> {
        val dataNama by supplierHomeViewModel.homeUiStateSpl.collectAsState()
        val namaSupplier = dataNama.listSpl.map { it.nama }
        return namaSupplier
    }
}