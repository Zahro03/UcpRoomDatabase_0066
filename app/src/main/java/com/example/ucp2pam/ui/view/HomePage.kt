package com.example.ucp2pam.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp2pam.R

@Preview(showBackground = true)
@Composable
fun Homepage(
    modifier: Modifier = Modifier,
    onItemClick: (String) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
            .background(color = Color.White)
    ) {
        HeaderSection()
        BodySection(onItemClick = onItemClick)
    }
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomEnd = 48.dp))
            .background(color = Color(0xFFBDBDBD))
            .padding(bottom = 32.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 24.dp)
        ) {
            Column {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Home Icon",
                    tint = Color.White,
                    modifier = Modifier.padding(8.dp)
                )
                Spacer(Modifier.padding(3.dp))
                Text(
                    text = "Welcome",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(start = 8.dp)
                )
                Text(
                    text = "to Our Central warehouse",
                    fontSize = 22.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
        Box(
            Modifier.align(Alignment.CenterEnd)
                .padding(24.dp)
                .padding(top = 12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.gudang),
                contentDescription = "Photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
        }
    }
}

@Composable
fun BodySection(
    onItemClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ManageCard(
            title = "Add Supplier",
            description = "",
            backgroundColor = Color(0xFFE0E0E0),
            iconResource = R.drawable.supplier,
            onClick = { onItemClick("Supplier") }
        )

        ManageCard(
            title = "Data Supplier",
            description = "",
            backgroundColor = Color(0xFF87CEEB),
            iconResource = R.drawable.datasupplier,
            onClick = { onItemClick("Supplier") }
        )

        ManageCard(
            title = "Add Barang",
            description = "",
            backgroundColor = Color(0xFFE0E0E0),
            iconResource = R.drawable.barang,
            onClick = { onItemClick("Barang") }
        )

        ManageCard(
            title = "Data Barang",
            description = "",
            backgroundColor = Color(0xFF87CEEB),
            iconResource = R.drawable.databarang,
            onClick = { onItemClick("Barang") }
        )

        Spacer(modifier = Modifier.size(16.dp))
    }
}

@Composable
fun ManageCard(
    title: String,
    description: String,
    backgroundColor: Color,
    iconResource: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Image(
                painter = painterResource(id = iconResource),
                contentDescription = "$title Icon",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
        }
    }
}