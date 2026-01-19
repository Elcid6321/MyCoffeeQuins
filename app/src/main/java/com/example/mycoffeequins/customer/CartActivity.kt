package com.example.mycoffeequins.customer

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycoffeequins.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.text.NumberFormat
import java.util.Locale

class CartActivity : AppCompatActivity() {

    // ================= MODEL =================
    data class CartEntry(
        val name: String,
        val price: Int,
        val imageRes: Int,
        val subtitle: String = "Coffee",
        var quantity: Int = 1
    )

    // ================= DATA =================
    private val cartItems = mutableListOf<CartEntry>()

    // ================= VIEW =================
    private lateinit var recyclerCart: RecyclerView
    private lateinit var tvTotal: TextView
    private lateinit var tvTotalItem: TextView
    private lateinit var tvEmpty: TextView
    private lateinit var layoutBottom: View
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        // ================= INIT VIEW =================
        recyclerCart = findViewById(R.id.recyclerCart)
        tvTotal = findViewById(R.id.tvTotalPrice)
        tvTotalItem = findViewById(R.id.tvTotalItem)
        tvEmpty = findViewById(R.id.tvEmptyCart)
        layoutBottom = findViewById(R.id.layoutBottom)
        bottomNavigation = findViewById(R.id.bottomNavigation)

        val btnCheckout = findViewById<Button>(R.id.btnCheckout)
        val btnAddMenu = findViewById<Button>(R.id.btnAddMenu)

        // ================= RECYCLER =================
        recyclerCart.layoutManager = LinearLayoutManager(this)

        // ================= DUMMY DATA =================
        cartItems.addAll(
            listOf(
                CartEntry("Cappuccino", 15000, R.drawable.cappuccino),
                CartEntry("Espresso", 12000, R.drawable.espresso),
                CartEntry("Brownies", 18000, R.drawable.brownies)
            )
        )

        val adapter = CartAdapter()
        recyclerCart.adapter = adapter

        updateTotal()
        checkIfEmpty()

        // ================= BUTTON =================
        btnCheckout.setOnClickListener {
            val total = cartItems.sumOf { it.price * it.quantity }
            val intent = Intent(this, CheckoutActivity::class.java)
            intent.putExtra("total", total)
            startActivity(intent)
        }

        btnAddMenu.setOnClickListener {
            startActivity(Intent(this, MenuListActivity::class.java))
        }

        // ================= BOTTOM NAV (VERSI BARU) =================
        bottomNavigation.selectedItemId = R.id.nav_cart

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.nav_dashboard -> {
                    startActivity(Intent(this, CustomerDashboardActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }

                // ✅ HALAMAN INI
                R.id.nav_cart -> true

                R.id.nav_orders -> {
                    startActivity(Intent(this, CustomerOrderActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }

                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }

                else -> false
            }
        }
    }

    // ================= ADAPTER =================
    inner class CartAdapter : RecyclerView.Adapter<CartViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_cart, parent, false)
            return CartViewHolder(view)
        }

        override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
            val item = cartItems[position]

            holder.tvName.text = item.name
            holder.tvSubtitle.text = item.subtitle
            holder.imgItem.setImageResource(item.imageRes)

            val subtotal = item.price * item.quantity
            holder.tvPrice.text = formatRupiah(subtotal)
            holder.tvQuantity.text = item.quantity.toString()

            // PLUS
            holder.tvPlus.setOnClickListener {
                item.quantity++
                notifyItemChanged(position)
                updateTotal()
            }

            // MINUS
            holder.tvMinus.setOnClickListener {
                if (item.quantity > 1) {
                    item.quantity--
                    notifyItemChanged(position)
                    updateTotal()
                }
            }

            // REMOVE
            holder.tvRemove.setOnClickListener {
                cartItems.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, cartItems.size)
                updateTotal()
                checkIfEmpty()
            }
        }

        override fun getItemCount(): Int = cartItems.size
    }

    // ================= VIEW HOLDER =================
    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvSubtitle: TextView = itemView.findViewById(R.id.tvSubtitle)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val tvQuantity: TextView = itemView.findViewById(R.id.tvQty)
        val tvRemove: TextView = itemView.findViewById(R.id.tvRemove)
        val imgItem: ImageView = itemView.findViewById(R.id.imgItem)
        val tvPlus: TextView = itemView.findViewById(R.id.tvPlus)
        val tvMinus: TextView = itemView.findViewById(R.id.tvMinus)
    }

    // ================= HELPER =================
    private fun formatRupiah(amount: Int): String {
        val localeID = Locale("in", "ID")
        val formatter = NumberFormat.getCurrencyInstance(localeID)
        formatter.maximumFractionDigits = 0
        return formatter.format(amount)
    }

    private fun updateTotal() {
        val total = cartItems.sumOf { it.price * it.quantity }
        val totalItem = cartItems.sumOf { it.quantity }
        tvTotal.text = formatRupiah(total)
        tvTotalItem.text = "Item: $totalItem"
    }

    private fun checkIfEmpty() {
        if (cartItems.isEmpty()) {
            tvEmpty.visibility = View.VISIBLE
            layoutBottom.visibility = View.GONE
        } else {
            tvEmpty.visibility = View.GONE
            layoutBottom.visibility = View.VISIBLE
        }
    }
}
