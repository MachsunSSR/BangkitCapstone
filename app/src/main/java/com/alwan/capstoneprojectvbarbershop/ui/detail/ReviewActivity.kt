package com.alwan.capstoneprojectvbarbershop.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alwan.capstoneprojectvbarbershop.databinding.ActivityReviewBinding
import com.alwan.capstoneprojectvbarbershop.ui.detail.adapter.DetailReviewAdapter
import com.alwan.capstoneprojectvbarbershop.ui.util.DummyData
import com.alwan.capstoneprojectvbarbershop.ui.util.MarginItemDecoration

class ReviewActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityReviewBinding? = null
    private val binding get() = _binding!!
    private val reviewAdapter = DetailReviewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {
        initRv()

        imgBack.setOnClickListener(this@ReviewActivity)
    }

    private fun initRv() {
        reviewAdapter.setData(DummyData.provideReviews())

        with(binding.rvReviews) {
            layoutManager = LinearLayoutManager(this@ReviewActivity)
            addItemDecoration(MarginItemDecoration(16))
            adapter = reviewAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(v: View?) {
        with(binding) {
            when (v) {
                imgBack -> onBackPressed()
            }
        }
    }
}