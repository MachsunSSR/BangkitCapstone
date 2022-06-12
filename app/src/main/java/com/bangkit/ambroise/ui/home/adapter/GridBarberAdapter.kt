package com.bangkit.ambroise.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.ambroise.core.domain.entity.Barber
import com.bangkit.ambroise.databinding.ItemGridBarbershopBinding
import com.bangkit.ambroise.util.loadImage
import com.bangkit.ambroise.util.setMargin

class GridBarberAdapter(private val callback: BarberClickCallback) :
    RecyclerView.Adapter<GridBarberAdapter.ViewHolder>() {
    private val items = ArrayList<Barber>()

    fun setData(data: List<Barber>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    interface BarberClickCallback {
        fun onClickBarber(barber: Barber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemGridBarbershopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position], position)

    override fun getItemCount() = items.size

    inner class ViewHolder(private val binding: ItemGridBarbershopBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Barber, position: Int) {
            itemView.layoutParams.apply {
                when (position) {
                    0 -> setMargin(32, 16)
                    itemCount - 1 -> setMargin(0, 32)
                    else -> setMargin(0, 16)
                }
            }

            with(binding) {
                tvTitle.text = item.name
                imgBarber.loadImage(item.imageUrl)

                root.setOnClickListener { callback.onClickBarber(item) }
            }
        }
    }
}