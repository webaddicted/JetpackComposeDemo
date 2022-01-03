package com.webaddicted.jetpackcomposedemo.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.webaddicted.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

class LoginActivity : ComponentActivity() {
    companion object {
        val TAG = LoginActivity::class.qualifiedName
        fun newIntent(activity: Activity) {
            activity.startActivity(Intent(activity, LoginActivity::class.java))
        }

        fun newClearIntent(activity: Activity?) {
            val intent = Intent(activity, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            activity?.startActivity(intent)
            activity?.finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
                LoginScreen()
            }
        }

    }

    @Preview
    @Composable
    private fun LoginScreen() {
        val userName = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }

        Column(
            modifier = Modifier.run {
                fillMaxSize().padding(
                    top = 80.dp,
                    start = 15.dp,
                    end = 15.dp
                )
            }
        ) {
            Text(
                text = "Login In\nJetpack Compose World",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary,
                fontFamily = FontFamily.Monospace
            )
            OutlinedTextField(
                value = userName.value,
                onValueChange = {
                    userName.value = it
                },
                modifier = Modifier.run { fillMaxWidth() },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = "",
                        tint = MaterialTheme.colors.primary
                    )
                },
                label = { Text(text = "UserName") },
                placeholder = { Text(text = "UserName") },
                singleLine = true
            )
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Lock,
                        contentDescription = "Lock",
                        tint = MaterialTheme.colors.primary
                    )
                },
                modifier = Modifier.run { fillMaxWidth() },
                label = { Text(text = "Password") },
                placeholder = { Text(text = "Password") },
                trailingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Eye") },
                singleLine = true

            )
            OutlinedButton(
                onClick = { loginBtn(userName.value, password.value) },
                modifier = Modifier.run { fillMaxWidth().padding(top = 10.dp) }) {
                Text(text = "Login")

            }
        }
    }

    private fun loginBtn(userName: String, password: String) {
        if (userName.equals("webaddicted") && password.equals("123")) {
            HomeActivity.newClearIntent(this)
        } else {
            Toast.makeText(
                this,
                "Enter webaddicted as username and 123 as password",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}