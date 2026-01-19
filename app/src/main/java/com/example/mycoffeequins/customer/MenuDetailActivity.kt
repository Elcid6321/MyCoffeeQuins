package com.example.mycoffeequins.customer

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.text.NumberFormat
import java.util.Locale

class MenuDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_detail)

        val imgMenu = findViewById<ImageView>(R.id.imgDetailMenu)
        val tvName = findViewById<TextView>(R.id.tvDetailName)
        val tvDesc = findViewById<TextView>(R.id.tvDetailDesc)
        val tvPrice = findViewById<TextView>(R.id.tvDetailPrice)
        val btnAdd = findViewById<Button>(R.id.btnAddCart)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        // ===== AMBIL DATA =====
        val name = intent.getStringExtra("name") ?: ""
        val desc = intent.getStringExtra("desc") ?: ""
        val price = intent.getIntExtra("price", 0)
        val image = intent.getIntExtra("image", 0)

        tvName.text = name
        tvDesc.text = desc
        tvPrice.text = formatRupiah(price)
        imgMenu.setImageResource(image)

        // ===== ADD TO CART =====
        btnAdd.setOnClickListener {
            Toast.makeText(this, "$name ditambahkan ke keranjang", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, CartActivity::class.java))
        }

        btnBack.setOnClickListener {
            finish()
        }

        // ===== BOTTOM NAV =====
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_dashboard -> {
                    startActivity(Intent(this, CustomerDashboardActivity::class.java))
                    true
                }
                R.id.nav_cart -> {
                    startActivity(Intent(this, CartActivity::class.java))
                    true
                }
                R.id.nav_orders -> {
                    startActivity(Intent(this, CustomerOrderActivity::class.java))
                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

    private fun formatRupiah(amount: Int): String {
        val localeID = Locale("in", "ID")
        val formatter = NumberFormat.getCurrencyInstance(localeID)
        formatter.maximumFractionDigits = 0
        return formatter.format(amount)
    }
}
