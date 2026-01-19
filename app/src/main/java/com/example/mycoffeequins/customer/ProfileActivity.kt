package com.example.mycoffeequins.customer

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.mycoffeequins.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {

    companion object {
        private const val PICK_IMAGE_REQUEST = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // ===== INIT VIEW =====
        val imgProfile: ImageView = findViewById(R.id.imgProfile)
        val tvName: TextView = findViewById(R.id.tvName)
        val tvEmail: TextView = findViewById(R.id.tvEmail)
        val tvPhone: TextView = findViewById(R.id.tvPhone)
        val tvBio: TextView = findViewById(R.id.tvBio)

        val tvEditPhoto: LinearLayout = findViewById(R.id.tvEditPhoto)
        val tvLogout: LinearLayout = findViewById(R.id.tvLogout)
        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavigation)

        // ===== SET ACTIVE NAV =====
        bottomNav.selectedItemId = R.id.nav_profile

        // ===== SHARED PREF =====
        val prefs = getSharedPreferences("user_prefs", MODE_PRIVATE)

        // ===== LOAD DATA =====
        tvName.text = prefs.getString("user_name", "Your Name")
        tvEmail.text = prefs.getString("user_email", "email@example.com")
        tvPhone.text = prefs.getString("user_phone", "+62 xxxx")
        tvBio.text = prefs.getString("user_bio", "Bio user...")

        // ===== EDIT NAME =====
        tvName.setOnClickListener {
            showEditDialog("Edit Name", tvName.text.toString()) { newValue ->
                tvName.text = newValue
                prefs.edit().putString("user_name", newValue).apply()
            }
        }

        // ===== EDIT PHONE =====
        tvPhone.setOnClickListener {
            showEditDialog("Edit Phone", tvPhone.text.toString()) { newValue ->
                tvPhone.text = newValue
                prefs.edit().putString("user_phone", newValue).apply()
            }
        }

        // ===== EDIT BIO =====
        tvBio.setOnClickListener {
            showEditDialog("Edit Bio", tvBio.text.toString()) { newValue ->
                tvBio.text = newValue
                prefs.edit().putString("user_bio", newValue).apply()
            }
        }

        // ===== EDIT PHOTO =====
        tvEditPhoto.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        // ===== LOGOUT =====
        tvLogout.setOnClickListener {
            prefs.edit().clear().apply()
            Toast.makeText(this, "Logout berhasil", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginCustomerActivity::class.java))
            finish()
        }

        // ===== BOTTOM NAV =====
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.nav_dashboard -> {
                    startActivity(Intent(this, CustomerDashboardActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }

                R.id.nav_cart -> {
                    startActivity(Intent(this, CartActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }

                R.id.nav_orders -> {
                    startActivity(Intent(this, CustomerOrderActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }

                R.id.nav_profile -> true

                else -> false
            }
        }
    }

    // ===== DIALOG EDIT =====
    private fun showEditDialog(
        title: String,
        currentValue: String,
        onSave: (String) -> Unit
    ) {
        val builder = android.app.AlertDialog.Builder(this)
        builder.setTitle(title)

        val input = EditText(this)
        input.setText(currentValue)
        input.setSelection(currentValue.length)
        builder.setView(input)

        builder.setPositiveButton("Simpan") { dialog, _ ->
            val newValue = input.text.toString().trim()
            if (newValue.isNotEmpty()) {
                onSave(newValue)
            }
            dialog.dismiss()
        }

        builder.setNegativeButton("Batal") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }

    // ===== RESULT IMAGE =====
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK) {
            val uri = data?.data
            if (uri != null) {
                findViewById<ImageView>(R.id.imgProfile).setImageURI(uri)
                Toast.makeText(this, "Foto berhasil diubah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
