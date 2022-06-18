package com.example.store.layout

import android.widget.Toast
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.store.compose.DetailsBottomBar
import com.example.store.compose.DetailsTopBar
import com.example.store.compose.ProductInfo
import com.example.store.viewModels.ProductDetailsViewModel


@Composable
fun ProductDetails(
    navController: NavController,
    viewModel: ProductDetailsViewModel,
    productId: Int
) {

    //context for toast
    val context = LocalContext.current

    //get data
    LaunchedEffect(key1 = "productDetails") {
        viewModel.getProductDetails(productId)
    }

    val productDetails = viewModel.productDetails.value

    productDetails?.let { product ->

        Scaffold(
            topBar = { DetailsTopBar(navController) },
            bottomBar = {
                DetailsBottomBar(product.price.toString()) {
                    //add to cart
                    viewModel.addToCart(productId) {
                        Toast.makeText(context, "Successfully Added To Your Cart", Toast.LENGTH_LONG).show()
                    }
                }
            }
        ) {
            ProductInfo(product = product)
        }
    }
}