package com.example.mycoffeequins.customer

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginCustomerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_customer)

        val etEmail: TextInputEditText = findViewById(R.id.et_email)
        val etPassword: TextInputEditText = findViewById(R.id.et_password)

        val btnSignIn: MaterialButton = findViewById(R.id.btn_sign_in)

        val tvCreateAccount: TextView = findViewById(R.id.tv_create_account)

        btnSignIn.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email dan password wajib diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Ambil data dari SharedPreferences
            val prefs = getSharedPreferences("user_prefs", MODE_PRIVATE)
            val savedEmail = prefs.getString("user_email", "")
            val savedPassword = prefs.getString("user_password", "")

            if (email == savedEmail && password == savedPassword) {
                Toast.makeText(this, "Login berhasil ☕", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, CustomerDashboardActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
            }
        }

        tvCreateAccount.setOnClickListener {
            startActivity(Intent(this, RegisterCustomerActivity::class.java))
        }
    }
}
