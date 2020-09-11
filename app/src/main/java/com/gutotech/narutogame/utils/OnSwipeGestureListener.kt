package com.gutotech.narutogame.utils

import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import kotlin.math.abs

open class OnSwipeGestureListener : SimpleOnGestureListener() {

    override fun onDown(e: MotionEvent): Boolean {
        return true
    }

    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        var result = false

        try {
            val diffY = e2.y - e1.y
            val diffX = e2.x - e1.x

            if (abs(diffX) > abs(diffY)) {
                if (abs(diffX) > SWIPE_THRESHOLD && abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        onSwipeRight()
                    } else {
                        onSwipeLeft()
                    }
                    result = true
                }
            } else if (abs(diffY) > SWIPE_THRESHOLD && abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffY > 0) {
                    onSwipeBottom()
                } else {
                    onSwipeTop()
                }
                result = true
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }

        return result
    }

    open fun onSwipeRight() {}

    open fun onSwipeLeft() {}

    open fun onSwipeTop() {}

    open fun onSwipeBottom() {}

    companion object {
        private const val SWIPE_THRESHOLD = 100
        private const val SWIPE_VELOCITY_THRESHOLD = 100
    }
}