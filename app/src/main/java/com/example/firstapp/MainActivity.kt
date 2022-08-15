package com.example.firstapp

//import io.ktor.*

//import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

            fun startGame(v : View){
                intent = Intent(this, EasyActivity::class.java)
                startActivity(intent)
                finish()
            }
}


