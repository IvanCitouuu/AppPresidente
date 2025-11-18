package com.example.presidente.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.presidente.models.President

@Composable
fun TimelineItem(
    president: President,
    isLeftAligned: Boolean,
    onClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Row(
            horizontalArrangement = if (isLeftAligned) Arrangement.Start else Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (!isLeftAligned) Spacer(modifier = Modifier.width(32.dp))

                Image(
                    painter = painterResource(id = president.photoResId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Gray, CircleShape)
                        .clickable { onClick() }
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(text = president.name, style = MaterialTheme.typography.titleMedium)
                    Text(text = president.term, style = MaterialTheme.typography.bodyMedium)
                }

                if (isLeftAligned) Spacer(modifier = Modifier.width(32.dp))
            }
        }

        if (expanded) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = president.bio, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Hitos importantes:", style = MaterialTheme.typography.titleMedium)
            president.milestones.forEach {
                Text(text = "• $it", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
fun TimelineScreen(presidents: List<President>, navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .width(2.dp)
                .fillMaxHeight()
                .background(Color.LightGray)
                .align(Alignment.Center)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            items(presidents) { president ->
                val index = presidents.indexOf(president)
                val isLeftAligned = index % 2 == 0
                TimelineItem(
                    president = president,
                    isLeftAligned = isLeftAligned,
                    onClick = { navController.navigate("detail/$index") }
                )
            }
        }
    }
}
