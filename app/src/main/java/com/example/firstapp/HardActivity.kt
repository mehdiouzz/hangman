package com.example.firstapp

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import java.io.IOException


class HardActivity : levels(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hard)

        url = "https://randomword.com"

//        setButtons()
        initgame()
        fetchword()
//        loopButtons()
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
                    loopButtons()
                    hint?.isClickable = true
                    reveal?.isClickable = true
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

        checkcounter()
        inp.setClickable(false)
        updateImage()
    }

}