package com.example.store.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.store.ui.theme.Secondary
import com.example.store.ui.theme.SecondaryLight

@Composable
fun PriceTag(modifier: Modifier, price: String) {
        Card(
            modifier = modifier,
            shape = RoundedCornerShape(topEnd = 30.dp, bottomStart = 30.dp),
            backgroundColor = SecondaryLight,
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                    text = "$$price",
                    color = Secondary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
}