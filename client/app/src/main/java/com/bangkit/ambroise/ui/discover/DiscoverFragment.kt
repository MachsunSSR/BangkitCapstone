package com.bangkit.ambroise.ui.discover

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.ambroise.R
import com.bangkit.ambroise.databinding.FragmentDiscoverBinding
import com.bangkit.ambroise.ui.detail.DetailActivity
import com.bangkit.ambroise.util.DummyData
import com.bangkit.ambroise.util.MarginItemDecoration
import com.bangkit.ambroise.util.showToast

class DiscoverFragment : Fragment() {
    private var _binding: FragmentDiscoverBinding? = null
    private val binding get() = _binding!!
    private val discoverAdapter = DiscoverAdapter { view, _ ->
        if (view.id == R.id.imgBookmark) {
            requireContext().showToast("Clicked!")
        } else {
            val detailIntent = Intent(requireActivity(), DetailActivity::class.java)
            startActivity(detailIntent)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiscoverBinding.inflate(layoutInflater, container, false)
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
        imgBack.setOnClickListener { requireActivity().onBackPressed() }
    }

    private fun initRv() {
        discoverAdapter.setData(DummyData.provideBarber())

        with(binding.rvBarbershop) {
            layoutManager = LinearLayoutManager(requireActivity())
            addItemDecoration(MarginItemDecoration(24))
            adapter = discoverAdapter
        }
    }

}