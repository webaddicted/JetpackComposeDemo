package com.webaddicted.jetpackcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.webaddicted.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
                Scaffold(topBar = {
                    TopAppBar(title = {
                        Text(text = "Home")
                    },
                        navigationIcon = {
                            IconButton(onClick = {}) {
                                Icon(
                                    Icons.Filled.Home,
                                    contentDescription = "menu",
                                    tint = Color.White
                                )
                            }
                        },
                        actions = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    Icons.Filled.Search,
                                    contentDescription = "search",
                                    tint = Color.White
                                )
                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    Icons.Filled.Info,
                                    contentDescription = "Info",
                                    tint = Color.White
                                )
                            }
                        })
                },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { /*TODO*/ },
                            backgroundColor = Color.Magenta
                        ) {
                            Icon(
                                Icons.Filled.PlayArrow,
                                contentDescription = "play",
                                tint = Color.White
                            )
                        }
                    }) {
                    Greeting(name = "Home Page")
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