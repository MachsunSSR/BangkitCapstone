package com.alwan.capstoneprojectvbarbershop.ui.detail.book.transaction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alwan.capstoneprojectvbarbershop.databinding.ActivityTicketBinding
import com.alwan.capstoneprojectvbarbershop.ui.MainActivity

class TicketActivity : AppCompatActivity() {
    private var _binding: ActivityTicketBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityTicketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initView() = with(binding) {
        imgBack.setOnClickListener { onBackPressed() }
        btnDownloadTicket.setOnClickListener {
            val mainIntent = Intent(this@TicketActivity, MainActivity::class.java)
            startActivity(mainIntent)
            finishAffinity()
        }
    }
}