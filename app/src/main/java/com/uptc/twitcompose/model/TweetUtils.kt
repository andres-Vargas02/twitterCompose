package com.uptc.twitcompose.model

import com.uptc.twitcompose.R

/**
 * Genera una lista de tweets de muestra para diferentes usuarios.
 *
 * @return Lista de tweets de ejemplo.
 */
fun generateTweetsForUsers(): List<Tweet> {
    val users = listOf(
        "Alex" to "alex123",
        "Brayan" to "brayitan57",
        "Carlos" to "charlie",
        "Diana" to "dianita"
    )

    val images = listOf(R.drawable.u2, R.drawable.u3, R.drawable.u4, R.drawable.u5)
    val contentSamples = listOf("¡Hola mundo!", "Disfrutando del clima", "Acabo de tomar un café", "¡Codificando en Compose!")
    val backgrounds = listOf(R.drawable.background1, R.drawable.background2, R.drawable.background3, R.drawable.background4)

    // Crea una lista de tweets para cada usuario con contenido y mezcla aleatoria
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

/**
 * Genera un tweet de muestra.
 *
 * @return Tweet de ejemplo.
 */
fun generateSampleTweet(): Tweet {
    return Tweet(
        userName = "John",
        userHandle = "El_john",
        content = "¡Este es un tweet de muestra!",
        userImage = R.drawable.u1,
        contentImage = R.drawable.background1
    )
}
