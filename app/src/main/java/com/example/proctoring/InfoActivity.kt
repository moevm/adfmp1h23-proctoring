package com.example.proctoring

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InfoActivity : AppCompatActivity() {

    var binfo: Button? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        binfo = findViewById(R.id.infoButton)
        binfo?.setOnClickListener {
            startActivity(Intent(this, ScannerActivity::class.java))
        }
    }
}