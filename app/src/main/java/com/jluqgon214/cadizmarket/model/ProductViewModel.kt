package com.jluqgon214.cadizmarket.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.jluqgon214.cadizmarket.R

class ProductViewModel: ViewModel() {
    // Productos de ejemplo
    private val _exampleProducts = mutableStateOf<List<Product>>(listOf(
        Product(
            name = "Queso Artesano",
            description = "Queso de cabra artesanal de la sierra de Cádiz.",
            price = 15.0,
            image = R.drawable.cheese,
            category = ProductCategory.ALIMENTACION,
            discount = true,
            discountPercentage = 10
        ),
        Product(
            name = "Jabón Natural",
            description = "Jabón hecho a mano con ingredientes naturales.",
            price = 5.0,
            image = R.drawable.soap,
            category = ProductCategory.ARTESANIA,
            discount = false
        ),
        Product(
            name = "Aceite de Oliva",
            description = "Aceite de oliva virgen extra de la mejor calidad.",
            price = 20.0,
            image = R.drawable.olive_oil,
            category = ProductCategory.ALIMENTACION,
            discount = true,
            discountPercentage = 15
        ),
        Product(
            name = "Cerámica Decorativa",
            description = "Pieza de cerámica decorativa hecha a mano.",
            price = 30.0,
            image = R.drawable.ceramincs,
            category = ProductCategory.ARTESANIA,
            discount = false
        ),
        Product(
            name = "Camiseta del Cadiz",
            description = "Camiseta de futbol de la mejor calidad.",
            price = 25.0,
            image = R.drawable.tshirt,
            category = ProductCategory.MODA,
            discount = true,
            discountPercentage = 20
        ),
        Product(
            name = "Bolso de Cuero",
            description = "Bolso de cuero hecho a mano.",
            price = 50.0,
            image = R.drawable.bag,
            category = ProductCategory.MODA,
            discount = false
        ),
        Product(
            name = "Auriculares Inalámbricos",
            description = "Auriculares con cancelación de ruido del Cadiz FC.",
            price = 100.0,
            image = R.drawable.headphones,
            category = ProductCategory.TECNOLOGIA,
            discount = true,
            discountPercentage = 15
        ),
        Product(
            name = "Reloj Inteligente",
            description = "Reloj inteligente con monitor de actividad del Cadiz FC.",
            price = 150.0,
            image = R.drawable.smartwatch,
            category = ProductCategory.TECNOLOGIA,
            discount = false
        )
    ))
    val exampleProducts: MutableState<List<Product>> = _exampleProducts

    // Producto actual
    var actualProduct = exampleProducts.value[0]

    // Actualiza el producto actual
    fun updateActualProduct(product: Product) {
        actualProduct = product
    }

    // Categoria seleccionada
    private var _selectedCategory = mutableStateOf(ProductCategory.ALL)
    var selectedCategory: MutableState<ProductCategory> = _selectedCategory


    // Filtra los productos por categoria
    fun updateSelectedCategory(category: ProductCategory) {
        selectedCategory.value = category
    }

    // Titulo de la pagina principal
    private val _title = mutableStateOf("Todos nuestros productos disponibles")
    val title: MutableState<String> = _title

    // Actualiza el titulo de la pagina principal
    fun updateTitle(title: String) {
        _title.value = "Productos de: $title"
    }
}