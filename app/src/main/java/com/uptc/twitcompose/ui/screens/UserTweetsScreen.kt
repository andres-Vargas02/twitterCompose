package com.uptc.twitcompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.uptc.twitcompose.model.Tweet
import com.uptc.twitcompose.model.generateTweetsForUsers
import com.uptc.twitcompose.ui.composables.TweetItem
import com.uptc.twitcompose.R

@Composable
fun UserTweetsScreen(navController: NavController, userName: String, tweets: List<Tweet>) {
    Scaffold(
        topBar = {
            Column {
                LazyRow(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth()
                ) {
                    item {
                        Text(
                            text = "$userName",
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(end = 250.dp)

                        )
                    }
                    item {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            IconButton(
                                onClick = { /* Acción de búsqueda */ },
                                modifier = Modifier.size(24.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_look),
                                    contentDescription = "Buscar",
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            IconButton(
                                onClick = { /* Acción de opciones */ },
                                modifier = Modifier.size(24.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_dots),
                                    contentDescription = "Más opciones",
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }
                }


                // Segunda fila con botones de categorías, alineados a la izquierda
                LazyRow(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    val sections = listOf("Publicaciones", "Respuestas", "Destacados", "Multimedia")
                    sections.forEach { section ->
                        item {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(end = 20.dp)
                            ) {
                                Text(
                                    text = section,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                    }
                }
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(tweets.filter { it.userName == userName }) { tweet ->
                TweetItem(navController = navController, tweet = tweet)
                HorizontalDivider(thickness = 0.5.dp, color = Color.Gray)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserTweetsScreenPreview() {
    val navController = rememberNavController()
    val tweets = generateTweetsForUsers().filter { it.userName == "Alice" }
    UserTweetsScreen(navController = navController, userName = "Alice", tweets = tweets)
}
