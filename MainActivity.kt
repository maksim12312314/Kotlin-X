package com.example.ideas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class OrData(var selected:String?="", var glasses:String?=""):Parcelable {
    var textList = listOf("Sergay", "Danya", "Maxx")

    constructor(parcel: Parcel) :this (
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(selected)
        parcel.writeString(glasses)
        parcel.writeStringList(textList)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OrData> {
        override fun createFromParcel(parcel: Parcel): OrData {
            return OrData(parcel)
        }

        override fun newArray(size: Int): Array<OrData?> {
            return arrayOfNulls(size)
        }
    }
}

const val EXTRA_DATA  = "data"
const val TAG_INFO = "info"

class MainActivity : AppCompatActivity() {

        lateinit var rideClass:OrData

    override fun onCreate(savedInstanceState: Bundle?) {

        rideClass = OrData()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun seregaClicked(view : View){

        rideClass.selected = "serega"
        SergayBtn.isChecked = true
        DanyaBtn.isChecked = false
        MaxxBtn.isChecked = false
    }

    fun danyaClicked(view : View){
        rideClass.selected = "danya"
        SergayBtn.isChecked = false
        DanyaBtn.isChecked = true
        MaxxBtn.isChecked = false

    }

    fun maxxClicked(view : View){
        rideClass.selected = "maxx"
        SergayBtn.isChecked = false
        DanyaBtn.isChecked = false
        MaxxBtn.isChecked = true

    }

    fun gotoGlass(view: View) {
        if (rideClass.selected != "") {
            val glassIntent = Intent(this, Main3Activity::class.java)
            glassIntent.putExtra(EXTRA_DATA, rideClass)
            startActivity(glassIntent)
        } else{
            Log.i(TAG_INFO, "none selected")
        }
    }

}
