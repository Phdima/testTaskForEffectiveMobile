package com.example.feature_login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputsForLogin(modifier: Modifier) {
    var textEmail by remember { mutableStateOf("") }
    var textPassword by remember { mutableStateOf("") }

    val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$")

    Column(
        modifier = modifier
    ) {

        Text(text = "Email", fontSize = 16.sp, color = MaterialTheme.colorScheme.onPrimary)

        TextField(
            value = textEmail,
            onValueChange = { newText ->
                textEmail = newText
                },
            placeholder = {
                Text(
                    "example@gmail.com",
                    fontSize = 14.sp,
                    maxLines = 1,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.inversePrimary,
                unfocusedContainerColor = MaterialTheme.colorScheme.inversePrimary,
                focusedTextColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
                focusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary
            ),
            textStyle = LocalTextStyle.current.copy(
                fontSize = 14.sp,
            ),
            singleLine = true,
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .fillMaxWidth()
        )


        Text(text = "Пароль", fontSize = 16.sp, color = MaterialTheme.colorScheme.onPrimary)

        TextField(
            value = textPassword,
            onValueChange = { textPassword = it },
            placeholder = {
                Text(
                    "Введите пароль",
                    fontSize = 14.sp,
                    maxLines = 1,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.inversePrimary,
                unfocusedContainerColor = MaterialTheme.colorScheme.inversePrimary,
                focusedTextColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
                focusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary
            ),
            textStyle = LocalTextStyle.current.copy(
                fontSize = 14.sp,
            ),
            singleLine = true,
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .fillMaxWidth()
        )

    }
}