package com.example.proctoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button

class GoodResultActivity : AppCompatActivity() {

    var bButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_good_result)
        bButton = findViewById(R.id.backButton2)
        bButton?.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}