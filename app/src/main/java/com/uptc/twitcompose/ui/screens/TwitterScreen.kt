package com.uptc.twitcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.uptc.twitcompose.R
import com.uptc.twitcompose.model.Tweet
import com.uptc.twitcompose.ui.composables.TweetItem

/**
 * Pantalla principal que muestra la lista de tweets.
 * @param tweets Lista de objetos Tweet a mostrar.
 */
@Composable
fun TwitterScreen(tweets: List<Tweet>) {
    Scaffold(
        topBar = { TwitterTopBar() },
        bottomBar = { TwitterBottomBar() }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(tweets) { tweet ->
                TweetItem(tweet = tweet)
                HorizontalDivider(thickness = 0.5.dp, color = Color.Gray)
            }
        }
    }
}

/**
 * Barra superior con iconos de perfil, logo y configuraciones.
 */
@Composable
fun TwitterTopBar() {
    NavigationBar {

        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.u1),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                )
            },
            selected = true,
            onClick = { /* Acción al hacer clic */ }
        )

        val icons = listOf(
            R.drawable.ic_logo to "logo",
            R.drawable.ic_settings to "settings"
        )

        icons.forEach { (iconId, description) ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = iconId),
                        contentDescription = description,
                        modifier = Modifier.size(32.dp)
                    )
                },
                selected = true,
                onClick = { /* Acción correspondiente */ }
            )
        }
    }
}

/**
 * Barra inferior de navegación con iconos.
 */
@Composable
fun TwitterBottomBar() {
    val iconSize = 28.dp
    val icons = listOf(
        R.drawable.ic_home to "Home",
        R.drawable.ic_look to "look",
        R.drawable.ic_gro to "gro",
        R.drawable.ic_community to "community",
        R.drawable.ic_campaign to "campaign",
        R.drawable.ic_envelope to "envelope"
    )

    NavigationBar {
        icons.forEach { (iconId, description) ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = iconId),
                        contentDescription = description,
                        modifier = Modifier.size(iconSize)
                    )
                },
                selected = true,
                onClick = { /* Acción correspondiente */ }
            )
        }
    }
}
