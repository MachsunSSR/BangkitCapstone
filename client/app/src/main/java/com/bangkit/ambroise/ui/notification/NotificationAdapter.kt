package com.bangkit.ambroise.ui.notification

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.ambroise.R
import com.bangkit.ambroise.core.domain.entity.Notification
import com.bangkit.ambroise.databinding.ItemNotificationBinding

class NotificationAdapter : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {
    private val notifications = ArrayList<Notification>()

    fun setData(items: List<Notification>) {
        notifications.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemNotificationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(notifications[position])

    override fun getItemCount() = notifications.size

    inner class ViewHolder(private val binding: ItemNotificationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(notification: Notification) {
            with(binding) {
                tvTitle.text = notification.name
                tvDesc.text = notification.description
                when (notification.type) {
                    0 -> imgNotif.setImageResource(R.drawable.ic_notif_success)
                    1 -> imgNotif.setImageResource(R.drawable.ic_notif_failed)
                    2 -> imgNotif.setImageResource(R.drawable.ic_notif_wallet)
                    else -> imgNotif.setImageResource(R.drawable.placeholder)
                }
            }
        }
    }
}