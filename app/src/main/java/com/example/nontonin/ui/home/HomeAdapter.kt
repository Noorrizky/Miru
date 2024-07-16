package com.example.nontonin.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nontonin.R

class HomeAdapter(private val items: List<Item>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(item: Item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvItemName: TextView = itemView.findViewById(R.id.tvItemName)
        val tvItemDescription: TextView = itemView.findViewById(R.id.tvItemDescription)
        val ivItemPhoto: ImageView = itemView.findViewById(R.id.ivItemPhoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvItemName.text = item.title
        holder.tvItemDescription.text = item.description
        holder.ivItemPhoto.setImageResource(item.imageResId)
        holder.itemView.setOnClickListener {
            listener.onItemClick(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
