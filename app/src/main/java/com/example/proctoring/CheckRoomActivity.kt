package com.example.proctoring

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Window
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts

class CheckRoomActivity : AppCompatActivity() {

    var cButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_check_room)

        val resultLauncher = registerForActivityResult(ActivityResultContracts.TakeVideo()){
            val intent = Intent(this, GoodResultActivity::class.java)
            startActivity(intent)
        }

        cButton = findViewById(R.id.continuButton2)
        cButton?.setOnClickListener{
            resultLauncher.launch(Uri.parse(""))
        }
    }
}