package com.basicapplication.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.basicapplication.R

class ApplicationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.application_activity)
    }
}