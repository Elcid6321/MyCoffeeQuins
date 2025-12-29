package com.example.mycoffeequins.kasir

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycoffeequins.R

class OrderAdapter(private val orderList: List<Order>) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCustomerName: TextView = itemView.findViewById(R.id.tvCustomerName)
        val tvTotalPrice: TextView = itemView.findViewById(R.id.tvTotalPrice)
        val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orderList[position]

        holder.tvCustomerName.text = order.customerName
        holder.tvTotalPrice.text = order.totalPrice
        holder.tvStatus.text = order.status

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, OrderDetailActivity::class.java)
            intent.putExtra("customer", order.customerName)
            intent.putExtra("total", order.totalPrice)
            intent.putExtra("status", order.status)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = orderList.size
}
