package com.example.ideas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.example.myapplication.Main4Activity
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    lateinit var data:OrData

    override fun onCreate(savedInstanceState: Bundle?) {

        data = intent.getParcelableExtra<OrData>(EXTRA_DATA)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
    }
        fun choseGlasses(view:View){
            data.glasses = "glasses"
            glassesBtn.isChecked = true
            noGlassesBtn.isChecked = false
        }

        fun choseNoGlasses(view: View){
            data.glasses = "noglasses"
            glassesBtn.isChecked = false
            noGlassesBtn.isChecked = true
        }

        fun toActivity4(view : View){

            var activity4 = Intent(this, Main4Activity::class.java)
            activity4.putExtra(EXTRA_DATA, data)
            startActivity(activity4);

        }
    }



