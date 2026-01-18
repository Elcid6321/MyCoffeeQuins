package com.example.mycoffeequins.customer

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycoffeequins.R

class CustomerOrderActivity : AppCompatActivity() {

    private val orderList = mutableListOf<OrderItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_order)

        val recyclerOrder = findViewById<RecyclerView>(R.id.recyclerOrder)
        val tvEmpty = findViewById<TextView>(R.id.tvEmptyOrder)

        recyclerOrder.layoutManager = LinearLayoutManager(this)

        // ================= DATA DUMMY =================
        orderList.addAll(
            listOf(
                OrderItem("Cappuccino", 15000, R.drawable.cappuccino, "Diproses", 1),
                OrderItem("Espresso", 12000, R.drawable.espresso, "Selesai", 2),
                OrderItem("Brownies", 18000, R.drawable.brownies, "Diproses", 1)
            )
        )

        // ================= ADAPTER =================
        val adapter = CustomerOrderAdapter(orderList)
        recyclerOrder.adapter = adapter

        // ================= EMPTY STATE =================
        tvEmpty.visibility = if (orderList.isEmpty()) View.VISIBLE else View.GONE
    }
}
