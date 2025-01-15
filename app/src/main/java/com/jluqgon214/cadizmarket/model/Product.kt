package com.jluqgon214.cadizmarket.model

import android.health.connect.datatypes.units.Percentage

data class Product(
    val name: String,
    val description: String,
    val price: Double,
    val image: Int, // R.drawable.IMAGEN
    val category: ProductCategory??,
    val discount: Boolean? = false,
    val discountPercentage: Int? = 0,
) {
    // Si el discount es true, calculamos el precio con descuento
    fun calculateDiscount(): Double {
        return price - (price * (discountPercentage?.toDouble() ?: 0.0) / 100)
    }
}

enum class ProductCategory(val value: String) {
    ALIMENTACION("Alimentación"),
    ARTESANIA("Artesanía"),
    MODA("Moda"),
    TECNOLOGIA("Tecnología"),
    ALL("Todas")
}