package com.uptc.twitcompose.model

import com.uptc.twitcompose.R

fun generateTweetsForUsers(): List<Tweet> {
    val users = listOf(
        "Alice" to "alice123",
        "Bob" to "bob_the_builder",
        "Charlie" to "charlie_chaplin",
        "Diana" to "diana_queen"
    )

    val images = listOf(R.drawable.u2, R.drawable.u3, R.drawable.u4, R.drawable.u5)
    val contentSamples = listOf("Hello world!", "Enjoying the weather", "Just had coffee", "Coding in Compose!")
    val backgrounds = listOf(R.drawable.background1, R.drawable.background2, R.drawable.background3, R.drawable.background4)

    return users.flatMapIndexed { index, (name, handle) ->
        List(contentSamples.size) { tweetIndex ->
            Tweet(
                userName = name,
                userHandle = handle,
                content = contentSamples[tweetIndex],
                userImage = images.getOrElse(index) { images[0] },
                contentImage = backgrounds.getOrElse(tweetIndex) { backgrounds[0] }
            )
        }
    }.shuffled()
}

fun generateSampleTweet(): Tweet {
    return Tweet(
        userName = "John Doe",
        userHandle = "john_doe",
        content = "This is a sample tweet!",
        userImage = R.drawable.u1,
        contentImage = R.drawable.background1
    )
}
