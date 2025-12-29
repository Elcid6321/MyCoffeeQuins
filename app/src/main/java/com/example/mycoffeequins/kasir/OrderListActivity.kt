package com.example.mycoffeequins.kasir

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycoffeequins.R

class OrderListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_list)

        val recyclerView = findViewById<RecyclerView>(R.id.rvOrder)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val orderList = listOf(
            Order("Andi", "Rp 45.000", "Menunggu"),
            Order("Budi", "Rp 30.000", "Diproses"),
            Order("Siti", "Rp 25.000", "Menunggu"),
            Order("Rina", "Rp 60.000", "Selesai")
        )

        recyclerView.adapter = OrderAdapter(orderList)
    }
}
