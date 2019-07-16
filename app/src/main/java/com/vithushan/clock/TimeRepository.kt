package com.vithushan.clock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.timerTask

class TimeRepository {

    private val SECOND = 1000L

    private val time: MutableLiveData<Date> = MutableLiveData()

    init {
        val timer = Timer()

        timer.scheduleAtFixedRate(timerTask { (time::postValue)(Calendar.getInstance().time) }, SECOND, SECOND)
    }

    fun getTime(): LiveData<Date> {
        return time
    }

}