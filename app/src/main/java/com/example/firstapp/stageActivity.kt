package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class stageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stage)
    }

    fun startlvl(v : View){
        intent = Intent(this, MediumActivity::class.java)
        startActivity(intent)
//        finish()
    }
}