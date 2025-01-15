package com.jluqgon214.cadizmarket.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jluqgon214.cadizmarket.components.ProductCard
import com.jluqgon214.cadizmarket.model.ProductCategory
import com.jluqgon214.cadizmarket.model.ProductViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: ProductViewModel) {
    // Pantalla principal de la aplicación
    Column {
        // Título de la pantalla
        Text(
            viewModel.title.value,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        // Fila de botones para seleccionar la categoría de productos
        LazyRow {
            ProductCategory.entries.forEach { category ->
                item {
                    Button(
                        onClick = {
                            viewModel.updateSelectedCategory(category)
                            viewModel.updateTitle(category.value)
                        },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text(category.value)
                    }
                }
            }
        }

        // Grid de productos
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Filtrar los productos por categoría
            val filteredProducts = if (viewModel.selectedCategory.value == ProductCategory.ALL) {
                viewModel.exampleProducts.value
            } else {
                viewModel.exampleProducts.value.filter { product ->
                    product.category == viewModel.selectedCategory.value
                }
            }

            // Mostrar los productos
            filteredProducts.forEach { product ->
                item {
                    ProductCard(navController, product, viewModel)
                }
            }
        }
    }
}