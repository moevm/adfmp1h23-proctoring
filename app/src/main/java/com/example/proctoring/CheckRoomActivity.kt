package com.example.proctoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class CheckRoomActivity : AppCompatActivity() {

    var cButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_room)

        cButton = findViewById(R.id.continuButton2)
        cButton?.setOnClickListener{
            val cameraIntent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
            startActivity(cameraIntent)
        }
    }
}