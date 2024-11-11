package com.uptc.twitcompose.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.uptc.twitcompose.R
import com.uptc.twitcompose.model.Tweet
import com.uptc.twitcompose.model.generateSampleTweet

@Composable
fun TweetItem(navController: NavController, tweet: Tweet) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { navController.navigate("userTweets/${tweet.userName}") },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        ConstraintLayout(modifier = Modifier.padding(8.dp)) {
            val (profileImage, userInfoAndContent, actions) = createRefs()
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
                Text(
                    text = tweet.content,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Image(
                    painter = painterResource(id = tweet.contentImage),
                    contentDescription = "Profile"
                )


                val icons = listOf(
                    R.drawable.ic_dialogue to "dialogue",
                    R.drawable.ic_rt to "rt",
                    R.drawable.ic_heart to "heart",
                    R.drawable.ic_favorit to "favorite",
                    R.drawable.ic_share to "share"
                )

                val iconWidth = 65.dp
                val iconHeight = 24.dp
                val iconTint = MaterialTheme.colorScheme.primary


                LazyRow(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                ) {
                    items(icons) { (iconId, description) ->
                        IconButton(
                            onClick = { },
                            modifier = Modifier
                                .width(iconWidth)
                                .height(iconHeight)
                                .weight(1f)
                        ) {
                            Icon(
                                painter = painterResource(id = iconId),
                                contentDescription = description,
                                tint = iconTint
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TweetItemPreview() {
    val navController = rememberNavController()
    val tweet = generateSampleTweet()
    TweetItem(navController = navController, tweet = tweet)
}

