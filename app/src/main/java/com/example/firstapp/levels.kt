package com.example.firstapp

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.apache.commons.lang3.StringUtils
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import java.io.IOException

open class levels : AppCompatActivity(), View.OnClickListener{

    protected var url : String? = null
    protected var frame : RelativeLayout? = null
    protected var mTextViewResult : TextView? = null
    protected var mTextDefinition : TextView? = null
    protected var mTextCounter : TextView? = null
    private var tmpword : TextView? = null
    protected var toast: Toast? = null
    protected var counter = 7
    protected var randomword: String? = null
    protected var definition: String? = null
    protected var img : ImageView? = null
    protected var hint: ImageButton? = null
    protected var reload: ImageButton? = null
    protected var msg : TextView? = null

    protected var lvl : TextView? = null

    protected var q : Button? = null
    protected var w : Button? = null
    protected var e : Button? = null
    protected var r : Button? = null
    protected var t : Button? = null
    protected var y : Button? = null
    protected var u : Button? = null
    protected var i : Button? = null
    protected var o : Button? = null
    protected var p : Button? = null
    protected var a : Button? = null
    protected var s : Button? = null
    protected var d : Button? = null
    protected var f : Button? = null
    protected var g : Button? = null
    protected var h : Button? = null
    protected var j : Button? = null
    protected var k : Button? = null
    protected var l : Button? = null
    protected var z : Button? = null
    protected var x : Button? = null
    protected var c : Button? = null
    protected var v : Button? = null
    protected var b : Button? = null
    protected var n : Button? = null
    protected var m : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        q = findViewById<View>(R.id.q) as? Button
        w = findViewById<View>(R.id.w) as? Button
        e = findViewById<View>(R.id.e) as? Button
        r = findViewById<View>(R.id.r) as? Button
        t = findViewById<View>(R.id.t) as? Button
        y = findViewById<View>(R.id.y) as? Button
        u = findViewById<View>(R.id.u) as? Button
        i = findViewById<View>(R.id.i) as? Button
        o = findViewById<View>(R.id.o) as? Button
        p = findViewById<View>(R.id.p) as? Button
        a = findViewById<View>(R.id.a) as? Button
        s = findViewById<View>(R.id.s) as? Button
        d = findViewById<View>(R.id.d) as? Button
        f = findViewById<View>(R.id.f) as? Button
        g = findViewById<View>(R.id.g) as? Button
        h = findViewById<View>(R.id.h) as? Button
        j = findViewById<View>(R.id.j) as? Button
        k = findViewById<View>(R.id.k) as? Button
        l = findViewById<View>(R.id.l) as? Button
        z = findViewById<View>(R.id.z) as? Button
        x = findViewById<View>(R.id.x) as? Button
        c = findViewById<View>(R.id.c) as? Button
        v = findViewById<View>(R.id.v) as? Button
        b = findViewById<View>(R.id.b) as? Button
        n = findViewById<View>(R.id.n) as? Button
        m = findViewById<View>(R.id.m) as? Button



