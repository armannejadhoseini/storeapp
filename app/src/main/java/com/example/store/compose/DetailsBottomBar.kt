package com.example.store.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.store.R
import com.example.store.ui.theme.Primary500
import com.example.store.ui.theme.Secondary

@Composable
fun DetailsBottomBar(price: String, addToCart: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        backgroundColor = Color.White,
        elevation = 20.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(0.7F),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = "$$price",
                    maxLines = 1,
                    color = Secondary,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = stringResource(id = R.string.price),
                    maxLines = 1,
                    color = Color.Gray,
                    fontSize = 16.sp
                )
            }
            Button(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(10.dp),
                onClick = { addToCart() },
                colors = ButtonDefaults.buttonColors(Primary500)
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = stringResource(id = R.string.add),
                    maxLines = 1,
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
    }
}