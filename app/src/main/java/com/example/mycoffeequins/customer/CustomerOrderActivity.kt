package com.example.mycoffeequins.customer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycoffeequins.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class CustomerOrderActivity : AppCompatActivity() {

    private val orderList = mutableListOf<OrderItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_order)

        // ===== INIT VIEW =====
        val recyclerOrder = findViewById<RecyclerView>(R.id.recyclerOrder)
        val tvEmpty = findViewById<TextView>(R.id.tvEmptyOrder)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        recyclerOrder.layoutManager = LinearLayoutManager(this)

        // ===== SET ACTIVE NAV =====
        bottomNav.selectedItemId = R.id.nav_orders

        // ===== DATA DUMMY =====
        orderList.addAll(
            listOf(
                OrderItem("Cappuccino", 15000, R.drawable.cappuccino, "Diproses", 1),
                OrderItem("Espresso", 12000, R.drawable.espresso, "Selesai", 2),
                OrderItem("Brownies", 18000, R.drawable.brownies, "Diproses", 1)
            )
        )

        // ===== ADAPTER =====
        recyclerOrder.adapter = CustomerOrderAdapter(orderList)

        // ===== EMPTY STATE =====
        tvEmpty.visibility = if (orderList.isEmpty()) View.VISIBLE else View.GONE

        // ===== BOTTOM NAV =====
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.nav_dashboard -> {
                    startActivity(Intent(this, CustomerDashboardActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }

                R.id.nav_cart -> {
                    startActivity(Intent(this, CartActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }

                R.id.nav_orders -> true

                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }

                else -> false
            }
        }
    }
}
