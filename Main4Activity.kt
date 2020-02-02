
package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import com.example.ideas.EXTRA_DATA
import com.example.ideas.OrData
import com.example.ideas.R
import kotlinx.android.synthetic.main.activity_main4.*


class Main4Activity : AppCompatActivity() {

    lateinit var data:OrData

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)


        data = intent.getParcelableExtra(EXTRA_DATA)

        var adapter= ArrayAdapter(this, android.R.layout.simple_list_item_1, data.textList)
        myList.adapter = adapter
    }
}
