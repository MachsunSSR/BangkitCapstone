package com.alwan.capstoneprojectvbarbershop.ui.util

import android.content.res.Resources
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.alwan.capstoneprojectvbarbershop.R
import com.bumptech.glide.Glide
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexboxLayoutManager

fun ImageView.loadImage(url: String?) {
    Glide.with(this.context)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.placeholder)
        .error(R.drawable.placeholder)
        .into(this)
}

fun Int.toDp() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun ViewGroup.LayoutParams.setMargin(start: Int, end: Int) {
    with(this) {
        if (this is FlexboxLayoutManager.LayoutParams) {
            flexShrink = 0.0f
            alignSelf = AlignItems.FLEX_START
            marginStart = start.toDp()
            marginEnd = end.toDp()
        }
    }
}

fun RecyclerView.snapScroll(){
    val pagerSnapHelper = PagerSnapHelper()
    pagerSnapHelper.attachToRecyclerView(this)
}

fun String.toDayName(): String {
    return when(this){
        "1" -> "Sun"
        "2" -> "Mon"
        "3" -> "Tue"
        "4" -> "Wed"
        "5" -> "Thu"
        "6" -> "Fri"
        "7" -> "Sat"
        else -> "?"
    }
}