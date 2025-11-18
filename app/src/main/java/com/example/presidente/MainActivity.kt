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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
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
        President("Munuel Blanco Encalada", "07/1826–09/1826", R.drawable.manuelblanco, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Ramon Freire", "01/1827–05/1827", R.drawable.ramonfreire, "Impulsó modernización económica...", listOf("Infraestructura", "Acuerdos comerciales")),
        President("Francisco Antonio Pinto", "10/1829–11/1829", R.drawable.franciscoant, "Primera presidenta mujer...", listOf("Reformas sociales", "Educación gratuita")),
        President("Jose Joaquin Prieto", "1831–1841", R.drawable.josejoa, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Manuel Bulnes", "1841–1851", R.drawable.manuelbulnes, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Manuel Montt", "1851–1861", R.drawable.manuelmontt, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Jose Joaquin Perez", "1861-1871", R.drawable.josejoaquinpe, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Federico Errazuriz Zañartu", "1871-1876", R.drawable.federicoerra, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Anibal Pinto", "1876-1881", R.drawable.anibalpinto, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Domingo Santa Maria", "1881-1886", R.drawable.domingosanta, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Jose Manuel Balmaceda", "1886-1891", R.drawable.josemanuelbal, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Jorge Montt", "1891-1896", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Federico Errazutiz Echaurren", "1896-1901", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("German Riesco", "1901-1906", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Pedro Montt", "1906-1910", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Ramon Barros Luco", "1910-1915", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Juan Luis Sanfuentes", "1915–1920", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Arturo Alessandri", "1920–1925", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Emiliano Figueroa", "1925–1927", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Carlos Ibañez del Campo", "1927–1931", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Juan Esteban Montero", "1931–1932", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Arturo Alessandri", "1932-1938", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Pedro Aguirre Cerda", "1938–1941", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Juan Antonio Rios", "1942–1946", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Gabriel Gonzales Videla", "1946–1952", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Carlos Ibañez del Campo", "1952–1958", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Jorge Alessandri", "1958–1964", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Eduardo Frei Montalva", "1964–1970", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Salvador Allende", "1970–1973", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Agusto Pinochet", "1974–1990", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Patricio Aylwin", "1990–1994", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Eduardo Frei Ruiz-Tagle", "1994–2000", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Ricardo Lagos", "2000-2006", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Michelle Bachelet", "2006-2010", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Sebastan Piñera", "2010-2014", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Michelle Bachelet", "2014-2018", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Sebastan Piñera", "2018-2022", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales")),
        President("Gabriel Boric", "2022-", R.drawable.aylwin, "Primer presidente tras la dictadura...", listOf("Transición democrática", "Reformas constitucionales"))
    )
}

@Composable
fun TimelineScreen(presidents: List<President>, navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        TimelineHeader()
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
                // Texto (máximo 60% del ancho disponible)
                Box(modifier = Modifier.weight(0.6f)) {
                    Column(
                        modifier = Modifier
                            .clickable { expanded = !expanded }
                            .widthIn(max = 300.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = president.name, // o president.name.split(" ").reversed().joinToString(" ")
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.End,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = president.term,
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.End
                        )
                    }
                }

                Spacer(modifier = Modifier.width(2.dp))

                // Imagen (fijo, 72.dp)
                Box(modifier = Modifier.width(72.dp)) {
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
            }
        } else {
            Spacer(modifier = Modifier.weight(1f))
        }


        // LÍNEA CENTRAL
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
              
                    .height(5.dp)
                    .background(Color.LightGray)
            )
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
            )
        }

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

                Spacer(modifier = Modifier.width(2.dp))

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

@Composable
fun TimelineHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.escudo_chile), // Usa tu recurso real
            contentDescription = "Escudo de Chile",
            modifier = Modifier.size(72.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Línea de Tiempo Presidentes de Chile",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
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
