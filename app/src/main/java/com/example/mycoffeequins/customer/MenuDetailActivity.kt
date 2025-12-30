package com.example.mycoffeequins.customer

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R

class MenuDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_detail)

        val imgMenu = findViewById<ImageView>(R.id.imgDetailMenu)
        val tvName = findViewById<TextView>(R.id.tvDetailName)
        val tvDesc = findViewById<TextView>(R.id.tvDetailDesc)
        val tvPrice = findViewById<TextView>(R.id.tvDetailPrice)
        val btnAdd = findViewById<Button>(R.id.btnAddCart)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val name = intent.getStringExtra("name") ?: ""
        val desc = intent.getStringExtra("desc") ?: ""
        val price = intent.getIntExtra("price", 0)
        val image = intent.getIntExtra("image", 0)

        tvName.text = name
        tvDesc.text = desc
        tvPrice.text = "Rp $price"
        imgMenu.setImageResource(image)

        btnAdd.setOnClickListener {
            Toast.makeText(this, "$name ditambahkan ke keranjang", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, CartActivity::class.java))
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}
