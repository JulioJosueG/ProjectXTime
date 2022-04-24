package com.example.projectxtime.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectxtime.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
    Thread.sleep(2000)
        setTheme(R.style.Theme_ProjectXTime)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

}