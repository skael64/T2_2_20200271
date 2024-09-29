package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var currentIndex by remember { mutableStateOf(0) }
    val images = listOf(R.drawable.image1, R.drawable.image2) // Reemplaza con tus imágenes
    val descriptions = listOf("Cafe en la terraza (1888). Vicent Van Gogh", "Girasoles (1888). Vincent Van Gogh")

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Recuadro blanco con imagen
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(16.dp)
                .background(Color.White, RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = images[currentIndex]),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Contenedor con descripción
        Text(
            text = descriptions[currentIndex],
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )

        // Botones "Atrás" y "Siguiente"
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = {
                if (currentIndex > 0) currentIndex-- // Navegar hacia atrás
            }) {
                Text("Atrás")
            }

            Button(onClick = {
                if (currentIndex < images.size - 1) currentIndex++ // Navegar hacia adelante
            }) {
                Text("Siguiente")
            }
        }
    }
}
