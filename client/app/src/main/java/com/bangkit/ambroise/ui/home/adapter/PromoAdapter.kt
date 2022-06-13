package com.bangkit.ambroise.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.ambroise.R
import com.bangkit.ambroise.core.domain.entity.Promo
import com.bangkit.ambroise.databinding.ItemPromoBinding
import com.bangkit.ambroise.util.setMargin


class PromoAdapter : RecyclerView.Adapter<PromoAdapter.ViewHolder>() {
    private val promos = ArrayList<Promo>()

    fun setData(data: List<Promo>) {
        promos.clear()
        promos.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemPromoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(promos[position], position)

    override fun getItemCount() = promos.size

    inner class ViewHolder(private val binding: ItemPromoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(promo: Promo, position: Int) {
            itemView.layoutParams.apply {
                when (position) {
                    0 -> setMargin(32, 16)
                    itemCount - 1 -> setMargin(0, 32)
                    else -> setMargin(0, 16)
                }
            }

            with(binding) {
                tvTitle.text = promo.name
                imgPromo.setImageResource(R.drawable.ic_calendar_promo)
            }
        }
    }
}