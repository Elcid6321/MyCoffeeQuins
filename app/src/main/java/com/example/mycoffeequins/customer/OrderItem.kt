package com.example.mycoffeequins.customer

data class OrderItem(
    val name: String,
    val price: Int,
    val imageRes: Int,
    val status: String,
    val quantity: Int
)
