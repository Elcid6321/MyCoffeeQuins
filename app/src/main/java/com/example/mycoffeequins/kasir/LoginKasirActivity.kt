package com.example.mycoffeequins.kasir

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginKasirActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_kasir)

        val etUsername: TextInputEditText = findViewById(R.id.et_kasir_username)
        val etPassword: TextInputEditText = findViewById(R.id.et_kasir_password)
        val btnLogin: MaterialButton = findViewById(R.id.btn_login_kasir)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // login dummy (biar aman & gampang dinilai)
            if (username == "kasir" && password == "1234") {
                Toast.makeText(this, "Login kasir berhasil!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, KasirDashboardActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}