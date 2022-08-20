package com.example.firstapp

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import java.io.IOException

class MediumActivity : levels(), View.OnClickListener {

    var tmpword : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medium)

        url = "https://randomword.com/vocabulary"
        tmpword = findViewById<View>(R.id.tmpword) as? TextView

        loopButtons()
        initgame()
        fetchword()
    }

    fun fetchword(){
        runOnUiThread {
            Thread(Runnable() {
//                @Override
//                fun run() {
                try {
                    var word = "--"
                    var doc : Document? = null
                    var elementsHtml : Element
                    while (!word.matches("^[a-zA-Z]*$".toRegex()) ){
                        doc = Jsoup.connect(url.toString()).get() as Document
                        frame?.visibility = View.VISIBLE
                        elementsHtml = doc.getElementById("random_word") as Element
                        word = elementsHtml.text()
                    }
//                    word = "--jj--"
//                    word = word.replace("-"," ")
                    randomword = word.toString().uppercase()
                    definition = doc?.getElementById("random_word_definition")?.text()

                    mTextViewResult?.text = "-".repeat(randomword!!.length)
                    mTextCounter?.text = randomword?.length.toString().plus(" letters ")

                    println("########## + $randomword")
                }
                catch (e : IOException){

                    frame?.visibility = View.INVISIBLE
                    toast?.show()
                }
            }).start()
        }
    }

    fun displayHint(v : View){
        v.setClickable(false)
        mTextDefinition!!.text = definition
        mTextDefinition!!.visibility = View.VISIBLE
        hint!!.setImageResource(R.drawable.lamp)
    }

    override fun onClick(view: View) {

        val inp = view as Button

        checkletter(inp.text as String, inp)
        inp.setBackgroundColor(Color.GRAY)
//        sd = MediaPlayer.create(this, R.raw.letter)
//        sd?.start()

        checkcounter()
        inp.setClickable(false)
        updateImage()
    }
}