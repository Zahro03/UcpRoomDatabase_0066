package com.example.ucp2pam.ui.viewModel.Supplier

import Suplier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2pam.repository.RepositorySpl
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import java.util.function.Supplier

class HomeSplViewModel (
    private val repositorySpl: RepositorySpl
) : ViewModel() {

    val homeUiStateSpl: StateFlow<HomeUIStateSpl> = repositorySpl.getAllSuplier()
        .filterNotNull()
        .map {
            HomeUIStateSpl (
                listSpl = it.toList(),
                isLoading = false
            )
        }
        .onStart {
            emit(HomeUIStateSpl(isLoading = true))
            delay(900)
        }
        .catch {
            emit(
                HomeUIStateSpl(
                    isLoading = false,
                    isError = true,
                    errorMessage = it.message?: "Terjadi Kesalahan"
                )
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = HomeUIStateSpl(
                isLoading = true
            )
        )
}

data class HomeUIStateSpl (
    val listSpl : List<Suplier> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)