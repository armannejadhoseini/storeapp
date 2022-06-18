package com.example.store.viewModels

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.CategoryModel
import com.example.domain.models.ProductsModel
import com.example.domain.usecaes.AddToCartUseCaseImpl
import com.example.domain.usecaes.GetAllCategoriesUseCaseImpl
import com.example.domain.usecaes.GetAllProducsUseCase
import com.example.domain.usecaes.GetAllProductsUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllProducts: GetAllProductsUseCaseImpl,
    private val getAllCategories: GetAllCategoriesUseCaseImpl
) : ViewModel() {

    private var _lastProducts = mutableStateOf<List<ProductsModel>>(emptyList())
    val lastProducts get() = _lastProducts

    private var _categories = mutableStateOf<List<CategoryModel>>(emptyList())
    val categories get() = _categories

    init {
        getAllCategories()
        getLastProducts()
    }

    private fun getAllCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                categories.value = getAllCategories.execute()
            } catch (e: Exception) {
                Log.d("TAG", "getAllCategories: ${e.message}")
            }
        }
    }

    private fun getLastProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _lastProducts.value = getAllProducts.execute()
            } catch (e: Exception) {
                Log.d("TAG", "getLastProducts: ${e.message}")
            }
        }
    }
}