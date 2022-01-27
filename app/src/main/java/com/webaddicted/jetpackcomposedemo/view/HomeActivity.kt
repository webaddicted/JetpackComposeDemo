package com.webaddicted.jetpackcomposedemo.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.webaddicted.jetpackcomposedemo.R
import com.webaddicted.jetpackcomposedemo.data.CategoryBean
import com.webaddicted.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme
import com.webaddicted.jetpackcomposedemo.utils.DummyData
import com.webaddicted.jetpackcomposedemo.utils.constant.ApiConstant

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
            ShowList(DummyData.getData())
        }
    }

    @Composable
    private fun ShowList(data: Array<CategoryBean>) {
        LazyColumn {
            items(count = data.size, itemContent = { index ->
                ShowCard(data[index])
            })
        }
    }

    @Composable
    private fun ShowCard(item: CategoryBean) {
        Card(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp), elevation = 2.dp,
            shape = RoundedCornerShape(5.dp)
        ) {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Image",
                    modifier = Modifier
                        .padding(2.dp)
                        .align(Alignment.CenterVertically)
                        .clip(RoundedCornerShape(CornerSize(10.dp)))
                )
                Column(modifier = Modifier.padding(2.dp)) {
                    Text(text = item.name.toString(), fontWeight = FontWeight.W700)
                    Text(text = ApiConstant.DUMMY_TXT, modifier = Modifier.padding(top = 2.dp))
                }

            }

        }
    }

}
