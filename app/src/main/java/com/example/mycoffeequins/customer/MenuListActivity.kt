package com.example.mycoffeequins.customer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycoffeequins.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MenuListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_list)

        // ===== RecyclerView =====
        val rvMenu = findViewById<RecyclerView>(R.id.rvMenu)
        rvMenu.layoutManager = GridLayoutManager(this, 2)

        val menuList = listOf(
            MenuItem(
                "Espresso",
                "Espresso klasik dengan cita rasa kopi yang kuat dan pekat. Diseduh dari biji kopi pilihan yang digiling halus, menghasilkan aroma tajam dan rasa pahit khas yang seimbang. Cocok untuk penikmat kopi sejati yang ingin merasakan karakter asli kopi tanpa campuran apa pun.",
                12000,
                R.drawable.espresso
            ),
            MenuItem(
                "Cappuccino",
                "Perpaduan sempurna antara espresso, susu panas, dan foam lembut di atasnya. Cappuccino ini memiliki rasa creamy dengan sentuhan kopi yang tetap terasa kuat. Sangat pas dinikmati di pagi hari atau saat santai bersama teman.",
                15000,
                R.drawable.cappuccino
            ),
            MenuItem(
                "Americano",
                "Americano adalah espresso yang dicampur dengan air panas sehingga menghasilkan kopi hitam dengan rasa lebih ringan. Aroma kopinya tetap kuat namun lebih smooth, cocok bagi kamu yang ingin menikmati kopi hitam tanpa rasa terlalu pahit.",
                12000,
                R.drawable.americano
            ),
            MenuItem(
                "Chocolate Cake",
                "Chocolate cake lembut dengan rasa coklat yang kaya dan manis yang pas. Dibuat dari bahan berkualitas, menghasilkan tekstur moist dan rasa coklat yang lumer di mulut. Pilihan sempurna untuk menemani waktu ngopi kamu.",
                20000,
                R.drawable.cake
            ),
            MenuItem(
                "Cheesecake",
                "Cheesecake dengan tekstur lembut dan creamy, dipadukan dengan rasa keju yang ringan dan tidak terlalu asam. Setiap gigitan memberikan sensasi lembut yang memanjakan lidah, cocok untuk pencinta dessert premium.",
                25000,
                R.drawable.cheesecake
            ),
            MenuItem(
                "Muffin",
                "Muffin homemade yang dipanggang segar setiap hari dengan tekstur empuk dan rasa manis yang seimbang. Cocok sebagai camilan ringan atau teman minum kopi di waktu santai.",
                10000,
                R.drawable.muffin
            ),
            MenuItem(
                "Iced Coffee",
                "Kopi dingin yang menyegarkan dengan perpaduan rasa kopi yang kuat dan es batu yang pas. Cocok diminum saat cuaca panas atau ketika ingin menikmati kopi dengan sensasi segar.",
                15000,
                R.drawable.iced_coffee
            ),
            MenuItem(
                "Tea",
                "Teh pilihan yang disajikan dalam keadaan panas atau dingin sesuai selera. Memiliki rasa yang ringan dan menyegarkan, cocok untuk kamu yang ingin minuman non-kopi namun tetap nikmat.",
                10000,
                R.drawable.tea
            ),
            MenuItem(
                "Brownies",
                "Brownies coklat dengan tekstur fudgy dan rasa coklat yang intens. Manisnya pas, lembut di dalam namun tetap padat, sangat cocok dipadukan dengan secangkir kopi atau teh.",
                18000,
                R.drawable.brownies
            )
        )


        rvMenu.adapter = MenuAdapter(menuList)

        // ===== Bottom Navigation =====
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav.selectedItemId = R.id.nav_dashboard   // atau nav_menu kalau kamu mau tambah item menu

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.nav_dashboard -> {
                    startActivity(Intent(this, CustomerDashboardActivity::class.java))
                    finish()
                    true
                }

                R.id.nav_cart -> {
                    startActivity(Intent(this, CartActivity::class.java))
                    finish()
                    true
                }

                R.id.nav_orders -> {
                    startActivity(Intent(this, CustomerOrderActivity::class.java))
                    finish()
                    true
                }

                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    finish()
                    true
                }

                else -> false
            }
        }
    }
}
