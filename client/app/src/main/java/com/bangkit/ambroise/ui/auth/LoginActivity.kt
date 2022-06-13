package com.bangkit.ambroise.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.ambroise.R
import com.bangkit.ambroise.core.data.Resource
import com.bangkit.ambroise.core.data.remote.request.LoginRequest
import com.bangkit.ambroise.databinding.ActivityLoginBinding
import com.bangkit.ambroise.ui.MainActivity
import com.bangkit.ambroise.util.closeKeyboard
import com.bangkit.ambroise.util.hideLoading
import com.bangkit.ambroise.util.showLoading
import com.bangkit.ambroise.util.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!
    private val activity = this
    private val authViewModel: AuthViewModel by viewModel()

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
        btnLogin.setOnClickListener(activity)
        tvSignUp.setOnClickListener(activity)
    }

    override fun onClick(v: View?) {
        with(binding) {
            when (v) {
                btnLogin -> {
                    closeKeyboard()
                    val login =
                        LoginRequest(editEmail.text.toString(), editPassword.text.toString())
                    authViewModel.login(login).observe(activity) {
                        when (it) {
                            is Resource.Loading -> btnLogin.showLoading(activity)
                            is Resource.Success -> {
                                activity.showToast("Login Successful")

                                val jenisKelamin = it.data?.user?.jenisKelamin as String?
                                if (jenisKelamin == null) {
                                    val intent = Intent(activity, FirstFormActivity::class.java)
                                    startActivity(intent)
                                } else {
                                    val intent = Intent(activity, MainActivity::class.java)
                                    startActivity(intent)
                                    finishAffinity()
                                }
                                btnLogin.hideLoading(R.string.login)
                            }
                            is Resource.Error -> {
                                activity.showToast(it.message.orEmpty())
                                btnLogin.hideLoading(R.string.login)
                            }
                        }
                    }

                }
                tvSignUp -> {
                    val registerIntent = Intent(activity, RegisterActivity::class.java)
                    startActivity(registerIntent)
                }
                else -> Unit
            }
        }
    }

}