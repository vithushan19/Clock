package com.vithushan.clock

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.util.*

class ClockView : View {

    private val hourPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
        strokeWidth = 10F
    }

    private val minutePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.GREEN
        strokeWidth = 10F
    }

    private val secondPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        strokeWidth = 10F
    }

    private val circlePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
    }

    private val calendar = GregorianCalendar.getInstance()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun setDate(value: Date) {
        calendar.time = value
        invalidate()
        requestLayout()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.apply {
            val centerX = (width / 2).toFloat()
            val centerY = (height / 2).toFloat()
            val radius = (width / 2).toFloat()

            canvas.drawCircle(centerX, centerY, radius, circlePaint)

            canvas.drawRotatedLine(centerX, centerY, radius, hourPaint, getAngleForHourHand())
            canvas.drawRotatedLine(centerX, centerY, radius, minutePaint, getAngleForMinuteHand())
            canvas.drawRotatedLine(centerX, centerY, radius, secondPaint, getAngleForSecondHand())
        }
    }

    private fun Canvas.drawRotatedLine(
        centerX: Float,
        centerY: Float,
        radius: Float,
        paint: Paint,
        angle: Float
    ) {
        save()
        rotate(angle, centerX, centerY)
        drawLine(centerX, centerY, centerX, centerY - radius, paint)
        restore()
    }

    /**
     * 12 o'clock => 0 degrees
     * 3 o'clock => 90 degrees
     * 6 o'clock => 180 degrees
     * 9 o'clock => 270 degrees
     */
    private fun getAngleForHourHand(): Float {
        return calendar.get(Calendar.HOUR) * 30F
    }

    /**
     * 0 minutes => 0 degrees
     * 15 minutes => 90 degrees
     * 30 minutes => 180 degrees
     * 45 minutes => 270 degrees
     */
    private fun getAngleForMinuteHand(): Float {
        return calendar.get(Calendar.MINUTE) * 6F
    }

    /**
     * 0 seconds => 0 degrees
     * 15 seconds => 90 degrees
     * 30 seconds => 180 degrees
     * 45 seconds => 270 degrees
     */
    private fun getAngleForSecondHand(): Float {
        return calendar.get(Calendar.SECOND) * 6F
    }

}