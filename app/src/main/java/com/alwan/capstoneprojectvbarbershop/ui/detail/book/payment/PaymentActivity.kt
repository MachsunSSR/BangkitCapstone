package com.alwan.capstoneprojectvbarbershop.ui.detail.book.payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alwan.capstoneprojectvbarbershop.databinding.ActivityPaymentBinding
import com.alwan.capstoneprojectvbarbershop.ui.detail.book.transaction.TransactionActivity

class PaymentActivity : AppCompatActivity() {
    private var _binding: ActivityPaymentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPaymentBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {
        tvCopy.setOnClickListener {
            val transactionIntent = Intent(this@PaymentActivity, TransactionActivity::class.java)
            startActivity(transactionIntent)
            finish()
        }
        imgBack.setOnClickListener{ onBackPressed() }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}