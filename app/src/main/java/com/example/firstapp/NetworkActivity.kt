package com.example.firstapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NetworkActivity : AppCompatActivity() {

    private var toast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        toast = Toast.makeText(this,"please check your connection",Toast.LENGTH_SHORT)
        toast?.show()

    }
}