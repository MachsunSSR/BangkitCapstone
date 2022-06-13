package com.bangkit.ambroise.ui.detail.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.ambroise.databinding.FragmentBookDateBinding
import com.bangkit.ambroise.ui.detail.book.adapter.DateAdapter
import com.bangkit.ambroise.ui.detail.book.adapter.SlotTimeAdapter
import com.bangkit.ambroise.util.DateHelper
import com.bangkit.ambroise.util.DummyData
import com.google.android.flexbox.FlexboxLayoutManager

class BookDateFragment : Fragment() {
    private var _binding: FragmentBookDateBinding? = null
    private val binding get() = _binding!!
    private val dateAdapter = DateAdapter()
    private val slotTimeAdapter = SlotTimeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookDateBinding.inflate(inflater, container, false)
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
    }

    private fun initRv() {
        dateAdapter.setData(DateHelper.getListNextWeek())
        slotTimeAdapter.setData(DummyData.provideTimeSlots())

        with(binding.rvDate) {
            adapter = dateAdapter
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        with(binding.rvSlotTime) {
            adapter = slotTimeAdapter
            layoutManager = FlexboxLayoutManager(requireContext())
        }
    }

}