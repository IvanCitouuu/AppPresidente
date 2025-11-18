package com.example.presidente

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.presidente.models.President
import com.example.presidente.ui.theme.PresidenteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PresidenteTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "timeline") {
                    composable("timeline") {
                        TimelineScreen(PresidentsRepository.presidents, navController)
                    }
                    composable("detail/{index}") { backStackEntry ->
                        val index = backStackEntry.arguments?.getString("index")?.toIntOrNull() ?: 0
                        PresidentDetailScreen(PresidentsRepository.presidents[index], navController)
                    }
                }
            }
        }
    }
}

/** Repositorio simulado para mantener los datos separados de la UI */
object PresidentsRepository {
    val presidents = listOf(
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Eduardo Frei", "1994–2000", R.drawable.frei, "Impulsó modernización económica...", listOf("Infraestructura", "Acuerdos comerciales")),
        President("Michelle Bachelet", "2006–2010", R.drawable.bachelet, "Primera presidenta mujer...", listOf("Reformas sociales", "Educación gratuita")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales"))
    )
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
                .padding(horizontal = 2.dp)
        ) {
            itemsIndexed(presidents) { index, president ->
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


@Composable
fun TimelineItem(
    president: President,
    isLeftAligned: Boolean,
    onClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // IZQUIERDA
        if (isLeftAligned) {
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Texto primero (hacia adentro)
                Column(
                    modifier = Modifier.clickable { expanded = !expanded },
                    horizontalAlignment = Alignment.End
                ) {
                    Text(text = president.name, style = MaterialTheme.typography.titleMedium)
                    Text(text = president.term, style = MaterialTheme.typography.bodyMedium)
                }

                Spacer(modifier = Modifier.width(12.dp))

                // Círculo AHORA afuera
                Image(
                    painter = painterResource(id = president.photoResId),
                    contentDescription = president.name,
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Gray, CircleShape)
                        .clickable { onClick() }
                )
            }
        } else {
            Spacer(modifier = Modifier.weight(1f))
        }

        // LÍNEA CENTRAL
        Box(
            modifier = Modifier
                .width(2.dp)
                .height(80.dp)
                .background(Color.LightGray)
        )

        // DERECHA
        if (!isLeftAligned) {
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Círculo AHORA afuera
                Image(
                    painter = painterResource(id = president.photoResId),
                    contentDescription = president.name,
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Gray, CircleShape)
                        .clickable { onClick() }
                )

                Spacer(modifier = Modifier.width(12.dp))

                // Texto después (hacia adentro)
                Column(
                    modifier = Modifier.clickable { expanded = !expanded },
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = president.name, style = MaterialTheme.typography.titleMedium)
                    Text(text = president.term, style = MaterialTheme.typography.bodyMedium)
                }
            }
        } else {
            Spacer(modifier = Modifier.weight(1f))
        }
    }

    // EXPANDIDO
    if (expanded) {
        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
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
fun PresidentDetailScreen(president: President, navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Image(
                painter = painterResource(id = president.photoResId),
                contentDescription = president.name,
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = president.name, style = MaterialTheme.typography.headlineSmall)
            Text(text = president.term, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = president.bio, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Hitos importantes:", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            president.milestones.forEach {
                Text(text = "• $it", style = MaterialTheme.typography.bodyMedium)
            }
        }

        FloatingActionButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            containerColor = Color.Black,
            contentColor = Color.White
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Volver al inicio"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TimelinePreview() {
    val fakeNavController = rememberNavController()
    PresidenteTheme {
        TimelineScreen(PresidentsRepository.presidents, navController = fakeNavController)
    }
}
