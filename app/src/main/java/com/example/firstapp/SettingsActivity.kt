package com.example.firstapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    var soundVar = "Off"
    var musicVar = "Off"
    var music : ImageView? = null
    var sound : ImageView? = null
    var musictxt : TextView? = null
    var soundtxt : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }

    fun soundOff(v : View){

        sound = findViewById<View>(R.id.sound) as ImageView
        soundtxt = findViewById<View>(R.id.soundtxt) as TextView

        if (soundVar == "Off"){
            sound!!.setImageResource(R.drawable.sound)
            soundtxt!!.text = "Sound On"
            soundVar = "On"
            return
        }
        sound!!.setImageResource(R.drawable.volumemute)
        soundtxt!!.text = "Sound Off"
        soundVar = "Off"
    }

    fun musicOff(v : View){

        music = findViewById<View>(R.id.music) as ImageView
        musictxt = findViewById<View>(R.id.musictxt) as TextView

        if (musicVar == "Off"){
            music!!.setImageResource(R.drawable.music)
            musictxt!!.text = "Music On"
            musicVar = "On"
            return
        }
        music!!.setImageResource(R.drawable.musicoff)
        musictxt!!.text = "Music Off"
        musicVar = "Off"
    }
}