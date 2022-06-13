package com.bangkit.ambroise.ui.camera

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.ambroise.core.domain.entity.Haircut
import com.bangkit.ambroise.databinding.ItemHaircutCameraBinding
import com.bangkit.ambroise.util.loadImage

class HaircutCameraAdapter : RecyclerView.Adapter<HaircutCameraAdapter.ViewHolder>() {
    private val listHaircut = ArrayList<Haircut>()

    fun setData(items: List<Haircut>) {
        listHaircut.clear()
        listHaircut.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ViewHolder(
        ItemHaircutCameraBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: HaircutCameraAdapter.ViewHolder, position: Int) =
        holder.bind(listHaircut[position])

    override fun getItemCount() = listHaircut.size

    inner class ViewHolder(private val binding: ItemHaircutCameraBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Haircut) = with(binding) {
            imgHaircut.loadImage(item.imageUrl)
        }
    }
}