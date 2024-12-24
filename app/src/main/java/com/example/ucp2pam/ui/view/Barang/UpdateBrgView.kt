import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2pam.R
import com.example.ucp2pam.costumwidget.TopAppBar
import com.example.ucp2pam.ui.viewModel.Barang.UpdateBrgViewModel
import com.example.ucp2pam.view.viewmodel.PenyediaViewModel

@Composable
fun UpdateBarangView(
    onBackArrow: () -> Unit,
    onNavigate : () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: UpdateBrgViewModel = viewModel(factory = PenyediaViewModel.Factory),

    ) {
    val uiState = viewModel.updateBrgUiState
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(uiState.snackBarMessage) {
        uiState.snackBarMessage?.let { message ->
            snackbarHostState.showSnackbar(
                message = message,
                duration = SnackbarDuration.Long
            )
            viewModel.resetSnackBarMessage()
        }
    }

    Scaffold(
        modifier = modifier,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            TopAppBar(
                title = "Edit Data Barang",
                onBackClick = onBackArrow,
                actionIcon = R.drawable.box,
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            InsertBodyBrg(
                uiState = uiState,
                onValueChange = { updateEvent ->
                    viewModel.UpdateStateBrg(updateEvent)
                },
                onClick = {
                    viewModel.updateDataBrg()
                    onNavigate()
                }
            )
        }
    }
}

