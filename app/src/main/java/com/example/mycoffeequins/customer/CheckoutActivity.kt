package com.example.mycoffeequins.customer

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.text.NumberFormat
import java.util.Locale

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
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        radioCash = findViewById(R.id.radioCash)
        radioQris = findViewById(R.id.radioQris)
        radioEwallet = findViewById(R.id.radioEwallet)

        // ===== TERIMA TOTAL =====
        val total = intent.getIntExtra("total", 0)
        tvTotal.text = "Total Bayar: ${formatRupiah(total)}"

        // ===== RADIO =====
        radioCash.setOnClickListener { selectPayment(radioCash) }
        radioQris.setOnClickListener { selectPayment(radioQris) }
        radioEwallet.setOnClickListener { selectPayment(radioEwallet) }

        // ===== PAY =====
        btnPay.setOnClickListener {
            val selectedPayment = when {
                radioCash.isChecked -> "Cash"
                radioQris.isChecked -> "QRIS"
                radioEwallet.isChecked -> "E-Wallet"
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

        btnBack.setOnClickListener { finish() }

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

    private fun selectPayment(selected: RadioButton) {
        radioCash.isChecked = selected == radioCash
        radioQris.isChecked = selected == radioQris
        radioEwallet.isChecked = selected == radioEwallet
    }

    private fun formatRupiah(amount: Int): String {
        val localeID = Locale("in", "ID")
        val formatter = NumberFormat.getCurrencyInstance(localeID)
        formatter.maximumFractionDigits = 0
        return formatter.format(amount)
    }
}
