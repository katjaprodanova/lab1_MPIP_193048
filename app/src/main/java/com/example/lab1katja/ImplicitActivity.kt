package com.example.lab1katja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ImplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit)
    }
}