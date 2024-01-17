package com.novelitech.tablayoutwithviewpagertwokotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.novelitech.tablayoutwithviewpagertwokotlin.databinding.ItemViewPagerBinding

class ViewPagerAdapter(
    val images: List<Int>
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(val binding: ItemViewPagerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {

        val view = LayoutInflater.from(parent.context)

        val binding = ItemViewPagerBinding.inflate(view, parent, false)

        return ViewPagerViewHolder(binding)
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {

        val currentImage = images[position]

        holder.binding.ivImage.setImageResource(currentImage)
    }
}