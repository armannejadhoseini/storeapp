package com.example.store

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.LoginModel
import com.example.domain.usecaes.LoginStatusUsecaseImpl
import com.example.domain.usecaes.LoginUsecaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(
    val loginUsecaseImpl: LoginUsecaseImpl,
    val getStatusUsecaseImpl: LoginStatusUsecaseImpl
) : ViewModel() {

    private var _loginData = MutableLiveData<LoginModel>()
    val loginData get() = _loginData

    private var _loginStatus = MutableLiveData<Boolean>()
    val loginStatus get() = _loginStatus

    init {
        getLoginStatus()
    }

    fun getLoginStatus() {
        viewModelScope.launch(Dispatchers.IO) {
            loginStatus.postValue(getStatusUsecaseImpl.getSatus())
        }
    }

    fun login() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = loginUsecaseImpl.login(loginData.value!!)
            Log.d("TAG", "login: ${result.Status}")
        }
    }


}