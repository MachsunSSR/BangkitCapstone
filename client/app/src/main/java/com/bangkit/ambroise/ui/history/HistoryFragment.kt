package com.bangkit.ambroise.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.ambroise.databinding.FragmentBookingBinding
import com.bangkit.ambroise.util.DummyData
import com.bangkit.ambroise.util.MarginItemDecoration

class BookingFragment : Fragment() {
    private var _binding: FragmentBookingBinding? = null
    private val binding get() = _binding!!
    private val bookAdapter = BookAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookingBinding.inflate(layoutInflater, container, false)
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
        bookAdapter.setData(DummyData.provideBooks())

        with(binding.rvBook) {
            layoutManager = LinearLayoutManager(requireActivity())
            addItemDecoration(MarginItemDecoration(24))
            adapter = bookAdapter
        }
    }

}