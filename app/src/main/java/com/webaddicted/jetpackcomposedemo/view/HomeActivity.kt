package com.webaddicted.jetpackcomposedemo.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.webaddicted.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

class HomeActivity : ComponentActivity() {
    companion object {
        val TAG = HomeActivity::class.qualifiedName
        fun newIntent(activity: Activity) {
            activity.startActivity(Intent(activity, HomeActivity::class.java))
        }

        fun newClearIntent(activity: Activity?) {
            val intent = Intent(activity, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            activity?.startActivity(intent)
            activity?.finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
                HomeScreen()
            }
        }
    }

    @Preview
    @Composable
    private fun HomeScreen() {
        Scaffold(topBar = {
            TopAppBar(title = { Text(text = "Home") }, navigationIcon = {
                IconButton(
                    onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Menu,
                        contentDescription = "Menu",
                        tint = Color.White
                    )
                }
            },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            Icons.Filled.Notifications,
                            contentDescription = "Notification",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Call, contentDescription = "Call", tint = Color.White)
                    }
                })
        },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    backgroundColor = MaterialTheme.colors.primary
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Add", tint = Color.White)
                }
            }) {
            ShowList()
        }
    }

    @Composable
    private fun ShowList() {
        LazyColumn() {


        }
    }
    @Composable
    private fun ShowCard() {
        Card() {


        }
    }

}
