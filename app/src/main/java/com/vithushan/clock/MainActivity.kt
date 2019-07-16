package com.vithushan.clock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(ClockViewModel::class.java)
        viewModel.time.observe(this, Observer<String> {
            updateUI(it)
        })
    }

    private fun updateUI(time: String) {
        titleLabel.text = time
    }
}