        q?.setOnClickListener(this)
        w?.setOnClickListener(this)
        e?.setOnClickListener(this)
        r?.setOnClickListener(this)
        t?.setOnClickListener(this)
        y?.setOnClickListener(this)
        u?.setOnClickListener(this)
        i?.setOnClickListener(this)
        o?.setOnClickListener(this)
        p?.setOnClickListener(this)
        a?.setOnClickListener(this)
        s?.setOnClickListener(this)
        d?.setOnClickListener(this)
        f?.setOnClickListener(this)
        g?.setOnClickListener(this)
        h?.setOnClickListener(this)
        j?.setOnClickListener(this)
        k?.setOnClickListener(this)
        l?.setOnClickListener(this)
        z?.setOnClickListener(this)
        x?.setOnClickListener(this)
        c?.setOnClickListener(this)
        v?.setOnClickListener(this)
        b?.setOnClickListener(this)
        n?.setOnClickListener(this)
        m?.setOnClickListener(this)

    }

    fun setButtons(){

        val q = findViewById<View>(R.id.q) as? Button
        val w = findViewById<View>(R.id.w) as? Button
        val e = findViewById<View>(R.id.e) as? Button
        val r = findViewById<View>(R.id.r) as? Button
        val t = findViewById<View>(R.id.t) as? Button
        val y = findViewById<View>(R.id.y) as? Button
        val u = findViewById<View>(R.id.u) as? Button
        val i = findViewById<View>(R.id.i) as? Button
        val o = findViewById<View>(R.id.o) as? Button
        val p = findViewById<View>(R.id.p) as? Button
        val a = findViewById<View>(R.id.a) as? Button
        val s = findViewById<View>(R.id.s) as? Button
        val d = findViewById<View>(R.id.d) as? Button
        val f = findViewById<View>(R.id.f) as? Button
        val g = findViewById<View>(R.id.g) as? Button
        val h = findViewById<View>(R.id.h) as? Button
        val j = findViewById<View>(R.id.j) as? Button
        val k = findViewById<View>(R.id.k) as? Button
        val l = findViewById<View>(R.id.l) as? Button
        val z = findViewById<View>(R.id.z) as? Button
        val x = findViewById<View>(R.id.x) as? Button
        val c = findViewById<View>(R.id.c) as? Button
        val v = findViewById<View>(R.id.v) as? Button
        val b = findViewById<View>(R.id.b) as? Button
        val n = findViewById<View>(R.id.n) as? Button
        val m = findViewById<View>(R.id.m) as? Button

        q?.setOnClickListener(this)
        w?.setOnClickListener(this)
        e?.setOnClickListener(this)
        r?.setOnClickListener(this)
        t?.setOnClickListener(this)
        y?.setOnClickListener(this)
        u?.setOnClickListener(this)
        i?.setOnClickListener(this)
        o?.setOnClickListener(this)
        p?.setOnClickListener(this)
        a?.setOnClickListener(this)
        s?.setOnClickListener(this)
        d?.setOnClickListener(this)
        f?.setOnClickListener(this)
        g?.setOnClickListener(this)
        h?.setOnClickListener(this)
        j?.setOnClickListener(this)
        k?.setOnClickListener(this)
        l?.setOnClickListener(this)
        z?.setOnClickListener(this)
        x?.setOnClickListener(this)
        c?.setOnClickListener(this)
        v?.setOnClickListener(this)
        b?.setOnClickListener(this)
        n?.setOnClickListener(this)
        m?.setOnClickListener(this)

    }

    protected fun initgame(){
        frame = findViewById<View>(R.id.frame) as? RelativeLayout
        mTextViewResult = findViewById<View>(R.id.radomword) as? TextView
        mTextDefinition = findViewById<View>(R.id.definition) as? TextView
        mTextCounter = findViewById<View>(R.id.counter) as? TextView
        img = findViewById<View>(R.id.canvas) as? ImageView
        hint = findViewById<View>(R.id.hint) as? ImageButton
        reload = findViewById<View>(R.id.reload) as? ImageButton

        tmpword = findViewById<View>(R.id.tmpword) as? TextView
        lvl = findViewById<View>(R.id.lvl) as? TextView
        lvl?.text = this.localClassName
    }

    protected fun fetchword(){
        runOnUiThread {
            Thread(Runnable() {
//                @Override
//                fun run() {
                try {

                    val doc = Jsoup.connect(url.toString()).get() as Document
                    frame?.visibility = View.VISIBLE
                    val elementsHtml = doc.getElementById("random_word") as Element
                    val word = elementsHtml.text()
                    randomword = word.toString().uppercase()
                    definition = doc.getElementById("random_word_definition")?.text()
                    mTextViewResult?.text = "-".repeat(randomword!!.length)
                    mTextCounter?.text = randomword?.length.toString().plus(" letters  | Counter = ").plus(counter.toString())
                    tmpword?.text = randomword
                }
                catch (e : IOException){

                    frame?.visibility = View.INVISIBLE
                    toast?.show()
                }
            }).start()
        }
    }

    protected fun updateImage() {
//        var imgName = "hangman".plus(counter)
//        val image = R.drawable.imgName as Drawable
//        img!!.setImageResource(R.drawable.image)

        var imageName = "hangman".plus(6-counter) as String
        var  resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
//        ImageView image;
        img?.setImageResource(resID );
    }

    protected fun writeLetter(lett : String, arr : ArrayList<Int>) {

        var txt = mTextViewResult?.text.toString()

        for (indice in arr){

            txt = txt.substring(0, indice) + lett + txt.substring(indice + 1)
        }
        mTextViewResult?.text = txt
    }

    protected fun checkletter(lett: String, butt : Button){

        if (!butt.isClickable) return
        if (randomword?.contains(lett, ignoreCase = true)!!)
        {
            val indexes = Regex(lett).findAll(randomword!!)
                .map { it.range.first }
                .toList()
            writeLetter(butt.text as String, ArrayList(indexes) )
            return
        }
        counter--
        mTextCounter?.text = randomword?.length.toString().plus(" letters  | Counter = ").plus(counter.toString())
    }

    protected fun checkcounter(){
        if(this.counter === 0) {
            mTextCounter?.text = "Game Over"
            endgame()
        }
        if (!mTextViewResult!!.text.contains("-") && counter != 0) {
            mTextCounter?.text = "you won"
            endgame()
        }
        if (counter == 3)
            hint?.visibility = View.VISIBLE
    }

    protected fun endgame(){
        mTextViewResult?.text = randomword
        mTextDefinition?.text = definition
        mTextDefinition?.visibility = View.VISIBLE
        onButtonShowPopupWindowClick()
    }

    fun onButtonShowPopupWindowClick() {

        // inflate the layout of the popup window
        val inflater: LayoutInflater =
            getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val inflater: LayoutInflater? = null
//        getSystemService(LAYOUT_INFLATER_SERVICE)
        val popupView = inflater?.inflate(R.layout.popup_window, null) as? View

        // create the popup window
        val width = LinearLayout.LayoutParams.MATCH_PARENT
        val height = LinearLayout.LayoutParams.MATCH_PARENT
        val focusable = false; // lets taps outside the popup also dismiss it
        var popupWindow = PopupWindow(popupView, width, height, focusable)

        msg = popupView?.findViewById<View>(R.id.endgamemsg) as? TextView
        msg?.text = "You won"
        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.setOutsideTouchable(false)
//        popupWindow.setIgnoreCheekPress()
        popupWindow.showAtLocation(mTextCounter, Gravity.CENTER, 0, 0)

        // dismiss the popup window when touched
        popupView!!.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_DOWN -> {
                        popupWindow.dismiss()
                        reload()
                    }
                }
                return v?.onTouchEvent(event) ?: true
            }
        })
    }

    fun revealLetter(v : View){

        var diff = randomword
        var lett = diff?.random().toString()

        while (mTextViewResult?.text?.contains(lett!!, ignoreCase = true)!!)
        {
            diff = diff?.replace(lett, "")
            lett = diff?.random().toString()
        }

        val indexes = Regex(lett).findAll(randomword!!)
            .map { it.range.first }
            .toList()
        writeLetter(lett, ArrayList(indexes) )
        v.setClickable(false)

        val res = StringUtils.difference(mTextViewResult!!.text as String?, randomword ).toString()
        if (res == "")
            endgame()
    }

    fun reload(){
        this.finish()
        this.startActivity(this.getIntent())
        overridePendingTransition(androidx.navigation.ui.R.anim.abc_shrink_fade_out_from_bottom, androidx.navigation.ui.R.anim.abc_shrink_fade_out_from_bottom);
    }

    override fun onClick(view: View) {
//
        val inp = view as Button

        checkletter(inp.text as String, inp)
        inp.setBackgroundColor(Color.GRAY)

        checkcounter()
        inp.setClickable(false)
        updateImage()
    }
}