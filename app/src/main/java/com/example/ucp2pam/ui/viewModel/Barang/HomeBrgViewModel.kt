
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2pam.data.model.Barang
import com.example.ucp2pam.repository.RepositoryBrg
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.toList

class HomeBrgViewModel(
    private val repositoryBrg: RepositoryBrg
): ViewModel(){
    val homeBrgUiState: StateFlow<HomeBrgUiState> = flow {
        emit(repositoryBrg.getAllBrg())
    }
        .filterNotNull()
        .map {
            HomeBrgUiState(
                listBrg = it.toList(),
                isLoading = false,
            )
        }
        .onStart {
            emit(HomeBrgUiState(isLoading = true))
            delay(900)
        }
        .catch {
            emit(
                HomeBrgUiState (
                    isLoading = false,
                    isError = true,
                    errorMessage = it.message ?: "Terjadi kesalahan"
                )
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = HomeBrgUiState(
                isLoading = true,
            )
        )

}


data class HomeBrgUiState(
    val listBrg: List<List<Barang>> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)