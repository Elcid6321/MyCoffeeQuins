package com.example.mycoffeequins.customer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R

class OrderSuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_success)

        val tvTotal = findViewById<TextView>(R.id.tvSuccessTotal)
        val tvPayment = findViewById<TextView>(R.id.tvSuccessPayment)
        val btnBackHome = findViewById<Button>(R.id.btnBackHome)

        val total = intent.getIntExtra("total", 0)
        val payment = intent.getStringExtra("payment") ?: "-"

        tvTotal.text = "Total Bayar: Rp $total"
        tvPayment.text = "Metode Pembayaran: $payment"

        btnBackHome.setOnClickListener {
            val intent = Intent(this, CustomerDashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
