package com.example.mycoffeequins.customer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R

class CheckoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val tvTotal = findViewById<TextView>(R.id.tvCheckoutTotal)
        val radioGroup = findViewById<RadioGroup>(R.id.radioPayment)
        val btnPay = findViewById<Button>(R.id.btnPay)
        val btnBack = findViewById<Button>(R.id.btnBackCheckout)

        // Terima total dari Cart
        val total = intent.getIntExtra("total", 0)
        tvTotal.text = "Total Bayar: Rp $total"

        btnPay.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId

            if (selectedId == -1) {
                Toast.makeText(this, "Pilih metode pembayaran", Toast.LENGTH_SHORT).show()
            } else {
                val selectedRadio = findViewById<RadioButton>(selectedId)
                val paymentMethod = selectedRadio.text.toString()

                val intent = Intent(this, OrderSuccessActivity::class.java)
                intent.putExtra("total", total)
                intent.putExtra("payment", paymentMethod)
                startActivity(intent)
                finish()
            }
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}
