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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.uptc.twitcompose.R
import com.uptc.twitcompose.model.Tweet
import com.uptc.twitcompose.model.generateTweetsForUsers
import com.uptc.twitcompose.ui.composables.TweetItem

/**
 * Pantalla principal que muestra una lista de Tweets.
 * @param navController Controlador de navegación para navegar entre pantallas.
 * @param tweets Lista de Tweets a mostrar.
 */
@Composable
fun TwitterScreen(navController: NavController, tweets: List<Tweet>) {
    Scaffold(
        topBar = { TwitterTopBar() },
        bottomBar = { TwitterBottomBar() }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(tweets) { tweet ->
                TweetItem(navController = navController, tweet = tweet)
                HorizontalDivider(thickness = 0.5.dp, color = Color.Gray)
            }
        }
    }
}

/**
 * Barra superior con el logotipo y opciones de perfil y ajustes.
 */
@Composable
fun TwitterTopBar() {
    NavigationBar(containerColor = Color.Transparent) {
        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.u1),
                    contentDescription = "Profile",
                    modifier = Modifier.size(32.dp).clip(CircleShape)
                )
            },
            selected = true,
            onClick = { },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent
            )
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
                onClick = { },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

/**
 * Barra inferior con los iconos de navegación de la aplicación.
 */
@Composable
fun TwitterBottomBar() {
    val iconSize = 28.dp
    val icons = listOf(
        R.drawable.ic_home to "Home",
        R.drawable.ic_look to "Look",
        R.drawable.ic_gro to "Grow",
        R.drawable.ic_community to "Community",
        R.drawable.ic_campaign to "Campaign",
        R.drawable.ic_envelope to "Envelope"
    )
    NavigationBar(containerColor = Color.Transparent) {
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
                onClick = { },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TwitterScreenPreview() {
    val navController = rememberNavController()
    val tweets = generateTweetsForUsers()
    TwitterScreen(navController = navController, tweets = tweets)
}
