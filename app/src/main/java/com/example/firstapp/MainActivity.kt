package com.example.firstapp

//import io.ktor.*

//import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.io.*


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startGame(v : View){
        val lvl = findViewById<View>(R.id.levels)
        val params = lvl.getLayoutParams()
        params.height = LinearLayout.LayoutParams.MATCH_PARENT
        lvl.setLayoutParams(params);
    }

    fun easyGame(v : View){
        intent = Intent(this, FacileActivity::class.java)
        startActivity(intent)
//        finish()
    }

    fun mediumGame(v : View){
        intent = Intent(this, MediumActivity::class.java)
        startActivity(intent)
        writefile()
//        finish()
    }

    fun HardGame(v : View){
        intent = Intent(this, HardActivity::class.java)
        startActivity(intent)
//        finish()
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

    private var FILE_NAME = "words.txt"

    @RequiresApi(Build.VERSION_CODES.N)
    fun writefile(){
//        val mytext = "This is from code"
//        var fos :FileOutputStream? = null;

        try {
//            var myExternalFile = File(getExternalFilesDir(.toString()),FILE_NAME)
//            val filename = fileName.text.toString()
            var myfile = File(getExternalFilesDir(null), FILE_NAME)
            var fis = FileInputStream(myfile);
            var inp =  DataInputStream(fis);
            var br = BufferedReader( InputStreamReader(inp));
            var strLine = br.readLines().random()
//            var myData : String
//            br.readLine()
//            for (i in br.lines()) {
//                strLine += i;
//            }
            println("########### " + strLine)
//            val file = File(getExternalFilesDir(null), "kotlinfile.txt")
//            file.appendText("$mytext")
//            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
//            fos.write(mytext.toByteArray());
//
////            mEditText.getText().clear();
//            Toast.makeText(this, "Saved to " + getExternalFilesDir(null) + "/" + FILE_NAME, Toast.LENGTH_LONG).show()
//            println("Saved to " + getFilesDir() + "/" + FILE_NAME)
        } catch (e : FileNotFoundException) {
            e.printStackTrace();
        } catch (e: IOException) {
            e.printStackTrace();
        }
//        } finally {
//            if (fos != null) {
//                try {
//                    fos.close();
//                } catch (e:IOException) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
}


