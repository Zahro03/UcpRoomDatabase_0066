package com.example.ucp2pam.ui.view.Barang

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2pam.ui.viewModel.Barang.HomeBrgViewModel

@Composable
fun HomeBrgView(
    viewModel: HomeBrgViewModel =  viewModel(factory = PenyediaViewModel.Factory),
    onAddBarang: () -> Unit = { },
    onDetailClick: (String) -> Unit = { },
    modifier: Modifier = Modifier
){

}