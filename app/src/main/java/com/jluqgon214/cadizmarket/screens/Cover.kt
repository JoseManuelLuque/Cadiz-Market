package com.jluqgon214.cadizmarket.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jluqgon214.cadizmarket.R

@Composable
fun Cover(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            // Añadimos un paddin para que no choquen los elementos con los bordes de la pantalla
            .padding(16.dp)
    ) {
        // Aquí irá el contenido de la pantalla de portada
        Image(
            painter = painterResource(id = R.drawable.ic_logosf),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
        )

        // Voy a definir los tamaños de los textos por material theme no por .sp
        Text("Bienvenido a Cadiz Market", style = MaterialTheme.typography.titleLarge, modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.White)
        ){
            Image(
                painter = painterResource(id = R.drawable.cadiz),
                contentDescription = "Cover",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth
            )
            Text(
                "La mejor app para comprar productos 100% locales",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                maxLines = 1,
            )
        }

        Button(
            onClick = {
                // Eliminar la pantalla del trazo de navegación para no poder acceder a ella directamente(Solo quiero mostrarla al iniciar que no se pueda volver pulsando atras)
                navController.popBackStack()
                // Navegar a la pantalla de principal
                navController.navigate("home")
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .weight(1f)
        ) {
            Text("Iniciar")
        }
    }
}