package com.bangkit.ambroise.ui.auth

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.ambroise.R
import com.bangkit.ambroise.core.data.Resource
import com.bangkit.ambroise.core.data.remote.request.UserRequest
import com.bangkit.ambroise.databinding.ActivityFirstFormBinding
import com.bangkit.ambroise.ui.MainActivity
import com.bangkit.ambroise.util.closeKeyboard
import com.bangkit.ambroise.util.hideLoading
import com.bangkit.ambroise.util.showLoading
import com.bangkit.ambroise.util.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Calendar


class FirstFormActivity : AppCompatActivity() {
    private var _binding: ActivityFirstFormBinding? = null
    private val binding get() = _binding!!
    private val authViewModel: AuthViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFirstFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpinner()
        initView()
    }

    private fun setupSpinner() {
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        arrayAdapter.addAll(listOf("Male", "Female"))
        binding.editGender.setAdapter(arrayAdapter)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initView() = with(binding) {
        imgBack.setOnClickListener { onBackPressed() }
        editDate.setOnClickListener { showDatePicker() }
        editGender.setOnClickListener { editGender.showDropDown() }
        btnUpdate.setOnClickListener {
            closeKeyboard()
            val mainIntent = Intent(this@FirstFormActivity, MainActivity::class.java)
            startActivity(mainIntent)
            finishAffinity()
//            Coming Soon
//            val newUser = UserRequest(
//                jenisKelamin = editGender.text.toString(),
//                noTelp = editPhone.text.toString(),
//                username = editName.text.toString()
//            )
//
//            authViewModel.getLoginCache().observe(this@FirstFormActivity) { cache ->
//                authViewModel.updateUser(cache.token, cache.user.id, newUser)
//                    .observe(this@FirstFormActivity) {
//                        when (it) {
//                            is Resource.Loading -> btnUpdate.showLoading(this@FirstFormActivity)
//                            is Resource.Success -> {
//                                val mainIntent =
//                                    Intent(this@FirstFormActivity, MainActivity::class.java)
//                                startActivity(mainIntent)
//                                finishAffinity()
//                            }
//                            is Resource.Error -> {
//                                btnUpdate.hideLoading(R.string.update)
//                                showToast(it.message.toString())
//                            }
//                        }
//                    }
//            }
        }
    }

    private fun showDatePicker() {
        val calendar: Calendar = Calendar.getInstance()
        val mYear = calendar.get(Calendar.YEAR)
        val mMonth = calendar.get(Calendar.MONTH)
        val mDay = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val date = "$dayOfMonth / ${(month + 1)} / $year"
                binding.editDate.setText(date)
            },
            mYear,
            mMonth,
            mDay
        )
        datePickerDialog.show()
    }

    override fun onBackPressed() {
        authViewModel.logout()
        finish()
    }
}