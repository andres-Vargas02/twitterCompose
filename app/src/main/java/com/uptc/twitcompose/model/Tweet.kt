package com.uptc.twitcompose.model

/**
 * Representa un Tweet con información del usuario y contenido.
 *
 * @property userName Nombre del usuario que publica el tweet.
 * @property userHandle Nombre de usuario o identificador único.
 * @property content Texto del tweet.
 * @property userImage Identificador de recurso de la imagen del usuario.
 * @property contentImage Identificador de recurso de imagen adjunta al tweet, opcional.
 */
data class Tweet(
    val userName: String,
    val userHandle: String,
    val content: String,
    val userImage: Int,
    val contentImage: Int = 0
)
