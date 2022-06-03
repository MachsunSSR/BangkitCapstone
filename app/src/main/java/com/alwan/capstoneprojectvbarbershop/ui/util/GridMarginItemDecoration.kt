package com.alwan.capstoneprojectvbarbershop.ui.util

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridMarginItemDecoration(
    private val spanCount: Int,
    spacing: Int,
    private val includeEdge: Boolean
) : RecyclerView.ItemDecoration() {
    private val spacingDp = (spacing * Resources.getSystem().displayMetrics.density).toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val column = position % spanCount
        if (includeEdge) {
            outRect.left =
                spacingDp - column * spacingDp / spanCount
            outRect.right =
                (column + 1) * spacingDp / spanCount
            if (position < spanCount) {
                outRect.top = spacingDp
            }
            outRect.bottom = spacingDp
        } else {
            outRect.left = column * spacingDp / spanCount
            outRect.right =
                spacingDp - (column + 1) * spacingDp / spanCount
            if (position >= spanCount) {
                outRect.top = spacingDp
            }
        }
    }
}