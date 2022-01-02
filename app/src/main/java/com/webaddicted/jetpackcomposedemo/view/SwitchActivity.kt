package com.webaddicted.jetpackcomposedemo.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.webaddicted.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

class SwitchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
            }

        }
    }
}
