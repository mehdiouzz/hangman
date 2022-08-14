package com.example.firstapp

//import io.ktor.*

//import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import java.io.IOException


class OldCodeActivityActivity : AppCompatActivity() ,View.OnClickListener{

    //    private val client = OkHttpClient()
//    private TextView mTextViewResul
    private var frame : RelativeLayout? = null
    private var mTextViewResult : TextView? = null
    private var mTextDefinition : TextView? = null
    private var mTextCounter : TextView? = null
    private var tmpword : TextView? = null
    private var toast: Toast? = null
    private var counter = 7
    private var randomword: String? = null
    private var definition: String? = null
    private var img :ImageView? = null
    private var hint: ImageButton? = null
    private var reload: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_old_code)

        toast = Toast.makeText(this,"please check your connection",Toast.LENGTH_SHORT)
        initgame()

        val q = findViewById<View>(R.id.q) as Button
        val w = findViewById<View>(R.id.w) as Button
        val e = findViewById<View>(R.id.e) as Button
        val r = findViewById<View>(R.id.r) as Button
        val t = findViewById<View>(R.id.t) as Button
        val y = findViewById<View>(R.id.y) as Button
        val u = findViewById<View>(R.id.u) as Button
        val i = findViewById<View>(R.id.i) as Button
        val o = findViewById<View>(R.id.o) as Button
        val p = findViewById<View>(R.id.p) as Button
        val a = findViewById<View>(R.id.a) as Button
        val s = findViewById<View>(R.id.s) as Button
        val d = findViewById<View>(R.id.d) as Button
        val f = findViewById<View>(R.id.f) as Button
        val g = findViewById<View>(R.id.g) as Button
        val h = findViewById<View>(R.id.h) as Button
        val j = findViewById<View>(R.id.j) as Button
        val k = findViewById<View>(R.id.k) as Button
        val l = findViewById<View>(R.id.l) as Button
        val z = findViewById<View>(R.id.z) as Button
        val x = findViewById<View>(R.id.x) as Button
        val c = findViewById<View>(R.id.c) as Button
        val v = findViewById<View>(R.id.v) as Button
        val b = findViewById<View>(R.id.b) as Button
        val n = findViewById<View>(R.id.n) as Button
        val m = findViewById<View>(R.id.m) as Button

        q.setOnClickListener(this)
        w.setOnClickListener(this)
        e.setOnClickListener(this)
        r.setOnClickListener(this)
        t.setOnClickListener(this)
        y.setOnClickListener(this)
        u.setOnClickListener(this)
        i.setOnClickListener(this)
        o.setOnClickListener(this)
        p.setOnClickListener(this)
        a.setOnClickListener(this)
        s.setOnClickListener(this)
        d.setOnClickListener(this)
        f.setOnClickListener(this)
        g.setOnClickListener(this)
        h.setOnClickListener(this)
        j.setOnClickListener(this)
        k.setOnClickListener(this)
        l.setOnClickListener(this)
        z.setOnClickListener(this)
        x.setOnClickListener(this)
        c.setOnClickListener(this)
        v.setOnClickListener(this)
        b.setOnClickListener(this)
        n.setOnClickListener(this)
        m.setOnClickListener(this)

//        reload.setOnClickListener(this)


