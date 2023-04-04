package com.example.proctoring

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import androidx.core.content.ContextCompat
import android.Manifest
import android.content.pm.PackageManager
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission

class MainActivity : AppCompatActivity() {

    var bStart: Button? = null
    var bAbout: ImageButton? = null
    private lateinit var plAuncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        register()
        checkCameraPermission()
        bAbout = findViewById(R.id.aboutButton)
        bAbout?.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
        bStart = findViewById(R.id.bStart)
        bStart?.setOnClickListener {
            startActivity(Intent(this, InfoActivity::class.java))
        }
    }

    private fun checkCameraPermission(){
        when{
            ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                    == PackageManager.PERMISSION_GRANTED -> {

                    }
            else -> {
                plAuncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

    private fun register(){
        plAuncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            if(it){

            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_LONG).show()
            }
        }
    }
}