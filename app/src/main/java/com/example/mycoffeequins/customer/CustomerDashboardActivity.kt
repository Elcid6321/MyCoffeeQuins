package com.example.mycoffeequins.customer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.mycoffeequins.R

class CustomerDashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_dashboard)

        val cardMenu = findViewById<CardView>(R.id.cardMenu)
        val cardCart = findViewById<CardView>(R.id.cardCart)
        val cardOrders = findViewById<CardView>(R.id.cardOrders)
        val cardLogout = findViewById<CardView>(R.id.cardLogout)

        cardMenu.setOnClickListener {
            startActivity(Intent(this, MenuListActivity::class.java))
        }

        cardCart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        cardOrders.setOnClickListener {
            startActivity(
                Intent(this, CustomerOrderActivity::class.java)
            )
        }

        cardLogout.setOnClickListener {
            startActivity(
                Intent(this, LoginCustomerActivity::class.java)
            )
        }
    }
}
