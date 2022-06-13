package com.bangkit.ambroise.ui.detail.book.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.ambroise.R
import com.bangkit.ambroise.core.domain.entity.Facility
import com.bangkit.ambroise.databinding.ItemFacilitiesBinding

class GuestFacilitiesAdapter() : RecyclerView.Adapter<GuestFacilitiesAdapter.ViewHolder>() {
    private val facilities = ArrayList<Facility>()
    private lateinit var context: Context

    fun setData(data: List<Facility>) {
        facilities.clear()
        facilities.addAll(data)
        notifyDataSetChanged()
    }

    fun getSelectedData(): List<String> {
        val selectedData = ArrayList<String>()
        facilities.map {
            if (it.isSelected) selectedData.add(it.name)
        }

        return selectedData.toList()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        context = parent.context
        return ViewHolder(
            ItemFacilitiesBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(facilities[position])

    override fun getItemCount() = facilities.size

    inner class ViewHolder(private val binding: ItemFacilitiesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Facility) {
            with(binding.tvFacilities) {
                text = item.name
                setOnClickListener {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (!item.isSelected) {
                            backgroundTintList =
                                context.resources.getColorStateList(
                                    R.color.btn_guest,
                                    context.theme
                                )
                            setTextColor(resources.getColor(R.color.whiter, context.theme))
                        } else {
                            backgroundTintList = null
                            setTextColor(resources.getColor(R.color.black, context.theme))
                        }
                    }
                    item.isSelected = !item.isSelected
                }
            }
        }
    }
}