package com.xia.timeslip.presentation.widget

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.animation.GridLayoutAnimationController

/**
 * Created by xiahao on 2017/12/10.
 */
class GridRecyclerView(context: Context?, attrs: AttributeSet?, defStyle: Int) : RecyclerView(context, attrs, defStyle) {

    override fun attachLayoutAnimationParameters(child: View, params: ViewGroup.LayoutParams,
                                                 index: Int, count: Int) {
        val layoutManager = layoutManager
        if (adapter != null && layoutManager is GridLayoutManager) {
            val animationParams = GridLayoutAnimationController.AnimationParameters()
            params.layoutAnimationParameters = animationParams

            animationParams.count = count
            animationParams.index = index

            val columns = layoutManager.spanCount
            animationParams.columnsCount = columns
            animationParams.rowsCount = count / columns

            val invertedIndex = count - 1 - index
            animationParams.column = columns - 1 - invertedIndex % columns
            animationParams.row = animationParams.rowsCount - 1 - invertedIndex / columns
        } else {
            super.attachLayoutAnimationParameters(child, params, index, count)
        }
    }

}