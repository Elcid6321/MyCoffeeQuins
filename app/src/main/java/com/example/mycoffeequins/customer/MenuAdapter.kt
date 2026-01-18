package com.example.mycoffeequins.customer

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycoffeequins.R

class MenuAdapter(private val menuList: List<MenuItem>) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivMenuImage: ImageView = itemView.findViewById(R.id.ivMenuImage)
        val tvMenuName: TextView = itemView.findViewById(R.id.tvMenuName)
        val tvMenuDescription: TextView = itemView.findViewById(R.id.tvMenuDescription)
        val tvMenuPrice: TextView = itemView.findViewById(R.id.tvMenuPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = menuList[position]

        holder.ivMenuImage.setImageResource(item.imageRes)
        holder.tvMenuName.text = item.name
        holder.tvMenuDescription.text = item.description
        holder.tvMenuPrice.text = "Rp ${item.price}"

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MenuDetailActivity::class.java)
            intent.putExtra("name", item.name)
            intent.putExtra("desc", item.description)
            intent.putExtra("price", item.price)
            intent.putExtra("image", item.imageRes)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = menuList.size
}