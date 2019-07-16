package com.vithushan.clock
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ClockViewModel : ViewModel() {

    val time = MutableLiveData<String>()

    fun setTime(newTime: String): Unit {
        time.value = newTime
    }
}