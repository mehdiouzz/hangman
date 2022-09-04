package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


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
//        finish()
    }

    fun HardGame(v : View){
        intent = Intent(this, HardActivity::class.java)
        startActivity(intent)
//        finish()
    }

    fun settings(v : View){
        intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    fun idioms(v : View){
        intent = Intent(this, IdiomsActivity::class.java)
        startActivity(intent)
    }

    fun lvls(v : View){
        intent = Intent(this, stageActivity::class.java)
        startActivity(intent)
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


