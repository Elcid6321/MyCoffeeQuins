package com.example.mycoffeequins.customer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycoffeequins.R
import java.text.NumberFormat
import java.util.Locale

class CustomerOrderAdapter(
    private val orderList: List<OrderItem>
) : RecyclerView.Adapter<CustomerOrderAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgOrder: ImageView = view.findViewById(R.id.imgOrder)
        val tvName: TextView = view.findViewById(R.id.tvOrderName)
        val tvSubtitle: TextView = view.findViewById(R.id.tvOrderSubtitle)
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
        holder.imgOrder.setImageResource(item.imageRes)
        holder.tvName.text = item.name
        holder.tvSubtitle.text = "Qty ${item.quantity}"
        holder.tvPrice.text = formatRupiah(item.price)
        holder.tvStatus.text = item.status
    }

    override fun getItemCount() = orderList.size

    private fun formatRupiah(amount: Int): String {
        val localeID = Locale("in", "ID")
        val formatter = NumberFormat.getCurrencyInstance(localeID)
        formatter.maximumFractionDigits = 0
        return formatter.format(amount)
    }
}
