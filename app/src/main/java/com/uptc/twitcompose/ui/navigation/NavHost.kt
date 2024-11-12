package com.uptc.twitcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.uptc.twitcompose.model.Tweet
import com.uptc.twitcompose.model.generateTweetsForUsers
import com.uptc.twitcompose.ui.screens.TwitterScreen
import com.uptc.twitcompose.ui.screens.UserTweetsScreen

// Constantes para las rutas de navegación
private const val TWEET_LIST_ROUTE = "tweetList"
private const val USER_TWEETS_ROUTE = "userTweets/{userName}"

/**
 * Configuración de la navegación en la aplicación.
 * @param navController Controlador de navegación para gestionar la pila de destinos.
 */
@Composable
fun AppNavHost(navController: NavHostController) {
    val tweets: List<Tweet> = generateTweetsForUsers()

    // Configuración de la estructura de navegación
    NavHost(navController = navController, startDestination = TWEET_LIST_ROUTE) {

        // Composable para mostrar la lista de tweets
        composable(TWEET_LIST_ROUTE) {
            TwitterScreen(navController = navController, tweets = tweets)
        }

        // Composable para mostrar los tweets de un usuario específico
        composable(USER_TWEETS_ROUTE) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName").orEmpty()
            UserTweetsScreen(navController = navController, userName = userName, tweets = tweets)
        }
    }
}
