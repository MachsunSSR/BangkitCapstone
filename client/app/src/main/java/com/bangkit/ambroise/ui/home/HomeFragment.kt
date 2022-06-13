package com.bangkit.ambroise.ui.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bangkit.ambroise.core.domain.entity.Barber
import com.bangkit.ambroise.core.domain.entity.Haircut
import com.bangkit.ambroise.databinding.FragmentHomeBinding
import com.bangkit.ambroise.ui.auth.AuthViewModel
import com.bangkit.ambroise.ui.detail.DetailActivity
import com.bangkit.ambroise.ui.home.adapter.GridBarberAdapter
import com.bangkit.ambroise.ui.home.adapter.HaircutAdapter
import com.bangkit.ambroise.ui.home.adapter.PromoAdapter
import com.bangkit.ambroise.ui.message.MessageActivity
import com.bangkit.ambroise.ui.notification.NotificationActivity
import com.bangkit.ambroise.util.DummyData
import com.bangkit.ambroise.util.snapScroll
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(), View.OnClickListener, HaircutAdapter.HaircutClickCallback,
    GridBarberAdapter.BarberClickCallback {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val promoAdapter = PromoAdapter()
    private val gridBarberAdapter = GridBarberAdapter(this)
    private val haircutAdapter = HaircutAdapter(this)
    private val authViewModel: AuthViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initView() = with(binding) {
        initRv()
        initUsername()

        with(vMenuTop) {
            imgBell.setOnClickListener(this@HomeFragment)
            imgBookmark.setOnClickListener(this@HomeFragment)
            imgMessage.setOnClickListener(this@HomeFragment)
        }
        rvBarberTerdekat.setOnClickListener(this@HomeFragment)
    }

    private fun initUsername() {

        authViewModel.getLoginCache().observe(viewLifecycleOwner) {
            val username = it.user.username
            binding.tvHello.text = "Hello, $username"
        }
    }

    private fun initRv() {
        DummyData.apply {
            promoAdapter.setData(providePromos())
            gridBarberAdapter.setData(provideBarber())
            haircutAdapter.setData(provideHaircut())
        }

        with(binding.rvPromo) {
            adapter = promoAdapter
            layoutManager =
                FlexboxLayoutManager(requireContext(), FlexDirection.ROW, FlexWrap.NOWRAP)
            snapScroll()

            val handler = Handler(Looper.getMainLooper()).postDelayed({
                post(Runnable {
                    smoothScrollToPosition(1)
                })
            }, ANIMATION_DELAY)
        }

        with(binding.rvBarberTerdekat) {
            adapter = gridBarberAdapter
            layoutManager =
                FlexboxLayoutManager(requireContext(), FlexDirection.ROW, FlexWrap.NOWRAP)
            snapScroll()
        }

        with(binding.rvTrendingHaircut) {
            adapter = haircutAdapter
            layoutManager =
                FlexboxLayoutManager(requireContext(), FlexDirection.ROW, FlexWrap.NOWRAP)
            snapScroll()
        }
    }

    override fun onClick(v: View?) {
        with(binding) {
            when (v) {
                vMenuTop.imgBell -> {
                    val notificationIntent =
                        Intent(requireActivity(), NotificationActivity::class.java)
                    startActivity(notificationIntent)
                }
                vMenuTop.imgBookmark -> {}
                vMenuTop.imgMessage -> {
                    val messageIntent = Intent(requireActivity(), MessageActivity::class.java)
                    startActivity(messageIntent)
                }
            }
        }
    }

    override fun onClickHaircut(haircut: Haircut) {

    }

    override fun onClickBarber(barber: Barber) {
        val detailIntent = Intent(requireActivity(), DetailActivity::class.java)
        startActivity(detailIntent)
    }

    companion object{
        const val ANIMATION_DELAY = 2000L
    }
}