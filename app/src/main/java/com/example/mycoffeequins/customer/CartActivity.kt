package com.example.mycoffeequins.customer

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val listCart = findViewById<ListView>(R.id.listCart)
        val tvTotal = findViewById<TextView>(R.id.tvTotalPrice)
        val btnCheckout = findViewById<Button>(R.id.btnCheckout)
        val btnBack = findViewById<Button>(R.id.btnBackCart)

        // DATA PESANAN (SEOLAH SUDAH ADA)
        val items = listOf(
            "Cappuccino - Rp 15000",
            "Americano - Rp 12000",
            "Brownies - Rp 18000"
        )

        val totalPrice = 15000 + 12000 + 18000

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            items
        )

        listCart.adapter = adapter
        tvTotal.text = "Total: Rp $totalPrice"

        btnCheckout.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            intent.putExtra("total", totalPrice)
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}
