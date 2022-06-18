package com.example.store.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.models.ProductModel
import com.example.store.R
import com.example.store.ui.theme.HomeBackground
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ProductInfo(product: ProductModel) {

    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())) {

        GlideImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.0F)
                .padding(horizontal = 50.dp, vertical = 10.dp),
            imageModel = product.image,
            contentScale = ContentScale.Crop,
            placeHolder = painterResource(id = R.drawable.ic_baseline_autorenew_24)
        )

        Card(
            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
            backgroundColor = HomeBackground,
        ) {
            Column {

                Text(
                    modifier = Modifier.padding(
                        top = 20.dp,
                        start = 20.dp,
                        end = 20.dp,
                        bottom = 4.dp
                    ),
                    text = stringResource(id = R.string.category),
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    text = product.category,
                    maxLines = 1,
                    color = Color.Gray,
                    fontSize = 16.sp
                )
                Text(
                    modifier = Modifier.padding(
                        top = 20.dp,
                        start = 20.dp,
                        end = 20.dp,
                        bottom = 4.dp
                    ),
                    text = stringResource(id = R.string.description),
                    maxLines = 1,
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                    text = product.description,
                    color = Color.Gray,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}