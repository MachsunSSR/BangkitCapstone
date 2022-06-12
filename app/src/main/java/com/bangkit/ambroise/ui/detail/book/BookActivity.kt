package com.bangkit.ambroise.ui.detail.book

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bangkit.ambroise.R
import com.bangkit.ambroise.databinding.ActivityBookBinding
import com.bangkit.ambroise.ui.detail.book.payment.PaymentActivity
import com.bangkit.ambroise.ui.detail.book.payment.SelectPaymentFragment

class BookActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityBookBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityBookBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initView() = with(binding) {
        imgBack.setOnClickListener(this@BookActivity)
        btnNext.setOnClickListener(this@BookActivity)
    }

    private fun navigate() {
        val navHost: Fragment? =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
        val navController = navHost?.findNavController()

        when (navHost?.childFragmentManager?.fragments?.last()) {
            is BookServiceFragment -> {
                navController?.navigate(R.id.action_bookServiceFragment_to_bookDateFragment)
                binding.imgProgress.setImageResource(R.drawable.progress_book_2)
            }
            is BookDateFragment -> {
                navController?.navigate(R.id.action_bookDateFragment_to_bookConfirmFragment)
                binding.imgProgress.setImageResource(R.drawable.progress_book_3)
            }
            is BookConfirmFragment -> {
                navController?.navigate(R.id.action_bookConfirmFragment_to_selectPaymentFragment)
            }
            is SelectPaymentFragment -> {
                val paymentIntent = Intent(this, PaymentActivity::class.java)
                startActivity(paymentIntent)
            }
        }
    }

    override fun onClick(v: View?) {
        with(binding) {
            when (v) {
                btnNext -> navigate()
                imgBack -> finish()
            }
        }
    }

    override fun onBackPressed() {
        val navHost: Fragment? =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView)

        when (navHost?.childFragmentManager?.fragments?.last()) {
            is BookDateFragment -> binding.imgProgress.setImageResource(R.drawable.progress_book_1)
            is BookConfirmFragment -> binding.imgProgress.setImageResource(R.drawable.progress_book_2)
        }

        super.onBackPressed()
    }
}
