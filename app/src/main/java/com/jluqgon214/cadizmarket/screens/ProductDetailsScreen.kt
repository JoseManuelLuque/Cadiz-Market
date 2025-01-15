package com.jluqgon214.cadizmarket.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jluqgon214.cadizmarket.model.Product

@Composable
fun ProductDetailsScreen(navController: NavController, product: Product) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Image(
            painter = painterResource(id = product.image),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .weight(2f),
            contentScale = ContentScale.Crop

        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .weight(1f)
        ){// Mostramos el nombre del producto
            Text(product.name, style = MaterialTheme.typography.titleLarge, modifier = Modifier.weight(2f).fillMaxWidth(), textAlign = TextAlign.Center)

            // Mostramos la categoría del producto
            Text(product.category!!.value, style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f).fillMaxWidth()
            )

            // Mostramos la descripción del producto
            Text(product.description, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f).fillMaxWidth())

            // Mostramos el precio del producto dependeiendo si tiene descuento o no
            if (product.discount == true) {
                Column(
                    modifier = Modifier.weight(3f)
                ) {
                    Text("${product.price} €", textDecoration = TextDecoration.LineThrough, style = MaterialTheme.typography.headlineLarge, textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth())
                    Text("${product.calculateDiscount()} €", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.End)
                }
            } else {
                Text("${product.price} €", modifier = Modifier.weight(3f).fillMaxWidth(), style = MaterialTheme.typography.headlineLarge, textAlign = TextAlign.End)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            TextButton(
                onClick = {
                    navController.navigate("home")
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Volver")
            }

            Button(
                onClick = {
                    Toast.makeText(navController.context, "Producto comprado de mentira", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Comprar")
            }
        }
    }
}