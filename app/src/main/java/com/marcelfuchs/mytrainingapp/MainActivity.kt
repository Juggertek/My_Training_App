package com.marcelfuchs.mytrainingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.marcelfuchs.mytrainingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Liste mit 2 String erstellen
    private val mWordList: ArrayList<String> = ArrayList(listOf("Fenster", "Haus", "Auto"))
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.rvStringList.layoutManager = LinearLayoutManager(this)
        binding.rvStringList.adapter = RecyclerViewAdapter(mWordList)

        binding.btnAdd.setOnClickListener { addWord() }
        binding.btnRemove.setOnClickListener { removeWord() }
    }


    private fun addWord() {
        mWordList.add(binding.etWord.text.toString())
        binding.rvStringList.adapter?.notifyDataSetChanged()
    }

    private fun removeWord() {
        mWordList.remove(binding.etWord.text.toString())
        binding.rvStringList.adapter?.notifyDataSetChanged()
    }
}