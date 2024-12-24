package com.example.ucp2pam.view.viewmodel

import BarangEvent
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2.ui.navigation.DestinasiDetailBrg
import com.example.ucp2pam.data.model.Barang
import com.example.ucp2pam.data.repository.LocalRepositoryBrg
import com.example.ucp2pam.repository.RepositoryBrg
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import toBarangEntity

class DetailBarangViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryBrg: RepositoryBrg,
) : ViewModel() {
    private val _id : String = checkNotNull(savedStateHandle[DestinasiDetailBrg.idBarang])

    val detailBrgUiState: StateFlow<DetailBrgUiState> = repositoryBrg.getBrg(_id.toInt())
        .filterNotNull()
        .map {
            DetailBrgUiState(
                detailUiBrgEvent = it.toDetailBrglUiEvent(),
                isLoading = false,
            )
        }
        .onStart {
            emit(DetailBrgUiState(isLoading = true))
            delay(600)
        }
        .catch {
            emit(DetailBrgUiState(
                isLoading = false,
                isError = true,

                ))
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(2000),
            initialValue = DetailBrgUiState(
                isLoading = true
            )
        )

    fun deleteBrg(){
        detailBrgUiState.value.detailUiBrgEvent.toBarangEntity().let {
            viewModelScope.launch {
                repositoryBrg.deleteBrg(it)
            }
        }
    }
}

data class DetailBrgUiState(
    val detailUiBrgEvent: BarangEvent = BarangEvent(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorBrgMessage: String = ""
) {
    val isUiBarangEmpty: Boolean
        get() = detailUiBrgEvent == BarangEvent()

    val isUiBarangEventNotEmpty:Boolean
        get() = detailUiBrgEvent != BarangEvent()
}
