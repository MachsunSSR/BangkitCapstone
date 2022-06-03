package com.alwan.capstoneprojectvbarbershop.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alwan.capstoneprojectvbarbershop.databinding.ItemBookBinding
import com.alwan.capstoneprojectvbarbershop.ui.core.entity.Book
import com.alwan.capstoneprojectvbarbershop.ui.util.loadImage

class BookAdapter : RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    private val books = ArrayList<Book>()

    fun setData(data: List<Book>) {
        books.clear()
        books.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemBookBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(books[position])

    override fun getItemCount() = books.size

    inner class ViewHolder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Book) {
            with(binding) {
                tvAddress.text = item.barber.name
                tvTitle.text = item.barber.name
                imgBarber.loadImage(item.barber.imageUrl)
            }
        }
    }

}