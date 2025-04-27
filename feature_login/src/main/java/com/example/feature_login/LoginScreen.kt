package com.example.feature_login

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core_navigation.Navigator
import com.example.core_ui.components.GreenNavButton

@Composable
fun LoginScreen(navigator: Navigator) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
    ) {
        Text(
            "Вход",
            fontSize = 28.sp,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(top = 140.dp, start = 16.dp, end = 16.dp)
        )
        InputsForLogin(modifier = Modifier.padding(top = 204.dp, start = 16.dp, end = 16.dp))
        GreenNavButton(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 376.dp)
                .fillMaxWidth(),
            navigator = navigator,
            destination = "main",
            text = "Вход"
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 432.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Нету аккаунта? ",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 12.sp
                )
                Text(
                    text = "Регистрация",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .clickable { }
                        .padding(4.dp)
                )
            }
            Text(
                text = "Забыл пароль",
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 12.sp,
                modifier = Modifier
                    .clickable { }
                    .padding(4.dp)
            )
        }
        Box(
            modifier = Modifier
                .padding(top = 502.dp)
                .fillMaxWidth(),
        ) {
            Box(
                modifier = Modifier
                    .width(328.dp)
                    .height(1.dp)
                    .background(MaterialTheme.colorScheme.onTertiary)
                    .align(Alignment.Center)
            )
        }
        Box(
            modifier = Modifier
                .padding(top = 534.dp)
                .fillMaxWidth(),
        )
        {
            Row(
                modifier = Modifier
                    .align(Alignment.Center)
                    .width(328.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {    val url = "https://vk.com"
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        context.startActivity(intent) },
                    modifier = Modifier
                        .width(156.dp)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        disabledContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    )
                ) {
                    Icon(
                        painter = painterResource(com.example.core_ui.R.mipmap.ic_launcher_foreground),
                        contentDescription = "VK",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .size(48.dp)
                            .align(alignment = Alignment.CenterVertically),
                    )
                }

                Button(
                    onClick = {
                        val url = "https://ok.ru"
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        context.startActivity(intent)
                    },
                    modifier = Modifier
                        .width(156.dp)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                    )
                ) {
                    Icon(
                        painter = painterResource(com.example.core_ui.R.mipmap.ic_ok_foreground),
                        contentDescription = "OK",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .size(48.dp)
                            .align(alignment = Alignment.CenterVertically),
                    )
                }
            }
        }
    }
}

private fun openUrl(context: Context, url: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(
            context,
            "Не удалось открыть браузер",
            Toast.LENGTH_SHORT
        ).show()
    }
}