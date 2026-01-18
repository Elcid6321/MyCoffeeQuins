package com.example.mycoffeequins.customer

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R
import com.example.mycoffeequins.kasir.LoginKasirActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginCustomerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_customer)

        // Input fields (TextInputEditText di dalam TextInputLayout)
        val etEmail: TextInputEditText = findViewById(R.id.et_email)
        val etPassword: TextInputEditText = findViewById(R.id.et_password)

        // Button Sign In (coklat tua)
        val btnSignIn: MaterialButton = findViewById(R.id.btn_sign_in)

        // Clickable texts (semua TextView sekarang)
        val tvCreateAccount: TextView = findViewById(R.id.tv_create_account)
        val tvLoginKasir: TextView = findViewById(R.id.tv_login_kasir)

        // Login Customer
        btnSignIn.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email dan password wajib diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Langsung login sukses (seperti sebelumnya)
            Toast.makeText(this, "Login berhasil ☕", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CustomerDashboardActivity::class.java)
            startActivity(intent)
            finish()
        }


        // Create account
        tvCreateAccount.setOnClickListener {
            startActivity(Intent(this, RegisterCustomerActivity::class.java))
        }

        // Login sebagai Kasir
        tvLoginKasir.setOnClickListener {
            startActivity(Intent(this, LoginKasirActivity::class.java))
        }
    }
}