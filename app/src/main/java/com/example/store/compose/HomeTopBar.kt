package com.example.store.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.store.R

@Composable
fun HomeTopBar() {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.White,
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(24.dp)
                    .clickable {

                    },
                painter = painterResource(id = R.drawable.ic_baseline_dehaze_24),
                contentDescription = "",
                tint = Color.Gray
            )
        }
    }
}