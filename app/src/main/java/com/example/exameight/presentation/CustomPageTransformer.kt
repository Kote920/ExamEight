package com.example.exameight.presentation

import android.view.View
import androidx.viewpager2.widget.ViewPager2


class CustomPageTransformer : ViewPager2.PageTransformer {
    private val scaleFactor = 0.85f
    private val marginOffset = 0.15f

    override fun transformPage(page: View, position: Float) {
        page.apply {
            val absPosition = kotlin.math.abs(position)
            if (absPosition >= 1) {
                scaleX = scaleFactor
                scaleY = scaleFactor
            } else {
                scaleX = scaleFactor + (1 - absPosition) * (1 - scaleFactor)
                scaleY = scaleFactor + (1 - absPosition) * (1 - scaleFactor)
            }
            translationX = -width * marginOffset * position
        }
    }
}
