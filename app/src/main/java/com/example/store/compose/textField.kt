package com.example.store.compose


import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.store.ui.theme.Secondary

@Composable
fun textField(modifier: Modifier, text: String, onTextChanged: (String) -> Unit, label: String) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = onTextChanged,
        label = {
            Text(text = label)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Secondary,
        )
    )
}