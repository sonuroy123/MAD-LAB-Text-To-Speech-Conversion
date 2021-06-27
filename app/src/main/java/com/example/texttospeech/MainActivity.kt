package com.example.texttospeech

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.EditText
import androidx.annotation.RequiresApi
import java.util.*
class MainActivity: AppCompatActivity(), TextToSpeech.OnInitListener {
    private var tts:TextToSpeech? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tts = TextToSpeech(this,this)

    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun convert (view : View?) {
        var e = findViewById<EditText>(R.id.editT)
        tts!!. speak(e.text.toString(), TextToSpeech.QUEUE_FLUSH,null, "")
    }
    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            val result = tts!!.setLanguage(Locale.ENGLISH)
        }
    }
}