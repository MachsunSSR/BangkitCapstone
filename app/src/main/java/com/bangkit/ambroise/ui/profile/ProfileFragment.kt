package com.bangkit.ambroise.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bangkit.ambroise.databinding.FragmentProfileBinding
import com.bangkit.ambroise.ui.auth.AuthViewModel
import com.bangkit.ambroise.ui.auth.LoginActivity
import com.bangkit.ambroise.util.DummyData
import com.bangkit.ambroise.util.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val fragment = this
    private val authViewModel: AuthViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initProfile()
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initView() = with(binding) {
        imgUser.loadImage(DummyData.provideImage()[0])
        tvAbout.setOnClickListener(fragment)
        tvEditProfile.setOnClickListener(fragment)
        tvSetting.setOnClickListener(fragment)
        tvHelpCenter.setOnClickListener(fragment)
        tvChangePassword.setOnClickListener(fragment)
        tvBankInformation.setOnClickListener(fragment)
        tvUserName.setOnClickListener(fragment)
        tvLogout.setOnClickListener(fragment)
    }

    private fun initProfile() = with(binding){
        authViewModel.getLoginCache().observe(viewLifecycleOwner){
            tvUserName.text = it.user.username
        }
    }

    override fun onClick(v: View?) {
        with(binding) {
            when (v) {
                tvAbout -> navigate()
                tvEditProfile -> {}
                tvSetting -> {}
                tvHelpCenter -> {}
                tvChangePassword -> {}
                tvBankInformation -> {}
                tvUserName -> {}
                tvLogout -> logout()
                else -> return
            }
        }
    }

    private fun logout() {
        authViewModel.logout()
        val loginIntent = Intent(requireActivity(), LoginActivity::class.java)
        startActivity(loginIntent)
        requireActivity().finishAffinity()
    }

    private fun navigate() {

    }
}