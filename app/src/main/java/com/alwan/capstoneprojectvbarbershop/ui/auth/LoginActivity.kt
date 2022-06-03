package com.alwan.capstoneprojectvbarbershop.ui.auth

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.alwan.capstoneprojectvbarbershop.R
import com.alwan.capstoneprojectvbarbershop.databinding.ActivityLoginBinding
import com.alwan.capstoneprojectvbarbershop.ui.MainActivity
import com.github.razir.progressbutton.attachTextChangeAnimator
import com.github.razir.progressbutton.bindProgressButton
import com.github.razir.progressbutton.showProgress

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initView() = with(binding) {
        btnLogin.setOnClickListener(this@LoginActivity)
        tvSignUp.setOnClickListener(this@LoginActivity)
    }

    override fun onClick(v: View?) {
        with(binding) {
            when (v) {
                btnLogin -> {
                    with(btnLogin) {
                        bindProgressButton(this)
                        attachTextChangeAnimator()
                        showProgress {
                            buttonTextRes = R.string.loading
                            progressColor = Color.WHITE
                        }
                        Handler(Looper.getMainLooper()).postDelayed({
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }, 3000)
                    }
                }
                tvSignUp -> {
                    val registerIntent = Intent(this@LoginActivity, RegisterActivity::class.java)
                    startActivity(registerIntent)
                }
                else -> Unit
            }
        }
    }
}