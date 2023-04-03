package com.example.proctoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ProgressBar

class CheckQrActivity : AppCompatActivity() {

    public var qrContent: String? = null
    private var pBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_check_qr)
        pBar = findViewById(R.id.pBar)
        qrContent = intent.getStringExtra("QrContent")
        checkQrContent(qrContent)
    }

    public fun choseActivity(res: Boolean){
        if(res){
            var intent = Intent(this, CheckFaceActivity::class.java)
            startActivity(intent)
        }
        else{
            var intent = Intent(this, BadResultActivity::class.java)
            intent.putExtra("error_string", "Неверный QR-Code")
            startActivity(intent)
        }
    }

    public fun checkQrContent(qrContent: String?): Boolean{
        val parts = qrContent!!.split(';')
        var res = true;
        var i = 0
        for(part in parts) {
            if(part.isNotEmpty()) {
                when(i){
                    0 -> {
                        if(part.split(':')[0] != "url"){
                            res = false
                        }
                    }
                    1 -> {
                        if(part.split(':')[0] != "ident"){
                            res = false
                        }
                    }
                    2 -> {
                        if(part.split(':')[0] != "name"){
                            res = false
                        }
                    }
                    3 -> {
                        if(part.split(':')[0] != "stud_nomer"){
                            res = false
                        }
                    }
                    4 -> {
                        if(part.split(':')[0] != "proc"){
                            res = false
                        }
                    }
                }
                i += 1;
            }
        }
        if (i != 5){
            res = false
        }
        choseActivity(res)
        return res;
    }
}