package com.xia.timeslip.presentation.widget.behavior

import android.content.Context
import android.os.Build
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import news.xia.com.timeslip.R


/**
 * 滚动属性值
 * Created by xiahao on 2017/12/1.
 */
class ScrollAwareFABBehavior(context: Context?, attrs: AttributeSet?) : FloatingActionButton.Behavior(context, attrs) {


    private val INTERPOLATOR = FastOutSlowInInterpolator()
    private var mIsAnimatingOut = false

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton,
                                     directTargetChild: View, target: View, nestedScrollAxes: Int): Boolean {
        // 确定是在垂直方向上滑动
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes)
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton,
                                target: View, dxConsumed: Int, dyConsumed: Int,
                                dxUnconsumed: Int, dyUnconsumed: Int) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed)

        if (dyConsumed > 0 && !this.mIsAnimatingOut && child.visibility == View.VISIBLE) {
            // 不显示FAB
            animateOut(child)

        } else if (dyConsumed < 0 && child.visibility != View.VISIBLE) {
            // 显示FAB
            animateIn(child)

        }
    }


    // 定义滑动时的属性动画效果
    private fun animateOut(button: FloatingActionButton) {
        if (Build.VERSION.SDK_INT >= 14) {
            ViewCompat.animate(button).scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setInterpolator(INTERPOLATOR).withLayer()
                    .setListener(object : ViewPropertyAnimatorListener {
                        override fun onAnimationStart(view: View) {
                            this@ScrollAwareFABBehavior.mIsAnimatingOut = true
                        }

                        override fun onAnimationCancel(view: View) {
                            this@ScrollAwareFABBehavior.mIsAnimatingOut = false
                        }

                        override fun onAnimationEnd(view: View) {
                            this@ScrollAwareFABBehavior.mIsAnimatingOut = false
                            view.visibility = View.INVISIBLE
                        }
                    }).start()

        } else {
            val anim = AnimationUtils.loadAnimation(button.context, R.anim.abc_fade_out)
            anim.interpolator = INTERPOLATOR
            anim.duration = 200L
            anim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {
                    this@ScrollAwareFABBehavior.mIsAnimatingOut = true
                }

                override fun onAnimationEnd(animation: Animation) {
                    this@ScrollAwareFABBehavior.mIsAnimatingOut = false
                    button.visibility = View.INVISIBLE
                }

                override fun onAnimationRepeat(animation: Animation) {}
            })
            button.startAnimation(anim)

        }

    }

    private fun animateIn(button: FloatingActionButton) {
        button.visibility = View.VISIBLE

        if (Build.VERSION.SDK_INT >= 14) {
            ViewCompat.animate(button).scaleX(1.0f).scaleY(1.0f).alpha(1.0f)
                    .setInterpolator(INTERPOLATOR).withLayer().setListener(null)
                    .start()

        } else {
            val anim = AnimationUtils.loadAnimation(button.context, R.anim.abc_fade_in)
            anim.duration = 200L
            anim.interpolator = INTERPOLATOR
            button.startAnimation(anim)

        }
    }

}