package com.example.firstapp

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
    protected var reveal: ImageButton? = null
    protected var reload: ImageButton? = null
    protected var msg : TextView? = null

    protected var lvl : TextView? = null
    protected var popuplocation : LinearLayout? = null
    protected var winMsg = "You won" as String
    protected var lossMsg = "Game Over" as String

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

//        q?.setOnClickListener(this)
//        w?.setOnClickListener(this)
//        e?.setOnClickListener(this)
//        r?.setOnClickListener(this)
//        t?.setOnClickListener(this)
//        y?.setOnClickListener(this)
//        u?.setOnClickListener(this)
//        i?.setOnClickListener(this)
//        o?.setOnClickListener(this)
//        p?.setOnClickListener(this)
//        a?.setOnClickListener(this)
//        s?.setOnClickListener(this)
//        d?.setOnClickListener(this)
//        f?.setOnClickListener(this)
//        g?.setOnClickListener(this)
//        h?.setOnClickListener(this)
//        j?.setOnClickListener(this)
//        k?.setOnClickListener(this)
//        l?.setOnClickListener(this)
//        z?.setOnClickListener(this)
//        x?.setOnClickListener(this)
//        c?.setOnClickListener(this)
//        v?.setOnClickListener(this)
//        b?.setOnClickListener(this)
//        n?.setOnClickListener(this)
//        m?.setOnClickListener(this)

    }

    fun loopButtons(){
        val letters = arrayOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")
        for (itr in letters){
            val bttns = resources.getIdentifier(itr, "id", packageName)
            findViewById<TextView>(bttns).setOnClickListener(this)
        }
    }

    protected fun initgame(){
        frame = findViewById<View>(R.id.frame) as? RelativeLayout
        mTextViewResult = findViewById<View>(R.id.radomword) as? TextView
        mTextDefinition = findViewById<View>(R.id.definition) as? TextView
        mTextCounter = findViewById<View>(R.id.counter) as? TextView
        img = findViewById<View>(R.id.canvas) as? ImageView
        hint = findViewById<View>(R.id.hint) as? ImageButton
        reveal = findViewById<View>(R.id.reveal) as? ImageButton
        reload = findViewById<View>(R.id.reload) as? ImageButton

        tmpword = findViewById<View>(R.id.tmpword) as? TextView
//        lvl = findViewById<View>(R.id.lvl) as? TextView
//        lvl?.text = this.localClassName
    }

    protected fun fetchword(){
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
    }

    protected fun checkcounter(){
        if(this.counter === 0) {
//            mTextCounter?.visibility = View.INVISIBLE
            endgame(lossMsg)
        }
        if (!mTextViewResult!!.text.contains("-") && counter != 0) {
//            mTextCounter?.visibility = View.INVISIBLE
            endgame(winMsg)
        }
        if (counter == 3)
            hint?.visibility = View.VISIBLE
    }

    protected fun endgame(outputMsg : String){
        mTextViewResult?.text = randomword
        mTextDefinition?.text = definition
        mTextDefinition?.visibility = View.VISIBLE
//        hint?.visibility = View.INVISIBLE

        val dict = findViewById<View>(R.id.dict)
        var params = dict.getLayoutParams()
        params.height = LinearLayout.LayoutParams.WRAP_CONTENT
        params.width = LinearLayout.LayoutParams.WRAP_CONTENT
        dict.setLayoutParams(params);
        val dictt = dict as TextView
//        mTextCounter?.text = definition

        hint?.visibility = View.INVISIBLE
        params = hint?.getLayoutParams()
        params.width = 0

        onButtonShowPopupWindowClick(outputMsg)
    }

    fun onButtonShowPopupWindowClick(outputMsg : String) {

        // inflate the layout of the popup window
        val inflater: LayoutInflater =
            getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val inflater: LayoutInflater? = null
//        getSystemService(LAYOUT_INFLATER_SERVICE)
        val popupView = inflater?.inflate(R.layout.popup_window, null) as? View

        // create the popup window
//        val width = LinearLayout.LayoutParams.MATCH_PARENT
//        val height = LinearLayout.LayoutParams.MATCH_PARENT
        popuplocation = findViewById<View>(R.id.keyboard) as? LinearLayout
//        val keyboard = findViewById<View>(R.id.keyboard) as? LinearLayout
//        val params = keyboard?.getLayoutParams()
//        params?.width  = keyboard?.width
//        params?.height  = keyboard?.height
        val coord = IntArray(2)
        popuplocation?.getLocationInWindow(coord)
        val width = coord!![0]
        val height = coord!![1]
        val focusable = false; // lets taps outside the popup also dismiss it
        var popupWindow = PopupWindow(popupView, popuplocation?.width!!, popuplocation?.height!!, focusable)

        msg = popupView?.findViewById<View>(R.id.endgamemsg) as? TextView
        msg?.text = outputMsg
        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.setOutsideTouchable(false)
//        popupWindow.setIgnoreCheekPress()
        disableButtons()
        popupWindow.showAtLocation(mTextCounter, Gravity.NO_GRAVITY, width, height)

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

    fun disableButtons(){
        hint?.setClickable(false)
        reveal?.setClickable(false)
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
            endgame(winMsg)
    }

    fun reload(){
        this.finish()
        this.startActivity(this.getIntent())
        overridePendingTransition(androidx.navigation.ui.R.anim.abc_shrink_fade_out_from_bottom, androidx.navigation.ui.R.anim.abc_shrink_fade_out_from_bottom);
    }

    fun reload(v : View){
        this.finish()
        this.startActivity(this.getIntent())
    }

    fun goback(v : View){
        onBackPressed()
    }

    override fun onClick(view: View) {
        val inp = view as Button

        checkletter(inp.text as String, inp)
        inp.setBackgroundColor(Color.GRAY)

        checkcounter()
        inp.setClickable(false)
        updateImage()
    }

    private var backToast : Toast? = null
    private var backPressedTime:Long = 0
    override fun onBackPressed() {
//            if(backtoast!=null && backtoast!!.getView()?.getWindowToken() !=null) {
//                finish();
//            } else {
//                backtoast = Toast.makeText(this, "Press back to exit", Toast.LENGTH_SHORT)
//                backtoast?.show()
//            }

        backToast = Toast.makeText(this, "Press back again to leave the app.", Toast.LENGTH_LONG)
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast?.cancel()
            super.onBackPressed()
            return
        } else {
            backToast?.show()
        }
        backPressedTime = System.currentTimeMillis()

    }
}