package com.bangkit.ambroise.ui.message

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.ambroise.core.domain.entity.Message
import com.bangkit.ambroise.databinding.ItemMessageBinding
import com.bangkit.ambroise.util.loadImage

class MessageAdapter(private val onItemClick: ((Message) -> Unit)? = null) :
    RecyclerView.Adapter<MessageAdapter.ViewHolder>() {
    private val listMessage = ArrayList<Message>()

    fun setData(items: List<Message>) {
        listMessage.clear()
        listMessage.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MessageAdapter.ViewHolder, position: Int) =
        holder.bind(listMessage[position])

    override fun getItemCount() = listMessage.size

    inner class ViewHolder(private val binding: ItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Message) = with(binding) {
            imgUser.loadImage(item.imageUrl)
            tvMessage.text = item.message
            tvDate.text = item.date
            tvTitle.text = item.name

            root.setOnClickListener { onItemClick?.invoke(item) }
        }
    }
}