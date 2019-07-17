package com.vithushan.clock

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.util.*

class ClockView : View {

    private var circleColor = Color.WHITE
    private var hourHandColor = Color.BLACK
    private var minuteHandColor = Color.BLACK
    private var secondHandColor = Color.BLACK

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 10F
    }

    private val calendar = GregorianCalendar.getInstance()

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ClockView,
            0, 0).apply {

            try {
                circleColor = getColor(R.styleable.ClockView_circleColour, Color.WHITE)
                hourHandColor = getColor(R.styleable.ClockView_hourHandColour, Color.BLACK)
                minuteHandColor = getColor(R.styleable.ClockView_minuteHandColour, Color.BLACK)
                secondHandColor = getColor(R.styleable.ClockView_secondHandColour, Color.BLACK)

            } finally {
                recycle()
            }
        }
    }

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

            paint.color = circleColor
            canvas.drawCircle(centerX, centerY, radius, paint)

            paint.color = hourHandColor
            canvas.drawRotatedLine(centerX, centerY, radius * 0.75F, paint, getAngleForHourHand())

            paint.color = minuteHandColor
            canvas.drawRotatedLine(centerX, centerY, radius, paint, getAngleForMinuteHand())

            paint.color = secondHandColor
            canvas.drawRotatedLine(centerX, centerY, radius, paint, getAngleForSecondHand())
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