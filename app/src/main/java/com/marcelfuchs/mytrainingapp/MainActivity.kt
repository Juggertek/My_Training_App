package com.marcelfuchs.mytrainingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Liste mit 2 String erstellen
    val mWordList: ArrayList<String> = ArrayList(listOf<String>("Fenster", "Haus", "Auto"))

    // Variable für neues Wort instanzieren/deklarieren
    val enteredWord: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvStringList.layoutManager = LinearLayoutManager(this)
        rvStringList.adapter = RecyclerViewAdapter(mWordList)

        btnAdd.setOnClickListener { addWord() }
        btnRemove.setOnClickListener { removeWord() }


    }


    private fun addWord() {
        mWordList.add(etWord.text.toString())
    }

    private fun removeWord() {
        mWordList.remove(etWord.text.toString())
    }
}