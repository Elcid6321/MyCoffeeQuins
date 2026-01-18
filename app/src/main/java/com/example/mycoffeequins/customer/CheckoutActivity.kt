package com.example.mycoffeequins.customer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R

class CheckoutActivity : AppCompatActivity() {

    private lateinit var radioCash: RadioButton
    private lateinit var radioQris: RadioButton
    private lateinit var radioEwallet: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val tvTotal = findViewById<TextView>(R.id.tvCheckoutTotal)
        val btnPay = findViewById<Button>(R.id.btnPay)
        val btnBack = findViewById<Button>(R.id.btnBackCheckout)

        radioCash = findViewById(R.id.radioCash)
        radioQris = findViewById(R.id.radioQris)
        radioEwallet = findViewById(R.id.radioEwallet)

        // Terima total dari cart
        val total = intent.getIntExtra("total", 0)
        tvTotal.text = "Total Bayar: Rp $total"

        // HANDLE RADIO BUTTON MANUAL
        radioCash.setOnClickListener { selectPayment(radioCash) }
        radioQris.setOnClickListener { selectPayment(radioQris) }
        radioEwallet.setOnClickListener { selectPayment(radioEwallet) }

        btnPay.setOnClickListener {
            val selectedPayment = when {
                radioCash.isChecked -> radioCash.text.toString()
                radioQris.isChecked -> radioQris.text.toString()
                radioEwallet.isChecked -> radioEwallet.text.toString()
                else -> null
            }

            if (selectedPayment == null) {
                Toast.makeText(this, "Pilih metode pembayaran", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, OrderSuccessActivity::class.java)
                intent.putExtra("total", total)
                intent.putExtra("payment", selectedPayment)
                startActivity(intent)
                finish()
            }
        }

        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun selectPayment(selected: RadioButton) {
        radioCash.isChecked = selected == radioCash
        radioQris.isChecked = selected == radioQris
        radioEwallet.isChecked = selected == radioEwallet
    }
}
