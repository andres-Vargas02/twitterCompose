package com.uptc.twitcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.uptc.twitcompose.ui.navigation.AppNavHost
import com.uptc.twitcompose.ui.theme.TwitcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TwitcomposeTheme {
                val navController = rememberNavController()
                AppNavHost(navController = navController)
            }
        }
    }
}
