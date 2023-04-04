package com.example.proctoring

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoadingActivity : AppCompatActivity() {
    var bload: Button? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        bload = findViewById(R.id.loadingButton)
        bload?.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
