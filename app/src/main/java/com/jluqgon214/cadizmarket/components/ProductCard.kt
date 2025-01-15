package com.jluqgon214.cadizmarket.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.navigation.NavController
import com.jluqgon214.cadizmarket.model.Product
import com.jluqgon214.cadizmarket.model.ProductViewModel

@Composable
fun ProductCard(navController: NavController, product: Product, viewModel: ProductViewModel) {
    Card(
        onClick = {
            // Actualizamos el producto actual en el ViewModel
            viewModel.actualProduct = product
            // Aquí irá la navegación a la pantalla de detalles
            navController.navigate("details")
        }
    ) {
        // Aquí irá el contenido de la tarjeta
        Image(
            painter = painterResource(id = product.image),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentScale = ContentScale.Crop
        )


        // Mostramos el nombre del producto
        Text(product.name)

        // Mostramos el precio del producto dependeiendo si tiene descuento o no
        if (product.discount == true) {
            Row {
                Text("${product.price} €", textDecoration = TextDecoration.LineThrough)
                Text("${product.calculateDiscount()} €")
            }
        } else {
            Text("${product.price} €")
        }
    }
}