package com.ahmetavci.sayacprojesi

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Abstract Class (Soyut Sınıf Yapısı)

        object : CountDownTimer(15000,1000) {
            override fun onTick(millisUntilFinished: Long) {
                var textim = findViewById<TextView>(R.id.textView)
                textim.text = "Kalan: ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                var textim = findViewById<TextView>(R.id.textView)
                textim.text = "Kalan: 0"
            }

        }.start() //'start()' yazmayı unutursak sayacımız başlatılamaz.

    }

}