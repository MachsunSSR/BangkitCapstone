package com.bangkit.ambroise.ui.auth

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LifecycleOwner
import com.bangkit.ambroise.R
import com.bangkit.ambroise.databinding.ActivityRegisterBinding
import com.bangkit.ambroise.core.data.Resource
import com.bangkit.ambroise.core.data.remote.request.UserRequest
import com.bangkit.ambroise.util.closeKeyboard
import com.bangkit.ambroise.util.hideLoading
import com.bangkit.ambroise.util.showLoading
import com.bangkit.ambroise.util.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityRegisterBinding? = null
    private val binding get() = _binding!!
    private val lifecycleOwner: LifecycleOwner = this
    private val context: Context = this
    private val authViewModel: AuthViewModel by viewModel()

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
        with(binding) {
            when (v) {
                imgBack -> onBackPressed()
                tvAccountAlready -> onBackPressed()
                btnRegister -> {
                    closeKeyboard()
                    val user = UserRequest(
                        email = editEmail.text.toString(),
                        username = editName.text.toString(),
                        password = editPassword.text.toString()
                    )
                    authViewModel.register(user).observe(lifecycleOwner) {
                        when (it) {
                            is Resource.Loading -> btnRegister.showLoading(lifecycleOwner)
                            is Resource.Success -> {
                                it.data
                                context.showToast("Register Succesfully")
                                finish()
                            }
                            is Resource.Error -> {
                                context.showToast(it.message.orEmpty())
                                btnRegister.hideLoading(R.string.register)
                            }
                        }
                    }
                }
            }
        }
    }
}