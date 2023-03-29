package com.example.proctoring

import android.content.Intent
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.Window
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import java.io.File


class CheckRoomActivity : AppCompatActivity() {

    var cButton: Button? = null
    private var ourRequestCode = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_check_room)

        cButton = findViewById(R.id.continuButton2)
        cButton?.setOnClickListener{
            val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
            if(intent.resolveActivity(packageManager) != null){
                startActivityForResult(intent, ourRequestCode)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && ourRequestCode == requestCode){
            /*val uri = data?.data
            val retriever = MediaMetadataRetriever()
            retriever.setDataSource(applicationContext, uri);
            val time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
            val timeInMillisec = time!!.toLong()
            retriever.release()
            if (timeInMillisec >= 5000){
                val intent = Intent(this, GoodResultActivity::class.java)
                startActivity(intent)
            }
            else{
                var intent = Intent(this, BadResultActivity::class.java)
                intent.putExtra("error_string", "Предоставленного вами видео не достаточно для проверки вашего окружения (видео слишком короткое)")
                startActivity(intent)
            }
        }

        */
    }
}