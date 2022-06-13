package com.bangkit.ambroise.ui.detail

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.ambroise.databinding.ActivityDetailBinding
import com.bangkit.ambroise.ui.detail.adapter.DetailFacilitiesAdapter
import com.bangkit.ambroise.ui.detail.adapter.DetailReviewAdapter
import com.bangkit.ambroise.ui.detail.adapter.DetailSliderAdapter
import com.bangkit.ambroise.ui.detail.book.BookActivity
import com.bangkit.ambroise.util.DummyData
import com.bangkit.ambroise.util.MarginItemDecoration
import com.google.android.flexbox.FlexboxLayoutManager
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView

class DetailActivity : AppCompatActivity(), View.OnClickListener,
    DetailFacilitiesAdapter.FacilitiesClickCallback {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!
    private val detailSlideAdapter = DetailSliderAdapter()
    private val facilitiesAdapter = DetailFacilitiesAdapter(this)
    private val detailReviewAdapter = DetailReviewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initRv() {
        with(DummyData) {
            detailSlideAdapter.setData(provideImage())
            facilitiesAdapter.setData(provideFacilities())
            detailReviewAdapter.setData(provideReviews())
        }

        with(binding.vSlider) {
            setSliderAdapter(detailSlideAdapter)
            setIndicatorAnimation(IndicatorAnimationType.WORM)
            setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
            autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
            indicatorSelectedColor = Color.WHITE
            indicatorUnselectedColor = Color.GRAY
        }

        with(binding.rvFacilities) {
            layoutManager = FlexboxLayoutManager(this@DetailActivity)
            adapter = facilitiesAdapter
        }

        with(binding.rvReviews) {
            layoutManager = LinearLayoutManager(this@DetailActivity)
            addItemDecoration(MarginItemDecoration(16))
            adapter = detailReviewAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initView() = with(binding) {
        initRv()
        btnBook.setOnClickListener(this@DetailActivity)
        imgBack.setOnClickListener(this@DetailActivity)
        tvSeeAll.setOnClickListener(this@DetailActivity)
    }

    override fun onClick(v: View?) {
        with(binding) {
            when (v) {
                btnBook -> {
                    val bookIntent = Intent(this@DetailActivity, BookActivity::class.java)
                    startActivity(bookIntent)
                }
                imgBack -> finish()
                tvSeeAll -> {
                    val reviewIntent = Intent(this@DetailActivity, ReviewActivity::class.java)
                    startActivity(reviewIntent)
                }
            }
        }
    }

    override fun onClickFacilities(facility: String) {

    }
}