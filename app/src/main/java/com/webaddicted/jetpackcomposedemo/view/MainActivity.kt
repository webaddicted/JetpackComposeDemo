package com.webaddicted.jetpackcomposedemo.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.webaddicted.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(navigationIcon = {
                            IconButton(
                                onClick = { /*TODO*/ }) {
                                Icon(
                                    Icons.Filled.Menu,
                                    contentDescription = "Menu",
                                    tint = Color.White
                                )
                            }
                        }, title = { Text(text = "Hello") }, actions = {
                            Row {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        Icons.Filled.Notifications,
                                        contentDescription = "Notification", tint = Color.White
                                    )
                                }
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        Icons.Filled.Info,
                                        contentDescription = "Info",
                                        tint = Color.White
                                    )
                                }
                            }
                        })
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = {
                            val intent = Intent(this, SwitchActivity::class.java)
                            startActivity(intent)
                        }) {
                            Icon(
                                Icons.Filled.Add,
                                contentDescription = "floating",
                                tint = Color.White
                            )
                        }
                    }) {
                    Text(text = "Hello Word")
                }
            }
        }

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeDemoTheme {
        Greeting("Android")
    }
}