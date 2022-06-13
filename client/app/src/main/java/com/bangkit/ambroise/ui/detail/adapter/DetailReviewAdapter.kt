package com.bangkit.ambroise.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.ambroise.core.domain.entity.Review
import com.bangkit.ambroise.databinding.ItemReviewBinding
import com.bangkit.ambroise.util.loadImage

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