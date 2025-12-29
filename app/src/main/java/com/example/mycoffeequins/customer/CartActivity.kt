package com.example.mycoffeequins.customer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val imgMenu = findViewById<ImageView>(R.id.imgCartMenu)
        val tvItemName = findViewById<TextView>(R.id.tvCartItemName)
        val tvItemPrice = findViewById<TextView>(R.id.tvCartItemPrice)
        val tvTotal = findViewById<TextView>(R.id.tvTotalPrice)
        val btnCheckout = findViewById<Button>(R.id.btnCheckout)
        val btnBack = findViewById<Button>(R.id.btnBackCart)

        // TERIMA DATA DARI MENU DETAIL
        val name = intent.getStringExtra("name") ?: ""
        val price = intent.getIntExtra("price", 0)
        val image = intent.getIntExtra("image", 0)

        imgMenu.setImageResource(image)
        tvItemName.text = name
        tvItemPrice.text = "Rp $price"
        tvTotal.text = "Total: Rp $price"

        btnCheckout.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            intent.putExtra("total", price)
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}
