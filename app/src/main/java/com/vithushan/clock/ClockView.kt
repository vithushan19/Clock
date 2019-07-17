package com.vithushan.clock

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class ClockView : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val hourPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
        strokeWidth = 10F
    }

    private val circlePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.apply {
            val centerX = (width / 2).toFloat()
            val centerY = (height / 2).toFloat()
            val radius = 200F

            canvas.drawCircle(centerX, centerY, radius, circlePaint)

            canvas.save()
            canvas.rotate(getAngleForHourHand(), centerX, centerY)
            drawLine(centerX, centerY, centerX, centerY - radius, hourPaint)
            canvas.restore()
        }
    }

    /**
     * 3 o'clock => 90 degrees
     * 6 o'clock => 180 degrees
     * 9 o'clock => 270 degrees
     * 12 o'clock => 0 degrees
     */
    private fun getAngleForHourHand(): Float {
        return (getHour() % 12) * 30F
    }

    private fun getHour(): Int {
        return 0
    }

}