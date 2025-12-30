package com.example.mycoffeequins.kasir

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycoffeequins.R
import com.example.mycoffeequins.customer.MenuItem

class ManageMenuAdapter(
    private val menuList: List<MenuItem>
) : RecyclerView.Adapter<ManageMenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivMenu: ImageView = itemView.findViewById(R.id.ivMenu)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = menuList[position]

        holder.tvName.text = item.name
        holder.tvPrice.text = "Rp ${item.price}"
        holder.ivMenu.setImageResource(item.imageRes)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, EditMenuActivity::class.java)
            intent.putExtra("name", item.name)
            intent.putExtra("price", item.price)
            intent.putExtra("desc", item.description)
            intent.putExtra("imageRes", item.imageRes)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = menuList.size
}
