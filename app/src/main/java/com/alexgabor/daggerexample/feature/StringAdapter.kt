package com.alexgabor.daggerexample.feature

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alexgabor.daggerexample.databinding.LogItemBinding


class StringAdapter : ListAdapter<String, StringAdapter.ViewHolder>(DiffUtilItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LogItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: LogItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            binding.line.text = item
        }
    }

    private object DiffUtilItemCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem

        override fun areContentsTheSame(oldItem: String, newItem: String) = true
    }
}