//        mTextViewResult = findViewById<View>(R.id.radomword) as TextView
//        mTextDefinition = findViewById<View>(R.id.definition) as TextView
//        mTextCounter = findViewById<View>(R.id.counter) as TextView
//        mTextCounter?.text = counter.toString()
//
//        tmpword = findViewById<View>(R.id.tmpword) as TextView

        fetchword()
    }

    private fun initgame(){
        frame = findViewById<View>(R.id.frame) as RelativeLayout
        mTextViewResult = findViewById<View>(R.id.radomword) as TextView
        mTextDefinition = findViewById<View>(R.id.definition) as TextView
        mTextCounter = findViewById<View>(R.id.counter) as TextView
        img = findViewById<View>(R.id.canvas) as ImageView
        hint = findViewById<View>(R.id.hint) as ImageButton
        reload = findViewById<View>(R.id.reload) as ImageButton

        tmpword = findViewById<View>(R.id.tmpword) as TextView
    }

    private fun fetchword(){
        runOnUiThread {
            Thread(Runnable() {
//                @Override
//                fun run() {
                try {

                    val doc = Jsoup.connect("https://randomword.com/vocabulary").get() as Document
                    frame!!.visibility = View.VISIBLE
//                 Log.i("DOC", doc.toString().toString());
                    val elementsHtml = doc.getElementById("random_word") as Element
//                    println("this is from thread $elementsHtml")
                    val word = elementsHtml.text()
//                val define = doc.getElementById("random_word_definition")?.text()
//                println("$word == $define")
                    randomword = word.toString().uppercase()
                    definition = doc.getElementById("random_word_definition")?.text()
                    mTextViewResult!!.text = "-".repeat(randomword!!.length)
                    mTextCounter!!.text = randomword!!.length.toString().plus(" letters  | Counter = ").plus(counter.toString())
//                tmpword!!.text = randomword
                }
                catch (e : IOException){

                    frame!!.visibility = View.INVISIBLE
//                    val mainHandler = Handler(Looper.getMainLooper())
//
//                    mainHandler.post(object : Runnable {
//                        override fun run() {
//                            initgame()
                    toast?.show()
//                            mainHandler.postDelayed(this, 3000)
//                        }
//                    })
//                    val raw2 = findViewById<View>(R.id.raw2) as LinearLayout
//                    raw2.visibility = View.INVISIBLE
//                    val raw3 = findViewById<View>(R.id.raw3) as LinearLayout
//                    raw3.visibility = View.INVISIBLE
//                    val raw4 = findViewById<View>(R.id.raw4) as LinearLayout
//                    raw4.visibility = View.INVISIBLE
//                    val raw5 = findViewById<View>(R.id.raw5) as LinearLayout
//                    raw5.visibility = View.INVISIBLE

//                    finish()
//                    startActivity(getIntent())
//                    intent = Intent(this, NetworkActivity::class.java)
//                    startActivity(intent)
//                    finish()
//                    mTextViewResult!!.text= "please check your connection"
//                    println("#######   connection exception "+ e)
                }

//                    runOnUiThread { mTextViewResult.text = elementsHtml.toString() }
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//                }
            }).start()
        }
    }

    override fun onClick(view: View) {

//        if(view.id.toString() == "hint"){
//            println("#############")
//            hint()
//            view.setClickable(false)
//            return
//        }

        val inp = view as Button
//       ------ if the reload is clicked -----
//        if (inp.text.toString() == "Reload"){
////            fetchword()
//            finish()
//            startActivity(getIntent())
//            overridePendingTransition(androidx.navigation.ui.R.anim.abc_shrink_fade_out_from_bottom, androidx.navigation.ui.R.anim.abc_shrink_fade_out_from_bottom);
//            return
//        }
        checkletter(inp.text as String, inp)
        inp.setBackgroundColor(Color.GRAY)

        checkcounter()
        inp.setClickable(false)
        updateImage()
    }

    private fun updateImage() {
//        var imgName = "hangman".plus(counter)
//        val image = R.drawable.imgName as Drawable
//        img!!.setImageResource(R.drawable.image)

        var imageName = "hangman".plus(6-counter) as String
        var  resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
//        ImageView image;
        img!!.setImageResource(resID );
    }

    private fun writeLetter(lett : String, arr : ArrayList<Int>) {

        var txt = mTextViewResult!!.text.toString()

        for (indice in arr){

            txt = txt.substring(0, indice) + lett + txt.substring(indice + 1)
        }
        mTextViewResult!!.text = txt
    }

    private fun checkletter(lett: String, butt : Button){

        if (!butt.isClickable) return
        if (randomword?.contains(lett, ignoreCase = true)!!)
        {
            val indexes = Regex(lett).findAll(randomword!!)
                .map { it.range.first }
                .toList()
//
            println(indexes)
            writeLetter(butt.text as String, ArrayList(indexes) )
            return
        }
        counter--
        mTextCounter?.text = randomword!!.length.toString().plus(" letters  | Counter = ").plus(counter.toString())
    }

    private fun checkcounter(){
        if(this.counter === 0) {
            mTextCounter!!.text = "Game Over"
            endgame()
        }
        if (!mTextViewResult!!.text.contains("-") && counter != 0) {
            mTextCounter!!.text = "you won"
            endgame()
        }
        if (counter == 3)
            hint!!.visibility = View.VISIBLE
    }

//    private fun wingame() {
//        mTextViewResult!!.text = randomword
//        mTextDefinition!!.text = definition
////        mTextCounter!!.text = "you won"
//    }

    private fun endgame(){
        mTextViewResult!!.text = randomword
        mTextDefinition!!.text = definition
        mTextDefinition!!.visibility = View.VISIBLE
    }

    fun displayHint(v : View){
        var bt = v as ImageButton
        v.setClickable(false)
        mTextDefinition!!.text = definition
        mTextDefinition!!.visibility = View.VISIBLE
    }
    fun reload(v : View){
        intent = Intent(this, EasyActivity::class.java)
        startActivity(intent)
        finish()
//        this.finish()
//        this.startActivity(EasyActivity)
//        overridePendingTransition(androidx.navigation.ui.R.anim.abc_shrink_fade_out_from_bottom, androidx.navigation.ui.R.anim.abc_shrink_fade_out_from_bottom);
    }
}


