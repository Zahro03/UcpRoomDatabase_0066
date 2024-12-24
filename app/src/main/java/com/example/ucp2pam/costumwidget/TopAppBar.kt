package com.example.ucp2pam.costumwidget

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ucp2pam.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    actionIcon: Int,
    onActionClick: () -> Unit = {},
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() } // Menambahkan parameter interactionSource
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    CenterAlignedTopAppBar(
        modifier = modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = colorResource(R.color.primary),
            titleContentColor = Color.White
        ),
        title = {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                modifier = Modifier // Tentukan modifier dengan benar
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onBackClick,
                interactionSource = interactionSource // Menentukan nilai interactionSource secara eksplisit
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Navigate Back",
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(
                onClick = onActionClick,
                interactionSource = interactionSource  // Jika diperlukan
            ) {
                Icon(
                    painter = painterResource(id = actionIcon),
                    contentDescription = "Action Icon",
                    tint = Color.White  // Sesuaikan dengan warna yang diinginkan
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@SuppressLint("UnrememberedMutableInteractionSource")
@Preview(showBackground = true)
@Composable
fun PreviewTopAppBar() {
    // Menggunakan interactionSource yang didefinisikan
    TopAppBar(
        title = "Manage Barang",
        onBackClick = { /* Aksi kembali */ },
        actionIcon = R.drawable.ic_box, // Sesuaikan nama file
        onActionClick = { /* Aksi saat ikon ditekan */ },
    )
}
