package com.example.mycoffeequins.customer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycoffeequins.R

class CustomerOrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_order)

        val recyclerView = findViewById<RecyclerView>(R.id.rvCustomerOrders)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val orderList = listOf(
            OrderItem("Espresso", 12000, "Diproses"),
            OrderItem("Cappuccino", 15000, "Selesai"),
            OrderItem("Chocolate Cake", 20000, "Diproses")
        )

        recyclerView.adapter = CustomerOrderAdapter(orderList)
    }
}
