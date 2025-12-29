package com.example.mycoffeequins.kasir

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R

class OrderDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)

        val tvCustomer = findViewById<TextView>(R.id.tvCustomer)
        val tvTotal = findViewById<TextView>(R.id.tvTotal)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)
        val btnProcess = findViewById<Button>(R.id.btnProcess)
        val btnFinish = findViewById<Button>(R.id.btnFinish)

        // Ambil data dari Intent
        val customer = intent.getStringExtra("customer")
        val total = intent.getStringExtra("total")
        var status = intent.getStringExtra("status")

        tvCustomer.text = customer
        tvTotal.text = total
        tvStatus.text = status

        btnProcess.setOnClickListener {
            status = "Diproses"
            tvStatus.text = status
            Toast.makeText(this, "Pesanan diproses", Toast.LENGTH_SHORT).show()
        }

        btnFinish.setOnClickListener {
            status = "Selesai"
            tvStatus.text = status
            Toast.makeText(this, "Pesanan selesai", Toast.LENGTH_SHORT).show()
        }
    }
}
