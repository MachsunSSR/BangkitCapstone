package com.bangkit.ambroise.ui.discover

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.ambroise.core.domain.entity.Barber
import com.bangkit.ambroise.databinding.ItemListBarbershopBinding
import com.bangkit.ambroise.util.loadImage

class DiscoverAdapter(private val onItemClick: (View, Barber) -> Unit) :
    RecyclerView.Adapter<DiscoverAdapter.ViewHolder>() {
    private val listBarber = ArrayList<Barber>()

    fun setData(items: List<Barber>) {
        listBarber.clear()
        listBarber.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemListBarbershopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: DiscoverAdapter.ViewHolder, position: Int) =
        holder.bind(listBarber[position])

    override fun getItemCount() = listBarber.size

    inner class ViewHolder(private val binding: ItemListBarbershopBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Barber) = with(binding){
            imgNotif.loadImage(item.imageUrl)
            tvAddress.text = item.address
            tvTitle.text = item.name
            tvRating.text = item.rating.toString()

            imgBookmark.setOnClickListener {
                onItemClick.invoke(it, item)
            }
            root.setOnClickListener{
                onItemClick.invoke(it, item)
            }
        }
    }
}