package com.bangkit.ambroise.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.bangkit.ambroise.R
import com.bangkit.ambroise.databinding.ActivitySplashBinding
import com.bangkit.ambroise.ui.auth.AuthViewModel
import com.bangkit.ambroise.ui.auth.LoginActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {
    private var _binding: ActivitySplashBinding? = null
    private val binding get() = _binding!!
    private val authViewModel: AuthViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_splash)

        initSplash()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initSplash() = Handler(Looper.getMainLooper()).postDelayed({
        authViewModel.getLoginCache().observe(this) {
            val intent = if (it.token.isNotEmpty()) {
                Intent(this, MainActivity::class.java)
            } else {
                Intent(this, LoginActivity::class.java)
            }

            startActivity(intent)
            finish()
        }

    }, SPLASH_DELAY)


    companion object {
        private const val SPLASH_DELAY = 2000L
    }
}