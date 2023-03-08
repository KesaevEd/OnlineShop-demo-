package com.example.onlineshop.modules.productdetails.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ItemColorBinding
import kotlin.coroutines.coroutineContext

class ColorAdapter : RecyclerView.Adapter<ColorAdapter.ColorViewHolder>() {

    private val differ = AsyncListDiffer(this, ColorListDiffUtilCallback())
    var data: List<String>
        get() = differ.currentList
        set(value) = differ.submitList(value)


    inner class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding by viewBinding(ItemColorBinding::bind)

        fun bind(color: String) {
            color.let {
                binding.clContainer.setCardBackgroundColor(
                    android.graphics.Color.parseColor(
                        it
                    )
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false)
        return ColorViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val color = data[position]
        holder.bind(color)
    }

    private class ColorListDiffUtilCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem.equals(newItem)
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}