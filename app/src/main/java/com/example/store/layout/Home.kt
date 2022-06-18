package com.example.store.layout

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.store.R
import com.example.store.compose.HomeTopBar
import com.example.store.compose.PriceTag
import com.example.store.compose.ProductCard
import com.example.store.ui.theme.HomeBackground
import com.example.store.viewModels.HomeViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Home(navController: NavController, viewModel: HomeViewModel) {

    //get the products list
    val lastProducts = viewModel.lastProducts.value

    Scaffold(topBar = { HomeTopBar() }) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(HomeBackground)
        ) {

            LazyVerticalGrid(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp),
                cells = GridCells.Adaptive(160.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(top = 10.dp, bottom = 10.dp)
            ) {
                items(lastProducts) { product ->
                    Box() {
                        ProductCard(
                            image = product.image,
                            title = product.title,
                            {
                                navController.navigate("product_details/${product.id}")
                            },
                            {
                                //save
                            }
                        )
                        PriceTag(Modifier.align(Alignment.TopEnd), product.price.toString())
                    }
                }
            }

        }
    }
}