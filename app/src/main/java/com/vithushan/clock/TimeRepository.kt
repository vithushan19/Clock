package com.vithushan.clock

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*
import kotlin.concurrent.timerTask

class TimeRepository {

    private val SECOND = 1000L
    private var counter = 0

    private val time: MutableLiveData<String> = MutableLiveData()

    init {
        val timer = Timer()

        timer.scheduleAtFixedRate(timerTask { (time::postValue)(counter++.toString()) }, SECOND, SECOND)
    }


    fun getTime(): LiveData<String> {
        return time
    }

}