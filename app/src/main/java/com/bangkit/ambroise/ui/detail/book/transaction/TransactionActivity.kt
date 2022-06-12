package com.bangkit.ambroise.ui.detail.book.transaction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.ambroise.databinding.ActivityTransactionBinding

class TransactionActivity : AppCompatActivity() {
    private var _binding: ActivityTransactionBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {
        btnViewTicket.setOnClickListener {
            val ticketIntent = Intent(this@TransactionActivity, TicketActivity::class.java)
            startActivity(ticketIntent)
            finish()
        }
        imgBack.setOnClickListener { onBackPressed() }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}