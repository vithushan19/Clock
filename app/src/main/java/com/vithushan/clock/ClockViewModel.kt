package com.vithushan.clock
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel


class ClockViewModel : ViewModel() {

    private val timeRepository = TimeRepository()
    val time : LiveData<String> get() = timeRepository.getTime()
}