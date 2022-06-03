package com.alwan.capstoneprojectvbarbershop.ui.detail.book

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alwan.capstoneprojectvbarbershop.databinding.FragmentBookServiceBinding
import com.alwan.capstoneprojectvbarbershop.ui.detail.book.adapter.GuestFacilitiesAdapter
import com.alwan.capstoneprojectvbarbershop.ui.util.DummyData
import com.alwan.capstoneprojectvbarbershop.ui.util.Mapper
import com.google.android.flexbox.FlexboxLayoutManager

class BookServiceFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentBookServiceBinding? = null
    private val binding get() = _binding!!
    private var guestCounter = 1
    private val facilitiesAdapter = GuestFacilitiesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookServiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() = with(binding) {
        initRv()
        tvNumberGuest.text = guestCounter.toString()
        plusGuest.setOnClickListener(this@BookServiceFragment)
        minGuest.setOnClickListener(this@BookServiceFragment)
    }

    private fun initRv() {
        facilitiesAdapter.setData(Mapper.stringToFacilities(DummyData.provideFacilities()))

        with(binding.rvFacilities) {
            adapter = facilitiesAdapter
            layoutManager = FlexboxLayoutManager(requireContext())
        }
    }

    override fun onClick(v: View?) {
        with(binding) {
            when (v) {
                plusGuest -> addGuest()
                minGuest -> removeGuest()
            }
        }
    }

    private fun addGuest() {
        binding.tvNumberGuest.text = (++guestCounter).toString()
    }

    private fun removeGuest() {
        if (guestCounter == 0) return
        binding.tvNumberGuest.text = (--guestCounter).toString()
    }

}