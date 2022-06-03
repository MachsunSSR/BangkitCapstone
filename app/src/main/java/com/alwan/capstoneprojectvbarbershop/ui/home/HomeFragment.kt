package com.alwan.capstoneprojectvbarbershop.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.alwan.capstoneprojectvbarbershop.databinding.FragmentHomeBinding
import com.alwan.capstoneprojectvbarbershop.ui.core.entity.Barber
import com.alwan.capstoneprojectvbarbershop.ui.core.entity.Haircut
import com.alwan.capstoneprojectvbarbershop.ui.detail.DetailActivity
import com.alwan.capstoneprojectvbarbershop.ui.home.adapter.GridBarberAdapter
import com.alwan.capstoneprojectvbarbershop.ui.home.adapter.HaircutAdapter
import com.alwan.capstoneprojectvbarbershop.ui.home.adapter.PromoAdapter
import com.alwan.capstoneprojectvbarbershop.ui.notification.NotificationActivity
import com.alwan.capstoneprojectvbarbershop.ui.util.DummyData
import com.alwan.capstoneprojectvbarbershop.ui.util.MarginItemDecoration
import com.alwan.capstoneprojectvbarbershop.ui.util.snapScroll
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager

class HomeFragment : Fragment(), View.OnClickListener, HaircutAdapter.HaircutClickCallback,
    GridBarberAdapter.BarberClickCallback {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val promoAdapter = PromoAdapter()
    private val gridBarberAdapter = GridBarberAdapter(this)
    private val haircutAdapter = HaircutAdapter(this)

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
        with(vMenuTop) {
            imgBell.setOnClickListener(this@HomeFragment)
            imgBookmark.setOnClickListener(this@HomeFragment)
            imgMessage.setOnClickListener(this@HomeFragment)
        }
        rvBarberTerdekat.setOnClickListener(this@HomeFragment)

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
                vMenuTop.imgMessage -> {}
            }
        }
    }

    override fun onClickHaircut(haircut: Haircut) {

    }

    override fun onClickBarber(barber: Barber) {
        val detailIntent = Intent(requireActivity(), DetailActivity::class.java)
        startActivity(detailIntent)
    }
}