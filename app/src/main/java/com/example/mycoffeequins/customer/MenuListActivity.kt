package com.example.mycoffeequins.customer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycoffeequins.R

data class MenuItem(
    val name: String,
    val description: String,
    val price: Int,
    val imageRes: Int
)

class MenuListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_list)

        val rvMenu = findViewById<RecyclerView>(R.id.rvMenu)
        rvMenu.layoutManager = GridLayoutManager(this, 2)  // 2 kolom

        val menuList = listOf(
            MenuItem(
                "Espresso",
                "Kopi hitam pekat dengan rasa bold dan aroma kuat, cocok untuk yang suka kopi murni tanpa tambahan susu. Shot ganda memberikan energi ekstra sepanjang hari.",
                12000,
                R.drawable.espresso
            ),
            MenuItem(
                "Cappuccino",
                "Kombinasi sempurna espresso, susu steamed, dan foam tebal di atasnya. Rasa creamy dan tekstur lembut, favorit para pecinta kopi susu.",
                15000,
                R.drawable.cappuccino
            ),
            MenuItem(
                "Americano",
                "Espresso dicampur air panas, menghasilkan kopi hitam ringan tapi tetap kaya rasa. Cocok untuk yang ingin minum kopi lebih banyak tanpa terlalu pekat.",
                12000,
                R.drawable.americano
            ),
            MenuItem(
                "Chocolate Cake",
                "Cake coklat lembut dengan lapisan ganache coklat kaya rasa, topping krim dan serutan coklat. Manis pas, cocok dipadukan dengan kopi.",
                20000,
                R.drawable.cake
            ),
            MenuItem(
                "Cheesecake",
                "Cheesecake klasik dengan cream cheese premium, base biskuit renyah, dan topping strawberry atau blueberry segar. Tekstur lembut dan creamy.",
                25000,
                R.drawable.cheesecake
            ),
            MenuItem(
                "Muffin",
                "Muffin homemade dengan pilihan coklat chips atau blueberry segar. Lembut di dalam, renyah di luar, cocok untuk camilan ringan.",
                10000,
                R.drawable.muffin
            ),
            MenuItem(
                "Iced Coffee",
                "Kopi dingin segar dengan es batu melimpah, sedikit susu dan sirup karamel opsional. Cocok untuk cuaca panas di Singapura.",
                15000,
                R.drawable.iced_coffee
            ),
            MenuItem(
                "Tea",
                "Pilihan teh hitam, hijau, atau chamomile. Bisa hot atau iced, dengan madu atau lemon untuk rasa lebih segar.",
                10000,
                R.drawable.tea
            ),
            MenuItem(
                "Brownies",
                "Brownies fudgy dengan coklat premium, topping kacang walnut dan saus karamel. Manis legit, tekstur moist dan chewy.",
                18000,
                R.drawable.brownies
            )
        )

        rvMenu.adapter = MenuAdapter(menuList)
    }
}