package com.bangkit.ambroise.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.ambroise.core.domain.entity.HistoryBook
import com.bangkit.ambroise.databinding.ItemBookBinding
import com.bangkit.ambroise.util.loadImage

class BookAdapter : RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    private val historyBooks = ArrayList<HistoryBook>()

    fun setData(data: List<HistoryBook>) {
        historyBooks.clear()
        historyBooks.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemBookBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(historyBooks[position])

    override fun getItemCount() = historyBooks.size

    inner class ViewHolder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HistoryBook) {
            with(binding) {
                tvAddress.text = item.barber.name
                tvTitle.text = item.barber.name
                imgBarber.loadImage(item.barber.imageUrl)
            }
        }
    }

}