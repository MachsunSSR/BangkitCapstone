package com.bangkit.ambroise.ui.detail.book.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.ambroise.R
import com.bangkit.ambroise.core.domain.entity.PaymentMethod
import com.bangkit.ambroise.databinding.ItemMethodPaymentBinding
import com.bangkit.ambroise.util.loadImage

class PaymentMethodAdapter : RecyclerView.Adapter<PaymentMethodAdapter.ViewHolder>() {
    private val paymentMethods = ArrayList<PaymentMethod>()
    private var selectedItemPos = -1
    private var lastItemSelectedPos = -1

    fun setData(items: List<PaymentMethod>) {
        paymentMethods.clear()
        paymentMethods.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemMethodPaymentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = with(holder) {
        if (position == selectedItemPos) selected() else default()
        bind(paymentMethods[position])
    }


    override fun getItemCount() = paymentMethods.size

    inner class ViewHolder(private val binding: ItemMethodPaymentBinding) :
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

        fun bind(paymentMethod: PaymentMethod) {
            binding.imgPayment.loadImage(paymentMethod.imageUrl)
        }

        fun selected() = with(binding) {
            radio.setImageResource(R.drawable.ic_radio_selected)
        }


        fun default() = with(binding) {
            radio.setImageResource(R.drawable.ic_radio_unselected)
        }
    }
}