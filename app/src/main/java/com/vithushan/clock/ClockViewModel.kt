package com.vithushan.clock
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import java.util.*


class ClockViewModel : ViewModel() {

    private val timeRepository = TimeRepository()
    val time : LiveData<Date> get() = timeRepository.getTime()
}