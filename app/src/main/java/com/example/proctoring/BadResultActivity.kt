package com.example.proctoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView

class BadResultActivity : AppCompatActivity() {

    var bBack: Button? = null
    var errorStr: String? = null
    var errorLine: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_bad_result)
        errorStr = intent.getStringExtra("error_string")
        errorLine = findViewById(R.id.errorString)
        errorLine!!.text = errorStr
        bBack = findViewById(R.id.backButton)
        bBack?.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}