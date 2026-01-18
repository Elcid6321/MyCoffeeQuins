package com.example.mycoffeequins.customer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class CustomerDashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_dashboard)

        findViewById<MaterialCardView>(R.id.cardMenu).setOnClickListener {
            startActivity(Intent(this, MenuListActivity::class.java))
        }

        findViewById<MaterialCardView>(R.id.cardCart).setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        findViewById<MaterialCardView>(R.id.cardOrders).setOnClickListener {
            startActivity(Intent(this, CustomerOrderActivity::class.java))
        }

        findViewById<MaterialButton>(R.id.btnLogout).setOnClickListener {
            startActivity(Intent(this, LoginCustomerActivity::class.java))
            finish()  // optional: finish biar ga balik ke dashboard pas back
        }
    }
}