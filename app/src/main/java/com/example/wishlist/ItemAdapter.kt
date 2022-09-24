package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items: MutableList<Item>): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemNameTextView: TextView
        val itemPriceTextView: TextView
        val itemURLTextView: TextView

        init {
            itemNameTextView = itemView.findViewById<TextView>(R.id.itemName)
            itemPriceTextView = itemView.findViewById<TextView>(R.id.itemPrice)
            itemURLTextView = itemView.findViewById<TextView>(R.id.itemURL)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.item, parent, false)

        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)
        holder.itemNameTextView.text = item.item
        holder.itemPriceTextView.text = item.price
        holder.itemURLTextView.text = item.url
    }

    override fun getItemCount(): Int {
        return items.size
    }
}