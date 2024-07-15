package com.example.nontonin.ui.search

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nontonin.databinding.ItemSearchBinding
import com.example.nontonin.ui.activity.ActivityDetails

class SearchAdapter(private val items: List<SearchItem>) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    inner class SearchViewHolder(private val binding: ItemSearchBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SearchItem) {
            binding.ivItemPhoto.setImageResource(item.photoResId)
            binding.tvItemName.text = item.name
            binding.tvItemDescription.text = item.description

            binding.root.setOnClickListener {
                val context = binding.root.context
                val intent = Intent(context, ActivityDetails::class.java).apply {
                    putExtra(ActivityDetails.EXTRA_THUMBNAIL, item.photoResId)
                    putExtra(ActivityDetails.EXTRA_TITLE, item.name)
                    putExtra(ActivityDetails.EXTRA_RELEASE_DATE, item.releaseDate)
                    putExtra(ActivityDetails.EXTRA_SYNOPSIS, item.description)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
