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

        val ivMenu = findViewById<ImageView>(R.id.ivMenuEdit)
        val etName = findViewById<EditText>(R.id.etMenuName)
        val etPrice = findViewById<EditText>(R.id.etMenuPrice)
        val btnSave = findViewById<Button>(R.id.btnSaveMenu)

        // Terima data dari Intent
        val name = intent.getStringExtra("name")
        val price = intent.getIntExtra("price", 0)
        val imageRes = intent.getIntExtra("imageRes", 0)

        ivMenu.setImageResource(imageRes)
        etName.setText(name)
        etPrice.setText(price.toString())

        btnSave.setOnClickListener {
            Toast.makeText(
                this,
                "Menu berhasil diperbarui",
                Toast.LENGTH_SHORT
            ).show()
            finish()
        }
    }
}
