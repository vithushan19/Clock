package com.vithushan.clock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(ClockViewModel::class.java)
        viewModel.time.observe(this, Observer<String> {
            updateUI(it)
        })
        viewModel.time.value = "time"
    }

    private fun updateUI(time: String) {
        titleLabel.text = time
    }
}
