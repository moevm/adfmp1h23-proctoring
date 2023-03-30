package com.example.proctoring

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.FileProvider
import java.io.File


class CheckFaceActivity : AppCompatActivity() {

    var cButton: Button? = null
    var uri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_check_face)
        cButton = findViewById(R.id.continuButton)
        uri = getTmpFileUri()
        val resultLauncher = registerForActivityResult(ActivityResultContracts.TakePicture()){
            if (it) {
                val intent = Intent(this, CheckRoomActivity::class.java)
                startActivity(intent)
            }
        }
        cButton?.setOnClickListener{
            resultLauncher.launch(uri)
        }
    }

    private fun getTmpFileUri(): Uri {
        cacheDir.listFiles()?.forEach { it.delete() }
        val tmpFile = File
            .createTempFile("tmp_image_file", ".jpg", cacheDir)
            .apply {
                createNewFile()
            }
        return FileProvider.getUriForFile(
            applicationContext,
            "${BuildConfig.APPLICATION_ID}.provider",
            tmpFile
        )
    }
}