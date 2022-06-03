package com.alwan.capstoneprojectvbarbershop.ui.detail.book.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alwan.capstoneprojectvbarbershop.R
import com.alwan.capstoneprojectvbarbershop.databinding.ItemSlotTimeBinding

class SlotTimeAdapter : RecyclerView.Adapter<SlotTimeAdapter.ViewHolder>() {
    private val times = ArrayList<String>()
    private lateinit var context: Context
    private var selectedItemPos = -1
    private var lastItemSelectedPos = -1

    fun setData(items: List<String>) {
        times.clear()
        times.addAll(items)
        notifyDataSetChanged()
    }

    fun getSelectedItem() = times[selectedItemPos]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            ItemSlotTimeBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: SlotTimeAdapter.ViewHolder, position: Int) =
        with(holder) {
            if (position == selectedItemPos) selected() else default()
            bind(times[position])
        }

    override fun getItemCount() = times.size

    inner class ViewHolder(private val binding: ItemSlotTimeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.tvSlotTime.setOnClickListener {
                selectedItemPos = adapterPosition
                lastItemSelectedPos = if (lastItemSelectedPos == -1)
                    selectedItemPos
                else {
                    notifyItemChanged(lastItemSelectedPos)
                    selectedItemPos
                }
                notifyItemChanged(selectedItemPos)
            }
        }

        fun bind(time: String) {
            binding.tvSlotTime.text = time
        }

        fun selected() = with(binding.tvSlotTime) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                backgroundTintList =
                    context.resources.getColorStateList(
                        R.color.primary,
                        context.theme
                    )
                setTextColor(context.resources.getColor(R.color.whiter, context.theme))
            }
        }

        fun default() = with(binding.tvSlotTime) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                backgroundTintList = null
                setTextColor(context.resources.getColor(R.color.black, context.theme))
            }
        }
    }
}
