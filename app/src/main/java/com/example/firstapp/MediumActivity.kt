package com.example.firstapp

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button

class MediumActivity : levels(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medium)

        url = "https://randomword.com/vocabulary"

        loopButtons()
        initgame()
        fetchword()
    }

    fun displayHint(v : View){
        v.setClickable(false)
        mTextDefinition!!.text = definition
        mTextDefinition!!.visibility = View.VISIBLE
    }

    override fun onClick(view: View) {

        val inp = view as Button

        checkletter(inp.text as String, inp)
        inp.setBackgroundColor(Color.GRAY)

        checkcounter()
        inp.setClickable(false)
        updateImage()
    }
}