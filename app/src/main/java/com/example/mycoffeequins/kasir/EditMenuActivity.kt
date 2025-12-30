package com.example.mycoffeequins.kasir

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R

class EditMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_menu)

        // View binding manual
        val ivMenu = findViewById<ImageView>(R.id.ivMenuEdit)
        val etName = findViewById<EditText>(R.id.etMenuName)
        val etDesc = findViewById<EditText>(R.id.etMenuDesc)
        val etPrice = findViewById<EditText>(R.id.etMenuPrice)
        val btnSave = findViewById<Button>(R.id.btnSaveMenu)

        // Ambil data dari Intent
        val name = intent.getStringExtra("name")
        val desc = intent.getStringExtra("desc")
        val price = intent.getIntExtra("price", 0)
        val imageRes = intent.getIntExtra("imageRes", 0)

        // Set data ke form
        ivMenu.setImageResource(imageRes)
        etName.setText(name)
        etDesc.setText(desc)
        etPrice.setText(price.toString())

        // Tombol simpan (masih gimik / statis)
        btnSave.setOnClickListener {
            val newName = etName.text.toString().trim()
            val newDesc = etDesc.text.toString().trim()
            val newPrice = etPrice.text.toString().trim()

            if (newName.isEmpty() || newDesc.isEmpty() || newPrice.isEmpty()) {
                Toast.makeText(this, "Semua field wajib diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(
                this,
                "Menu berhasil diperbarui",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
    }
}
