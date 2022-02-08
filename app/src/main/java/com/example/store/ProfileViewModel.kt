package com.example.store

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.LoginModel
import com.example.domain.usecaes.LoginUsecaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(
    val loginUsecaseImpl: LoginUsecaseImpl
): ViewModel() {

    private var _loginData = MutableLiveData<LoginModel>()
    val loginData get() = _loginData

    fun login() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = loginUsecaseImpl.login(loginData.value!!)
        }
    }




}