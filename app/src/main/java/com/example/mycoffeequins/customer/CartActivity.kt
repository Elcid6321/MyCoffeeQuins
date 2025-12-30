package com.example.mycoffeequins.customer

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R

class CartActivity : AppCompatActivity() {

    private val cartItems = mutableListOf<String>()
    private val cartPrices = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val listCart = findViewById<ListView>(R.id.listCart)
        val tvTotal = findViewById<TextView>(R.id.tvTotalPrice)
        val btnCheckout = findViewById<Button>(R.id.btnCheckout)
        val btnBack = findViewById<Button>(R.id.btnBackCart)

        // === DATA STATIS (DUMMY TAPI MASUK AKAL) ===
        cartItems.addAll(
            listOf(
                "Cappuccino - Rp 15000",
                "Americano - Rp 12000",
                "Brownies - Rp 18000"
            )
        )

        cartPrices.addAll(listOf(15000, 12000, 18000))

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            cartItems
        )

        listCart.adapter = adapter
        updateTotal(tvTotal)

        // === HAPUS ITEM (GIMIK UI SAJA) ===
        listCart.setOnItemClickListener { _, _, position, _ ->
            AlertDialog.Builder(this)
                .setTitle("Hapus Item")
                .setMessage("Hapus item dari keranjang?")
                .setPositiveButton("Hapus") { _, _ ->
                    cartItems.removeAt(position)
                    cartPrices.removeAt(position)
                    adapter.notifyDataSetChanged()
                    updateTotal(tvTotal)
                }
                .setNegativeButton("Batal", null)
                .show()
        }

        // === CHECKOUT (SELALU BISA PINDAH HALAMAN) ===
        btnCheckout.setOnClickListener {
            val total = cartPrices.sum()
            val intent = Intent(this, CheckoutActivity::class.java)
            intent.putExtra("total", total)
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun updateTotal(tvTotal: TextView) {
        val total = cartPrices.sum()
        tvTotal.text = "Total: Rp $total"
    }
}
