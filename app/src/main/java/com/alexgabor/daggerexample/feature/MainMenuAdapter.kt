package com.alexgabor.daggerexample.feature

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alexgabor.daggerexample.databinding.MainMenuItemBinding
import com.alexgabor.daggerexample.util.ViewHolderListener

typealias MainMenuAdapterListener = (MainMenuAdapter.Item) -> Unit

class MainMenuAdapter : ListAdapter<MainMenuAdapter.Item, MainMenuAdapter.ViewHolder>(DiffUtilItemCallback) {

    private var clickListener: MainMenuAdapterListener? = null
    private val viewHolderListener: ViewHolderListener = { clickListener?.invoke(getItem(it)) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(MainMenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false), viewHolderListener)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun setClickListener(adapterListener: MainMenuAdapterListener) {
        clickListener = adapterListener
    }

    data class Item(val title: String, val description: String, val activity: Class<out AppCompatActivity>)

    class ViewHolder(private val binding: MainMenuItemBinding, listener: ViewHolderListener) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                listener(adapterPosition)
            }
        }

        fun bind(item: Item) {
            binding.title.text = item.title
            binding.description.text = item.description
        }
    }

    private object DiffUtilItemCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Item, newItem: Item) = true
    }
}