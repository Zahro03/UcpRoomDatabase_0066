@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.ucp2pam.ui.view.Barang

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2pam.ui.viewModel.Barang.HomeBrgViewModel
import com.example.ucp2pam.ui.viewModel.Barang.HomeUiState

@Composable
fun HomeBrgView(
    viewModel: HomeBrgViewModel =  viewModel(factory = PenyediaViewModel.Factory),
    onAddBarang: () -> Unit = { },
    onDetailClick: (String) -> Unit = { },
    modifier: Modifier = Modifier
){
    Scaffold(
        topBar = {
            TopAppBar(
                onBack = {},
                showBackButton = false,
                judul = "Daftar Barang",
                modifier = modifier
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddBarang,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Tambah Barang",
                )
            }
        }
    ) { innerPadding ->
        val homeUiState by viewModel.homeUiState.collectAsState()

        BodyHomeBrgView(
            homeUiState = homeUiState,
            onClick = {
                onDetailClick(it)
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun BodyHomeBrgView(
    homeUiState: HomeUiState,
    onClick: (String) -> Unit = {},
    modifier: Modifier = Modifier
){
    val coroutineScope = rememberCoroutineScope()
}
