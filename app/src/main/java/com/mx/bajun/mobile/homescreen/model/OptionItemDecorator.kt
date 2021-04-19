package com.mx.bajun.mobile.homescreen.model

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class OptionItemDecorator (val space: Int = 5) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        //super.getItemOffsets(outRect, view, parent, state)
        outRect.left = space
        outRect.right = space
        outRect.bottom = space
        if (parent.getChildLayoutPosition(view) == 0 || parent.getChildLayoutPosition(view) == 1 ) {
            outRect.top = 0
        } else {
            outRect.top = space
        }
    }


}