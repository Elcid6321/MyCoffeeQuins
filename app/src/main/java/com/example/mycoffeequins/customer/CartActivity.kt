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
import java.text.NumberFormat
import java.util.Locale

class CartActivity : AppCompatActivity() {

    // ================= MODEL =================
    data class CartEntry(
        val name: String,
        val price: Int, // RUPIAH
        val imageRes: Int,
        val subtitle: String = "Coffee: cormemove",
        var quantity: Int = 1
    )

    private val cartItems = mutableListOf<CartEntry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val recyclerCart = findViewById<RecyclerView>(R.id.recyclerCart)
        val tvTotal = findViewById<TextView>(R.id.tvTotalPrice)
        val btnCheckout = findViewById<Button>(R.id.btnCheckout)

        recyclerCart.layoutManager = LinearLayoutManager(this)

        // ================= DATA DUMMY (nama + harga + gambar) =================
        cartItems.addAll(
            listOf(
                CartEntry("Cappuccino", 15000, R.drawable.cappuccino),
                CartEntry("Espresso", 12000, R.drawable.espresso),
                CartEntry("Brownies", 18000, R.drawable.brownies)
            )
        )

        // ================= ADAPTER =================
        val adapter = object : RecyclerView.Adapter<CartViewHolder>() {

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

                holder.tvRemove.setOnClickListener {
                    cartItems.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, cartItems.size)
                    updateTotal(tvTotal)
                    checkIfEmpty()
                }
            }

            override fun getItemCount(): Int = cartItems.size
        }

        recyclerCart.adapter = adapter

        updateTotal(tvTotal)
        checkIfEmpty()

        // ================= CHECKOUT =================
        btnCheckout.setOnClickListener {
            val total = cartItems.sumOf { it.price * it.quantity }
            val intent = Intent(this, CheckoutActivity::class.java)
            intent.putExtra("total", total)
            startActivity(intent)
        }
    }

    // ================= VIEW HOLDER =================
    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvSubtitle: TextView = itemView.findViewById(R.id.tvSubtitle)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val tvQuantity: TextView = itemView.findViewById(R.id.tvQty)
        val tvRemove: TextView = itemView.findViewById(R.id.tvRemove)
        val imgItem: ImageView = itemView.findViewById(R.id.imgItem)
    }

    // ================= UTIL =================
    private fun formatRupiah(amount: Int): String {
        val localeID = Locale("in", "ID")
        val formatter = NumberFormat.getCurrencyInstance(localeID)
        formatter.maximumFractionDigits = 0      // <-- ini yang bikin gak ada ,00
        return formatter.format(amount)
    }

    private fun updateTotal(tvTotal: TextView) {
        val total = cartItems.sumOf { it.price * it.quantity }
        tvTotal.text = "Total: ${formatRupiah(total)}"
    }

    private fun checkIfEmpty() {
        val tvEmpty = findViewById<TextView>(R.id.tvEmptyCart)
        tvEmpty.visibility = if (cartItems.isEmpty()) View.VISIBLE else View.GONE
    }
}
