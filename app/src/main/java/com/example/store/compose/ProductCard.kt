package com.example.store.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.store.R
import com.example.store.ui.theme.Primary500
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ProductCard(
    image: String,
    title: String,
    onClick: () -> Unit,
    onSave: () -> Unit
) {

    Card(
        modifier = Modifier
            .clickable {
                onClick()
            },
        elevation = 0.dp,
        shape = RoundedCornerShape(30.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GlideImage(
                modifier = Modifier
                    .width(160.dp)
                    .height(160.dp)
                    .padding(10.dp),
                imageModel = image,
                contentScale = ContentScale.Crop,
                placeHolder = painterResource(id = R.drawable.ic_baseline_autorenew_24)
            )
            Text(
                modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
                text = title,
                maxLines = 1,
                color = Color.DarkGray,
                fontSize = 16.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
                        .size(24.dp)
                        .clickable {
                            onSave()
                        },
                    painter = painterResource(id = R.drawable.ic_baseline_bookmark_border_24),
                    contentDescription = "",
                    tint = Primary500
                )
            }
        }
    }
}