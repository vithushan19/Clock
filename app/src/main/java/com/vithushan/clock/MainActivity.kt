package com.vithushan.clock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(ClockViewModel::class.java)
        viewModel.time.observe(this, Observer<Date> {
            updateUI(it)
        })
    }

    private fun updateUI(time: Date) {
        val timeString = SimpleDateFormat.getTimeInstance(DateFormat.MEDIUM).format(time)
        titleLabel.text = timeString

        clock.setDate(time)
        clock2.setDate(time)
        clock3.setDate(time)
    }
}
