package com.uptc.twitcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.uptc.twitcompose.model.Tweet
import com.uptc.twitcompose.model.generateTweetsForUsers
import com.uptc.twitcompose.ui.screens.TwitterScreen
import com.uptc.twitcompose.ui.screens.UserTweetsScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    val tweets: List<Tweet> = generateTweetsForUsers()

    NavHost(navController = navController, startDestination = "tweetList") {
        composable("tweetList") {
            TwitterScreen(navController = navController, tweets = tweets)
        }
        composable("userTweets/{userName}") { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName").orEmpty()
            UserTweetsScreen(navController = navController, userName = userName, tweets = tweets)
        }
    }
}
