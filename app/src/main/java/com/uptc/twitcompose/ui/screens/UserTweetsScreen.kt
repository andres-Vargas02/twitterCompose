package com.uptc.twitcompose.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.uptc.twitcompose.model.Tweet
import com.uptc.twitcompose.ui.composables.TweetItem

/**
 * Pantalla que muestra los tweets de un usuario específico.
 * @param userName Nombre del usuario cuyos tweets se mostrarán.
 * @param tweets Lista de objetos Tweet.
 */
@Composable
fun UserTweetsScreen(userName: String, tweets: List<Tweet>) {
    Scaffold(
        topBar = { Text(text = "$userName's Tweets", style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(16.dp)) },
        bottomBar = { TwitterBottomBar() }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(tweets.filter { it.userName == userName }) { tweet ->
                TweetItem(tweet = tweet)
                HorizontalDivider(thickness = 0.5.dp, color = Color.Gray)
            }
        }
    }
}
