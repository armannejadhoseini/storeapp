package com.example.store.layout.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.store.viewModels.ProfileViewModel
import com.example.store.compose.textField
import com.example.store.ui.theme.Primary500

@Composable
fun Login(navController: NavController, viewModel: ProfileViewModel) {

    //navigate depending on login status
    viewModel.loginStatus.observe(LocalLifecycleOwner.current) {
        if (it == true) {
            //show account information page
            navController.navigate("account")
        }
    }


    //login page
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.fillMaxSize()) {

        textField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .height(60.dp),
            text = email,
            onTextChanged = { email = it },
            label = "Email"
        )

        textField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .height(60.dp),
            text = password,
            onTextChanged = { password = it },
            label = "Password"
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 20.dp)
                .height(50.dp),
            onClick = {
                viewModel.login(email, password)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Primary500,
            )
        ) {
            Text(
                modifier = Modifier
                    .background(Primary500),
                text = "Login",
                color = Color.White
            )
        }
    }

}