package com.example.chi_11_architecture_room_coroutines_retrofit.presentation

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.model.PhotoEntity
import com.example.chi_11_architecture_room_coroutines_retrofit.databinding.ItemPhotoBinding

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {
    private lateinit var photos: List<PhotoEntity>

    fun setList(list: List<PhotoEntity>) {
        this.photos = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photos[position]
        holder.bind(photo)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    inner class PhotoViewHolder(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: PhotoEntity) {
            binding.photographer.text = photo.photographer
            binding.photographer.setBackgroundColor(Color.parseColor(photo.avg_color))

            Glide.with(itemView)
                .load(photo.small_photo_url)
                .transition(DrawableTransitionOptions.withCrossFade(1500))
                .into(binding.photo)
        }
    }
}
