package com.uptc.twitcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.uptc.twitcompose.model.Tweet
import com.uptc.twitcompose.ui.theme.TwitcomposeTheme
import com.uptc.twitcompose.ui.screens.TwitterScreen
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TwitcomposeTheme {
                TwitterScreen(tweets = generateTweetsForUsers())
            }
        }
    }

    /**
     * Genera una lista de tweets de prueba con información de usuarios ficticios.
     * @return Lista de objetos Tweet.
     */
    private fun generateTweetsForUsers(): List<Tweet> {
        val users = listOf(
            "User 2" to "user2",
            "User 3" to "user3",
            "User 4" to "user4",
            "User 5" to "user5"
        )
        val images = listOf(R.drawable.u2, R.drawable.u3, R.drawable.u4, R.drawable.u5)
        val contentSamples = listOf("Publicacion 1", "Publicacion 2", "Publicacion 3", "Publicacion 4")
        val backgrounds = listOf(R.drawable.background1, R.drawable.background2, R.drawable.background3, R.drawable.background4)

        return users.flatMapIndexed { index, (name, handle) ->
            List(4) {
                Tweet(
                    userName = name,
                    userHandle = handle,
                    content = contentSamples[it % contentSamples.size],
                    userImage = images[index % images.size],
                    contentImage = backgrounds[it % backgrounds.size]
                )
            }
        }.shuffled(Random(System.currentTimeMillis()))
    }
}
