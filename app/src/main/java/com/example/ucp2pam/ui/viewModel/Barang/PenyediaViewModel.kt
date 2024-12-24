package com.example.ucp2pam.view.viewmodel

import BarangViewModel
import HomeBrgViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ucp2pam.GudangApp
import com.example.ucp2pam.ui.viewModel.Barang.UpdateBrgViewModel
import com.example.ucp2pam.ui.viewModel.Supplier.HomeSplViewModel
import com.example.ucp2pam.ui.viewModel.Supplier.SuplierViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            SuplierViewModel(
                GudangApp().containerApp.repositorySpl
            )
        }
        initializer {
            HomeSplViewModel(
                GudangApp().containerApp.repositorySpl
            )
        }
        initializer {
            BarangViewModel(
                GudangApp().containerApp.repositoryBrg,
            )
        }
        initializer {
            HomeBrgViewModel(
                GudangApp().containerApp.repositoryBrg
            )
        }
        initializer {
            DetailBarangViewModel(
                createSavedStateHandle(),
                GudangApp().containerApp.repositoryBrg
            )
        }
        initializer {
            UpdateBrgViewModel(
                createSavedStateHandle(),
                GudangApp().containerApp.repositoryBrg,
            )
        }
    }
}

fun CreationExtras.GudangApp() : GudangApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as GudangApp)