package com.example.proctoring

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import java.io.File


class CheckFaceActivity : AppCompatActivity() {

    var cButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_face)
        cButton = findViewById(R.id.continuButton)
        val resultLauncher = registerForActivityResult(ActivityResultContracts.TakePicture()){
            val intent = Intent(this, CheckRoomActivity::class.java)
            startActivity(intent)
        }
        cButton?.setOnClickListener{
            resultLauncher.launch(Uri.parse(""))
        }
    }
}