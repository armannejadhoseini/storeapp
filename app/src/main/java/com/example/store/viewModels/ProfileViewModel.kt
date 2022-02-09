package com.example.store.viewModels

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

    private var _loginStatus = MutableLiveData<Boolean>()
    val loginStatus get() = _loginStatus

    init {
        getLoginStatus()
    }

    fun getLoginStatus() {
        viewModelScope.launch(Dispatchers.IO) {
            _loginStatus.postValue(getStatusUsecaseImpl.getSatus().value)
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = loginUsecaseImpl.login(
                    LoginModel(
                        email,
                        password
                    )
                )
                Log.d("TAG", "login: ${result.Status}")
            } catch (e: Exception) {
                Log.d("TAG", "login: $e")
            }
        }
    }


}