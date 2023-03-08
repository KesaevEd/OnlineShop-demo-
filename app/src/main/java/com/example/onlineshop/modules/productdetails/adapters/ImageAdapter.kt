package com.example.onlineshop.modules.productdetails.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ItemProductPhotoBinding

class ImageAdapter(val iChoosePhoto: IChoosePhoto) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private val differ = AsyncListDiffer(this, ImageListDiffUtilCallback())
    var data: List<String>
        get() = differ.currentList
        set(value) = differ.submitList(value)


    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding by viewBinding(ItemProductPhotoBinding::bind)

        fun bind(imageUrl: String) {
            binding.root.setOnClickListener{iChoosePhoto.choosePhoto(imageUrl)}
            imageUrl.let {
                Glide.with(binding.ivImage)
                    .load(it)
                    .into(binding.ivImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_product_photo, parent, false)
        return ImageViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageUrl = data[position]
        holder.bind(imageUrl)
    }

    private class ImageListDiffUtilCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem.equals(newItem)
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}