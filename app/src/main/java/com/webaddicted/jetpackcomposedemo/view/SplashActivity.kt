package com.webaddicted.jetpackcomposedemo.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.webaddicted.jetpackcomposedemo.R
import com.webaddicted.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme
import kotlinx.coroutines.delay

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
        // This app draws behind the system bars, so we want to handle fitting system windows
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            JetpackComposeDemoTheme {
                SplashScreen()
            }
        }

    }

    @Preview
    @Composable
    fun SplashScreen() {
        val scale = remember {
            Animatable(0f)
        }
        // Animation
        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 0.8f,
                // tween Animation
                animationSpec = tween(
                    durationMillis = 1500,
                    easing = {
                        OvershootInterpolator(4f).getInterpolation(it)
                    })
            )
            // Customize the delay time
            delay(1000L)
            LoginActivity.newClearIntent(this@SplashActivity)
//            navController.navigate("main_screen")
        }

        // Image
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // Change the logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.run { scale(scale.value)
//                size(120.dp)
                }

            )
        }
    }
//    @Preview
//    @Composable
//    private fun SplashScreen() {
//        Column(
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier.run { fillMaxSize() }
//        ) {
//            IconButton(onClick = { LoginActivity.newIntent(this@SplashActivity) }) {
//                Icon(
//                    Icons.Filled.Person,
//                    contentDescription = "User",
//                    tint = MaterialTheme.colors.primary,
//                    modifier = Modifier.size(120.dp)
//                )
//            }
//            Spacer(modifier = Modifier.height(20.dp))
//            Text(
//                text = resources.getString(R.string.app_name),
//                fontSize = 18.sp,
//                fontWeight = FontWeight.Bold
//            )
//        }
//    }
}