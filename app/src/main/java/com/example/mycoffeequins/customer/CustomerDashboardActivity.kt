package com.example.mycoffeequins.customer

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.card.MaterialCardView

class CustomerDashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_dashboard)

        // ===== CARD CLICK =====
        findViewById<MaterialCardView>(R.id.cardMenu).setOnClickListener {
            startActivity(Intent(this, MenuListActivity::class.java))
        }

        findViewById<MaterialCardView>(R.id.cardCart).setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        findViewById<MaterialCardView>(R.id.cardOrders).setOnClickListener {
            startActivity(Intent(this, CustomerOrderActivity::class.java))
        }

        findViewById<ImageView>(R.id.imgProfileIcon).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        // ===== BOTTOM NAV =====
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        // 🔥 SET MENU AKTIF
        bottomNav.selectedItemId = R.id.nav_dashboard

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {

                // ✅ HALAMAN INI (JANGAN PINDAH)
                R.id.nav_dashboard -> true

                R.id.nav_cart -> {
                    startActivity(Intent(this, CartActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }

                R.id.nav_orders -> {
                    startActivity(Intent(this, CustomerOrderActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }

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
