package com.uptc.twitcompose.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.uptc.twitcompose.model.Tweet
import com.uptc.twitcompose.ui.composables.TweetItem

@Composable
fun UserTweetsScreen(tweets: List<Tweet>) {
    Scaffold { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(tweets) { tweet ->
                TweetItem(
                    tweet = tweet,
                    //onUserClick = {}
                )
            }
        }
    }
}
