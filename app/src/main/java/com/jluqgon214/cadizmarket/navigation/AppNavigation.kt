package com.jluqgon214.cadizmarket.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jluqgon214.cadizmarket.R
import com.jluqgon214.cadizmarket.model.Product
import com.jluqgon214.cadizmarket.model.ProductCategory
import com.jluqgon214.cadizmarket.model.ProductViewModel
import com.jluqgon214.cadizmarket.screens.Cover
import com.jluqgon214.cadizmarket.screens.HomeScreen
import com.jluqgon214.cadizmarket.screens.ProductDetailsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val viewModel = ProductViewModel()

    //Scaffold que ocupa toda la pantalla
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            // Tenemos en cuenta la barra de estado para que no se solapen los elementos
            .statusBarsPadding(),
    ) { innerPadding ->
        // Usamos el NavHost para la navegación, definiendo la pantalla de inicio
        NavHost(
            navController = navController,
            startDestination = "cover",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("cover") {
                Cover(navController)
            }

            composable("home") {
                HomeScreen(navController, viewModel)
            }

            composable("details") {
                ProductDetailsScreen(navController, viewModel.actualProduct)

            }

        }
    }
}