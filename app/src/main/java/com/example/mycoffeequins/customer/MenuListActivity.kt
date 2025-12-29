package com.example.mycoffeequins.customer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycoffeequins.R

class MenuListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_list)

        val rvMenu = findViewById<RecyclerView>(R.id.rvMenu)
        rvMenu.layoutManager = LinearLayoutManager(this)

        val menuList = listOf(
            MenuItem("Espresso", "Kopi hitam nikmat", 12000, R.drawable.espresso),
            MenuItem("Cappuccino", "Kopi susu berbusa", 15000, R.drawable.cappuccino),
            MenuItem("Americano", "Kopi hitam ringan", 12000, R.drawable.americano),
            MenuItem("Chocolate Cake", "Cake coklat lembut", 20000, R.drawable.cake),
            MenuItem("Cheesecake", "Cheese lembut manis", 25000, R.drawable.cheesecake),
            MenuItem("Muffin", "Muffin coklat atau blueberry", 10000, R.drawable.muffin),
            MenuItem("Iced Coffee", "Kopi dingin segar", 15000, R.drawable.iced_coffee),
            MenuItem("Tea", "Teh panas atau dingin", 10000, R.drawable.tea),
            MenuItem("Brownies", "Brownies manis", 18000, R.drawable.brownies)
        )


        rvMenu.adapter = MenuAdapter(menuList)
    }
}

