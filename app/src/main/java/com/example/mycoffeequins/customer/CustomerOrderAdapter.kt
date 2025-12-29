package com.example.mycoffeequins.customer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycoffeequins.R

class CustomerOrderAdapter(
    private val orderList: List<OrderItem>
) : RecyclerView.Adapter<CustomerOrderAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvOrderName)
        val tvPrice: TextView = view.findViewById(R.id.tvOrderPrice)
        val tvStatus: TextView = view.findViewById(R.id.tvOrderStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_customer_order, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = orderList[position]
        holder.tvName.text = item.name
        holder.tvPrice.text = "Rp ${item.price}"
        holder.tvStatus.text = item.status
    }

    override fun getItemCount() = orderList.size
}
