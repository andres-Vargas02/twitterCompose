package com.uptc.twitcompose.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.uptc.twitcompose.R
import com.uptc.twitcompose.model.Tweet

/**
 * Composable que representa un elemento de tweet con la información del usuario y las acciones de interacción.
 * @param tweet Instancia de Tweet que contiene los detalles del tweet.
 */
@Composable
fun TweetItem(tweet: Tweet) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        ConstraintLayout(modifier = Modifier.padding(8.dp)) {
            val (profileImage, userInfoAndContent, actions) = createRefs()

            // Imagen de perfil del usuario
            Image(
                painter = painterResource(id = tweet.userImage),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .constrainAs(profileImage) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    }
            )

            // Columna con información del usuario y contenido del tweet
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .constrainAs(userInfoAndContent) {
                        start.linkTo(profileImage.end)
                        top.linkTo(profileImage.top)
                    }
            ) {
                Row(
                    modifier = Modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = tweet.userName,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "@${tweet.userHandle}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                // Texto del contenido del tweet
                Text(
                    text = tweet.content,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(top = 8.dp)
                )
                // Imagen del contenido del tweet
                Image(
                    painter = painterResource(id = tweet.contentImage),
                    contentDescription = "Profile"
                )


                // Acciones de interacción (iconos)
                Row(
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    val iconSize = 24.dp
                    val iconTint = MaterialTheme.colorScheme.primary
                    val icons = listOf(
                        R.drawable.ic_dialogue to "dialogue",
                        R.drawable.ic_rt to "rt",
                        R.drawable.ic_heart to "heart",
                        R.drawable.ic_favorit to "favorite",
                        R.drawable.ic_share to "share"
                    )

                    icons.forEach { (iconId, description) ->
                        IconButton(
                            onClick = { /* Acción correspondiente */ },
                            modifier = Modifier.size(iconSize)
                        ) {
                            Icon(
                                painter = painterResource(id = iconId),
                                contentDescription = description,
                                tint = iconTint
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }
            }
        }
    }
}
