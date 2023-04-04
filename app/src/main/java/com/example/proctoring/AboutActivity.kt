package com.example.proctoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AboutActivity : AppCompatActivity() {
    var bcheck: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        bcheck = findViewById(R.id.checkButton)
        bcheck?.setOnClickListener {
            startActivity(Intent(this, LoadingActivity::class.java))
        }
    }
}