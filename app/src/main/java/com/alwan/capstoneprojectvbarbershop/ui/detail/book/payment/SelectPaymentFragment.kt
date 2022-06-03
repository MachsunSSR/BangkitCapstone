package com.alwan.capstoneprojectvbarbershop.ui.detail.book.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alwan.capstoneprojectvbarbershop.databinding.FragmentSelectPaymentBinding
import com.alwan.capstoneprojectvbarbershop.ui.detail.book.adapter.PaymentMethodAdapter
import com.alwan.capstoneprojectvbarbershop.ui.util.DummyData
import com.alwan.capstoneprojectvbarbershop.ui.util.MarginItemDecoration

class SelectPaymentFragment : Fragment() {
    private var _binding: FragmentSelectPaymentBinding? = null
    private val binding get() = _binding!!
    private val paymentMethodAdapter = PaymentMethodAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelectPaymentBinding.inflate(inflater, container, false)
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
        paymentMethodAdapter.setData(DummyData.providePaymentMethods())

        with(binding.rvPayment) {
            adapter = paymentMethodAdapter
            val linearLayoutManager = LinearLayoutManager(requireContext())
            layoutManager = linearLayoutManager
            addItemDecoration(MarginItemDecoration(20))
        }
    }

}