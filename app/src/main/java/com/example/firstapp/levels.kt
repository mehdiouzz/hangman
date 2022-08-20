package com.example.firstapp

import android.animation.ValueAnimator
import android.content.SharedPreferences
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.apache.commons.lang3.StringUtils


open class levels : AppCompatActivity(), View.OnClickListener{

    protected var url : String? = null
    protected var frame : RelativeLayout? = null
    protected var mTextViewResult : TextView? = null
    protected var mTextDefinition : TextView? = null
    protected var mTextCounter : TextView? = null
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
    protected var warnViewed = false
    val letters = arrayOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")
    val dict = mapOf("A" to 1,"B" to 3,"C" to 3,"D" to 2,"E" to 1,"F" to 4,"G" to 2,"H" to 4,"I" to 1,"J" to 7,"K" to 5,"L" to 1,"M" to 3,"N" to 1,"O" to 1,"P" to 3,"Q" to 1,"R" to 1,"S" to 1,"T" to 1,"U" to 1,"V" to 4,"W" to 4,"X" to 8,"Y" to 4,"Z" to 8)
    protected var score = 0
    protected var revealed = false

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

    protected final var sd : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toast = Toast.makeText(this,"please check your connection",Toast.LENGTH_SHORT)

    }

    fun loopButtons(){

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

        lvl = findViewById<View>(R.id.lvl) as? TextView
//        lvl?.text = this.localClassName
    }

