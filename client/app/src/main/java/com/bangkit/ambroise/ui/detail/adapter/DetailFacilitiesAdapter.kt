package com.bangkit.ambroise.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.ambroise.databinding.ItemFacilitiesBinding

class DetailFacilitiesAdapter(private val callback : FacilitiesClickCallback) : RecyclerView.Adapter<DetailFacilitiesAdapter.ViewHolder>() {
    private val facilities = ArrayList<String>()

    fun setData(data: List<String>) {
        facilities.clear()
        facilities.addAll(data)
        notifyDataSetChanged()
    }

    interface FacilitiesClickCallback{
        fun onClickFacilities(facility: String)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder =
        ViewHolder(
            ItemFacilitiesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(facilities[position])

    override fun getItemCount() = facilities.size

    inner class ViewHolder(private val binding: ItemFacilitiesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            with(binding.tvFacilities) {
                text = item
                setOnClickListener{ callback.onClickFacilities(item) }
            }
        }
    }
}