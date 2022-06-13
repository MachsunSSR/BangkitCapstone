package com.bangkit.ambroise.ui.detail.book.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.ambroise.R
import com.bangkit.ambroise.core.domain.entity.GuestCalendar
import com.bangkit.ambroise.databinding.ItemDateBinding

class DateAdapter : RecyclerView.Adapter<DateAdapter.ViewHolder>() {
    private val calendars = ArrayList<GuestCalendar>()
    private lateinit var context: Context
    private var selectedItemPos = -1
    private var lastItemSelectedPos = -1

    fun setData(items: List<GuestCalendar>) {
        calendars.clear()
        calendars.addAll(items)
        notifyDataSetChanged()
    }

    fun getSelectedItem() = calendars[selectedItemPos]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(ItemDateBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: DateAdapter.ViewHolder, position: Int) = with(holder) {
        if (position == selectedItemPos) selectedBg() else defaultBg()
        bind(calendars[position])
    }

    override fun getItemCount() = calendars.size

    inner class ViewHolder(private val binding: ItemDateBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
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

        fun bind(date: GuestCalendar) = with(binding) {
            tvDate.text = date.date
            tvName.text = date.day
        }

        fun selectedBg() = with(binding) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                root.backgroundTintList =
                    context.resources.getColorStateList(
                        R.color.primary,
                        context.theme
                    )
                tvName.setTextColor(context.resources.getColor(R.color.whiter, context.theme))
                tvDate.setTextColor(context.resources.getColor(R.color.whiter, context.theme))
            }
        }


        fun defaultBg() = with(binding) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                root.backgroundTintList = null
                tvName.setTextColor(context.resources.getColor(R.color.black, context.theme))
                tvDate.setTextColor(context.resources.getColor(R.color.black, context.theme))
            }
        }

    }

}