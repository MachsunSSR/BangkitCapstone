package com.bangkit.ambroise.ui.message

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.ambroise.core.domain.entity.Message
import com.bangkit.ambroise.databinding.ActivityMessageBinding
import com.bangkit.ambroise.util.DummyData
import com.bangkit.ambroise.util.MarginItemDecoration
import com.bangkit.ambroise.util.showToast

class MessageActivity : AppCompatActivity() {
    private var _binding: ActivityMessageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initRv()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initView() = with(binding) {
        imgBack.setOnClickListener { finish() }
    }

    private fun initRv() {
        val messageAdapter = MessageAdapter { onClickMessage(it) }
        messageAdapter.setData(DummyData.provideMessage())

        with(binding.rvMessage) {
            adapter = messageAdapter
            layoutManager = LinearLayoutManager(this@MessageActivity)
            addItemDecoration(MarginItemDecoration(24))
        }
    }

    private fun onClickMessage(item: Message) = showToast("Clicked ${item.name}")
}