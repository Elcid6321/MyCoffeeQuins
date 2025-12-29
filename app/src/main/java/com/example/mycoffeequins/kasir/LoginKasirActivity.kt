package com.example.mycoffeequins.kasir

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R

class LoginKasirActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_kasir)

        val etUsername = findViewById<EditText>(R.id.etKasirUsername)
        val etPassword = findViewById<EditText>(R.id.etKasirPassword)
        val btnLogin = findViewById<Button>(R.id.btnLoginKasir)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            // login dummy (biar aman & gampang dinilai)
            if (username == "kasir" && password == "1234") {
                startActivity(
                    Intent(this, KasirDashboardActivity::class.java)
                )
                finish()
            } else {
                Toast.makeText(
                    this,
                    "Username atau Password salah",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
