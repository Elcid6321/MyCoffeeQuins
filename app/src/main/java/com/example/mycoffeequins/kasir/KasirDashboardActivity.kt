package com.example.mycoffeequins.kasir

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R

class KasirDashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kasir_dashboard)

        val btnOrderList = findViewById<Button>(R.id.btnOrderList)
        val btnManageMenu = findViewById<Button>(R.id.btnManageMenu)
        val btnLogout = findViewById<Button>(R.id.btnLogoutKasir)

        btnOrderList.setOnClickListener {
            startActivity(Intent(this, OrderListActivity::class.java))
        }

        btnManageMenu.setOnClickListener {
            startActivity(Intent(this, ManageMenuActivity::class.java))
        }

        btnLogout.setOnClickListener {
            startActivity(Intent(this, LoginKasirActivity::class.java))
            finish()
        }
    }
}
