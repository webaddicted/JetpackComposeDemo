package com.webaddicted.jetpackcomposedemo.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.webaddicted.jetpackcomposedemo.R
import com.webaddicted.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

class SplashActivity : ComponentActivity() {
    companion object {
        val TAG = SplashActivity::class.qualifiedName
        fun newIntent(activity: Activity) {
            activity.startActivity(Intent(activity, SplashActivity::class.java))
        }

        fun newClearIntent(activity: Activity?) {
            val intent = Intent(activity, SplashActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            activity?.startActivity(intent)
            activity?.finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
                SplashScreen()
            }
        }

    }

    @Preview
    @Composable
    private fun SplashScreen() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.run { fillMaxSize() }
        ) {
            IconButton(onClick = { LoginActivity.newIntent(this@SplashActivity) }) {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = "User",
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier.size(120.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = resources.getString(R.string.app_name),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}