package com.example.store.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ProductModel
import com.example.domain.usecaes.AddToCartUseCaseImpl
import com.example.domain.usecaes.GetProductDetailsUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val getProductDetails: GetProductDetailsUseCaseImpl,
    private val addToCart: AddToCartUseCaseImpl
) : ViewModel() {

    private var _productDetails = mutableStateOf<ProductModel?>(null)
    val productDetails get() = _productDetails

    fun getProductDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _productDetails.value = getProductDetails.execute(id)
            } catch (e: Exception) {
                Log.d("TAG", "getProductDetails: ${e.message}")
            }
        }
    }

    fun addToCart(id: Int, onAdd: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = addToCart.execute(id)

                //switch to main thread to make a toast
                if (result) {
                    withContext(Dispatchers.Main) {
                        onAdd()
                    }
                }
            } catch (e: Exception) {
                Log.d("TAG", "addToCart: ${e.message}")
            }
        }
    }
}