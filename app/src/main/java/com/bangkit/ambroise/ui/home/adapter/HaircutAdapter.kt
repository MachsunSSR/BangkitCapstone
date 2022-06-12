package com.bangkit.ambroise.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.ambroise.core.domain.entity.Haircut
import com.bangkit.ambroise.databinding.ItemHaircutBinding
import com.bangkit.ambroise.util.loadImage
import com.bangkit.ambroise.util.setMargin

class HaircutAdapter(private val callback: HaircutClickCallback) :
    RecyclerView.Adapter<HaircutAdapter.ViewHolder>() {
    private val haircuts = ArrayList<Haircut>()

    fun setData(items: List<Haircut>) {
        haircuts.clear()
        haircuts.addAll(items)
        notifyDataSetChanged()
    }

    interface HaircutClickCallback {
        fun onClickHaircut(haircut: Haircut)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemHaircutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: HaircutAdapter.ViewHolder, position: Int) =
        holder.bind(haircuts[position], position)

    override fun getItemCount() = haircuts.size

    inner class ViewHolder(private val binding: ItemHaircutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Haircut, position: Int) {
            itemView.layoutParams.apply {
                when (position) {
                    0 -> setMargin(32, 16)
                    itemCount - 1 -> setMargin(0, 32)
                    else -> setMargin(0, 16)
                }
            }

            with(binding) {
                tvTitle.text = item.name
                tvDesc.text = item.desc
                imgHaircut.loadImage(item.imageUrl)

                root.setOnClickListener { callback.onClickHaircut(item) }
            }
        }
    }

}