package com.alwan.capstoneprojectvbarbershop.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alwan.capstoneprojectvbarbershop.databinding.ItemReviewBinding
import com.alwan.capstoneprojectvbarbershop.ui.core.entity.Review
import com.alwan.capstoneprojectvbarbershop.ui.util.loadImage

class DetailReviewAdapter : RecyclerView.Adapter<DetailReviewAdapter.ViewHolder>() {
    private val reviews = ArrayList<Review>()

    fun setData(data: List<Review>) {
        reviews.clear()
        reviews.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemReviewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(reviews[position])

    override fun getItemCount() = reviews.size

    inner class ViewHolder(private val binding: ItemReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Review) {
            with(binding) {
                imgReview.loadImage(item.imageUrl)
                tvUserReview.text = item.name
                tvDateReview.text = item.date
                tvDetailReview.text = item.review
            }
        }
    }
}