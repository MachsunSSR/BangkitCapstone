package com.alwan.capstoneprojectvbarbershop.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alwan.capstoneprojectvbarbershop.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding : ActivityRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {
        imgBack.setOnClickListener(this@RegisterActivity)
        tvAccountAlready.setOnClickListener(this@RegisterActivity)
        btnRegister.setOnClickListener(this@RegisterActivity)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(v: View?) {
        with(binding){
            when(v){
                imgBack -> onBackPressed()
                tvAccountAlready -> onBackPressed()
                btnRegister -> finish()
            }
        }
    }
}