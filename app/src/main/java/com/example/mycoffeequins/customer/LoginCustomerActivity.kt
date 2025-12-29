package com.example.mycoffeequins.customer

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R
import com.example.mycoffeequins.kasir.LoginKasirActivity

class LoginCustomerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_customer)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        val btnLogin = findViewById<Button>(R.id.btnLoginCustomer)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val tvLoginKasir = findViewById<TextView>(R.id.tvLoginKasir)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email dan password wajib diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // LANGSUNG LOGIN TANPA CEK EMAIL/PASSWORD
            Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CustomerDashboardActivity::class.java)
            startActivity(intent)
            finish()
        }

        // KE REGISTER
        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterCustomerActivity::class.java))
        }

        // LOGIN KASIR
        tvLoginKasir.setOnClickListener {
            startActivity(Intent(this, LoginKasirActivity::class.java))
        }
    }
}
