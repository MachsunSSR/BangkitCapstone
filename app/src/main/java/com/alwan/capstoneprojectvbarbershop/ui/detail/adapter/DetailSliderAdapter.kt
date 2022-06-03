package com.alwan.capstoneprojectvbarbershop.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.alwan.capstoneprojectvbarbershop.databinding.ItemSlideDetailBinding
import com.alwan.capstoneprojectvbarbershop.ui.util.loadImage
import com.smarteist.autoimageslider.SliderViewAdapter

class DetailSliderAdapter : SliderViewAdapter<DetailSliderAdapter.ViewHolder>() {
    private val imageList = ArrayList<String>()

    fun setData(list: List<String>) {
        imageList.clear()
        imageList.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemSlideDetailBinding) :
        SliderViewAdapter.ViewHolder(binding.root) {
        fun bind(image: String) {
            binding.ivAutoImageSlider.loadImage(image)
        }
    }

    override fun getCount() = imageList.size

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder = ViewHolder(
        ItemSlideDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
        viewHolder.bind(imageList[position])
}