//    protected open fun fetchword(){
//        runOnUiThread {
//            Thread(Runnable() {
////                @Override
////                fun run() {
//                try {
//                    var word = "--"
//                    var doc : Document? = null
//                    var elementsHtml : Element
//                    while (!word.matches("^[a-zA-Z]*$".toRegex()) ){
//                        doc = Jsoup.connect(url.toString()).get() as Document
//                        frame?.visibility = View.VISIBLE
//                        elementsHtml = doc.getElementById("random_word") as Element
//                        word = elementsHtml.text()
//                    }
////                    word = "--jj--"
////                    word = word.replace("-"," ")
//                    randomword = word.toString().uppercase()
//                    definition = doc?.getElementById("random_word_definition")?.text()
//
//                    mTextViewResult?.text = "-".repeat(randomword!!.length)
//                    mTextCounter?.text = randomword?.length.toString().plus(" letters ")
//                }
//                catch (e : IOException){
//
//                    frame?.visibility = View.INVISIBLE
//                    toast?.show()
//                }
//            }).start()
//        }
//    }

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
            score += indexes.size * dict[lett]!!
            lvl?.text = score.toString()
            return
        }
        counter--
    }

    protected open fun checkcounter() {
        when (this.counter) {
            0 -> endgame(lossMsg)
            3 -> {
                hint?.visibility = View.VISIBLE
            }
            1 -> {
                if (warnViewed == false) {
//                    val warnsound = MediaPlayer.create(this, R.raw.danger)
//                    warnsound?.start()
                    val inflater = getLayoutInflater();
                    val view = inflater.inflate(R.layout.warning, findViewById(R.id.popup));
                    val dtoast = Toast(this);
                    dtoast.setView(view);
                    dtoast!!.setGravity(Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL, 0, 0)
                    dtoast.show();
                    warnViewed = true
                }
            }
        }
        if (!mTextViewResult!!.text.contains("-") && counter != 0) {
            if (counter == 7 && !revealed)
                winMsg = "Perfect Score"
            endgame(winMsg)
        }


    }

    protected fun endgame(outputMsg : String){
        mTextViewResult?.text = randomword
        mTextDefinition?.text = definition
        mTextDefinition?.visibility = View.VISIBLE
        val keyboard = findViewById<View>(R.id.keyboard)
        keyboard?.visibility = View.INVISIBLE

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
        reveal?.isClickable = false
        for (itr in letters) {
            val bttns = resources.getIdentifier(itr, "id", packageName)
            findViewById<TextView>(bttns).isClickable = false
        }
        onButtonShowPopupWindowClick(outputMsg)


//        bonus.visibility = View.INVISIBLE
//        reveal?.translationY
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


        val bonus = popupView?.findViewById<View>(R.id.bonus) as TextView
        if(outputMsg === lossMsg){
            score = 0
            bonus?.visibility = View.INVISIBLE
        }
        else
        {
            if (!revealed && winMsg === "Perfect Score") {
                score += 10
                bonus?.text = "+10"
            }
            else
                score += 5

            val valueAnimator = ValueAnimator.ofFloat(msg!!.y, msg!!.y-400).apply {
                interpolator = LinearInterpolator()
                duration = 1500
            }
            valueAnimator.addUpdateListener {
                val value = it.animatedValue as Float
                bonus?.translationY = value
            }
            valueAnimator.start()
        }

        val scor = popupView?.findViewById<View>(R.id.score) as? TextView
        scor?.text = scor?.text.toString().plus(score.toString())
        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.setOutsideTouchable(false)
//        popupWindow.setIgnoreCheekPress()
        disableButtons()
        popupWindow.showAtLocation(hint, Gravity.TOP, width, height)
        println("############## " + counter)
        savedata()
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

        val bttns = resources.getIdentifier(lett.lowercase(), "id", packageName)
        val btt = findViewById<TextView>(bttns)
        btt.setBackgroundColor(Color.GRAY)
        btt.setClickable(false)


        val indexes = Regex(lett).findAll(randomword!!)
            .map { it.range.first }
            .toList()

        writeLetter(lett, ArrayList(indexes) )
        v.setClickable(false)
        v.setBackgroundResource(R.drawable.hidden)
        revealed = true

        score += indexes.size * dict[lett]!!

        val res = StringUtils.difference(mTextViewResult!!.text as String?, randomword ).toString()
        if (res == "")
            endgame(winMsg)
    }

    fun reload(){
        this.finish()
        this.startActivity(this.getIntent())
//        overridePendingTransition(androidx.navigation.ui.R.anim.abc_shrink_fade_out_from_bottom, androidx.navigation.ui.R.anim.abc_shrink_fade_out_from_bottom);
    }

    fun reload(v : View){
        this.finish()
        this.startActivity(this.getIntent())
    }

    fun goback(v : View){
        onBackPressed()
    }

    fun guess(v : View){

    }

    override fun onClick(view: View) {
        val inp = view as Button

        checkletter(inp.text as String, inp)
        inp.setBackgroundColor(Color.GRAY)
        sd?.start()

        checkcounter()
        inp.setClickable(false)
        updateImage()
    }

    fun savedata(){
//        val editor: SharedPreferences.Editor = sharedPreferences.edit()
//        editor.putString(keyString, valueString)
//        editor.commit()
        val settings = applicationContext.getSharedPreferences("StateOfApp", 0) as SharedPreferences
        val editor = settings.edit()
        editor.putInt("Score", score)
        editor.commit()

// Apply the edits!

// Apply the edits!
        editor.apply()

// Get from the SharedPreferences

// Get from the SharedPreferences
//
    }

//    private var backToast : Toast? = null
//    private var backPressedTime:Long = 0
//
//    override fun onBackPressed() {
////            if(backtoast!=null && backtoast!!.getView()?.getWindowToken() !=null) {
////                finish();
////            } else {
////                backtoast = Toast.makeText(this, "Press back to exit", Toast.LENGTH_SHORT)
////                backtoast?.show()
////            }
//
//        backToast = Toast.makeText(this, "Press back again to leave the app.", Toast.LENGTH_LONG)
//        if (backPressedTime + 2000 > System.currentTimeMillis()) {
//            backToast?.cancel()
//            super.onBackPressed()
//            return
//        } else {
//            backToast?.show()
//        }
//        backPressedTime = System.currentTimeMillis()
//
//    }
}