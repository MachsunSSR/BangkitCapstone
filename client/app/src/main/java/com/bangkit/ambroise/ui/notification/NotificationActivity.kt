package com.bangkit.ambroise.ui.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.ambroise.databinding.ActivityNotificationBinding
import com.bangkit.ambroise.util.DummyData
import com.bangkit.ambroise.util.MarginItemDecoration

class NotificationActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityNotificationBinding? = null
    private val binding get() = _binding!!
    private val notificationTodayAdapter = NotificationAdapter()
    private val notificationYesterdayAdapter = NotificationAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {
        initRv()
        imgBack.setOnClickListener(this@NotificationActivity)
    }

    private fun initRv() {
        DummyData.provideNotifications().apply {
            notificationTodayAdapter.setData(this)
            notificationYesterdayAdapter.setData(this)
        }

        val decoration = MarginItemDecoration(20)

        with(binding.rvToday) {
            layoutManager = LinearLayoutManager(this@NotificationActivity)
            addItemDecoration(decoration)
            adapter = notificationTodayAdapter
        }

        with(binding.rvYesterday) {
            layoutManager = LinearLayoutManager(this@NotificationActivity)
            addItemDecoration(decoration)
            adapter = notificationTodayAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(v: View?) {
        with(binding) {
            when (v) {
                imgBack -> onBackPressed()
            }
        }
    }
}