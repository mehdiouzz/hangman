package com.example.firstapp

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import java.io.*


class FacileActivity : levels(), View.OnClickListener {

    private val client = OkHttpClient()

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facile)

        url = "https://random-words-api.vercel.app/word"
        mTextDefinition = findViewById<View>(R.id.definition) as? TextView

//        setButtons()
        initgame()
//        hint?.isClickable = false
        fetchword()
//        loopButtons()
        writelistFile()
    }

//    override fun fetchword(){
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

    @RequiresApi(Build.VERSION_CODES.N)
    fun fetchword(){
        runOnUiThread {
            Thread(Runnable() {
////                @Override
//                fun run() {
                try {
                    val request = Request.Builder()
                        .url(url!!)
                        .build()

                    client.newCall(request).execute().use { response ->
                        if (!response.isSuccessful) throw IOException("Unexpected code $response")

                        for ((name, value) in response.headers) {
                            println("$name: $value")
                        }

//                        val jsonObject = JSONTokener(response.body.toString()).nextValue() as JSONObject

                        val body =response.body!!.string()
//                        println(body)
                        val bodytojson = JSONArray(body)
                        val value = bodytojson.getJSONObject(0)
//                        randomword = value.getString("word")
                        randomword = readfile().uppercase()
                        mTextViewResult?.text = "-".repeat(randomword!!.length)
                        mTextCounter?.text = randomword?.length.toString().plus(" letters ")
//                        println(value.getString("word"))
                        definition = fetchdefintion()
                        loopButtons()
                        hint?.isClickable = true
                        reveal?.isClickable = true

                    }
                }
                catch (e : IOException){
                    frame?.visibility = View.INVISIBLE
                    toast?.show()
                }
            }).start()
            }
        }

    private var FILE_NAME = "listword.txt"

    @RequiresApi(Build.VERSION_CODES.N)
    fun readfile(): String {

//        try {
            var myfile = File(getExternalFilesDir(null), FILE_NAME)
            var fis = FileInputStream(myfile);
            var inp =  DataInputStream(fis);
            var br = BufferedReader( InputStreamReader(inp));
//            var strLine = br.readLines().random()
            val linenum = (1..1000).shuffled().last()
//            val tmp = (1..52).random()
            var line = br.lines().skip((linenum).toLong()).findFirst().get()
//            var strLine = Files.readAllLines(Paths.get("words.txt")).get(32)
            return line

//
////            mEditText.getText().clear();
//            Toast.makeText(this, "Saved to " + getExternalFilesDir(null) + "/" + FILE_NAME, Toast.LENGTH_LONG).show()
//            println("Saved to " + getFilesDir() + "/" + FILE_NAME)
//        } catch (e : FileNotFoundException) {
//            e.printStackTrace();
//        } catch (e: IOException) {
//            e.printStackTrace();
//        } finally {
////            return strLine
//                }
//            }
//        }
    }

    fun writelistFile(){
        runOnUiThread {
            Thread(Runnable() {
////                @Override
//                fun run() {
                try {
                    val request = Request.Builder()
                        .url("https://jpst.it/2WKdO")
                        .build()

                    client.newCall(request).execute().use { response ->
                        if (!response.isSuccessful) throw IOException("Unexpected code $response")
//                        val jsonObject = JSONTokener(response.body.toString()).nextValue() as JSONObject

                        val body =response.body!!.string()
                        println("#### BODY = $body")
                    }
                }
                catch (e : IOException){
                    frame?.visibility = View.INVISIBLE
                    toast?.show()
                }
            }).start()
        }

//        val dir = File(this.getFilesDir(), "mydir");
//        if(!dir.exists()){
//            dir.mkdir();
//        }
//
//        try {
//            val gpxfile = File(dir, "FILE_NAME");
//            val writer = FileWriter(gpxfile);
//            writer.append("This is from app internal storage");
//            writer.flush();
//            writer.close();
//        } catch (e: Exception){
//            e.printStackTrace();
//        }
    }

    private fun fetchdefintion() : String {
//        runOnUiThread {
//            Thread(Runnable() {
////                @Override
////                fun run() {
//                    try {
                val ur = "https://api.dictionaryapi.dev/api/v2/entries/en/$randomword"
                val request = Request.Builder()
                    .url(ur)
                    .build()

                client.newCall(request).execute().use { response ->
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

//                    for ((name, value) in response.headers) {
//                        println("$name: $value")
//                    }

//                        val jsonObject = JSONTokener(response.body.toString()).nextValue() as JSONObject

                    val body = response.body!!.string()
//                        println(body)
                    val bodytojson = JSONArray(body).getJSONObject(0)
//                    val phonetic = bodytojson.getString("phonetic")
                    val jarray = bodytojson.getJSONArray("meanings").getJSONObject(0).getJSONArray("definitions")
                    val def = jarray.getJSONObject(0).getString("definition")
//                    definition = def

//                        val value = bodytojson.getJSONObject(0)
//                    println("https://api.dictionaryapi.dev/api/v2/entries/en/$randomword")
//                            if (phonetic != null)
//                                println("$phonetic : $def")
//                            else
//                    println("no phonetic : $def")
            return def
//                            mTextDefinition?.text = phonetic.plus(" : ").plus(def)
//                            mTextViewResult?.text = "phonetic.plus(plus(def)"
//                        println(bodytojson.getJSONObject(0).getString("word"))
//                        val jarray = JSONArray("[{\"Hello1\":\"1\"},{\"Hello2\":\"2\"}]")
//                        val jobj = jarray.getJSONObject(0).getString("Hello1")
//                        println("######## $jobj")
                }
//            } catch (e : IOException){
//                frame?.visibility = View.INVISIBLE
//                toast?.show()
//            }
//        }).start()
//        }
    }

    fun displayHint(v : View){
        v.setClickable(false)
        mTextDefinition!!.text = definition
        mTextDefinition!!.visibility = View.VISIBLE
        hint!!.setImageResource(R.drawable.lamp)
    }

//    override fun checkcounter() {
//        when (this.counter) {
//            0 -> endgame(lossMsg)
////            3 -> {
//////                hint?.visibility = View.VISIBLE
////                hint?.isClickable = true
////                hint!!.setImageResource(R.drawable.lampon)
////            }
//            1 -> {
//                if (warnViewed == false) {
//                    val inflater = getLayoutInflater();
//                    val view = inflater.inflate(R.layout.warning, findViewById(R.id.popup));
//                    val dtoast = Toast(this);
//                    dtoast.setView(view);
//                    dtoast!!.setGravity(Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL, 0, 0)
//                    dtoast.show();
//                    warnViewed = true
//                }
//            }
//        }
//        if (!mTextViewResult!!.text.contains("-") && counter != 0) {
//            endgame(winMsg)
//        }
//    }

    override fun onClick(view: View) {

        val inp = view as Button

        checkletter(inp.text as String, inp)
        inp.setBackgroundColor(Color.GRAY)

        checkcounter()
        inp.setClickable(false)
        updateImage()
    }

}