package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.example.myapplication.databinding.ActivityLocationBinding

class location : AppCompatActivity() {

 private val binding:ActivityLocationBinding by lazy{
         ActivityLocationBinding.inflate(layoutInflater)
 }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val locationList:Array<String>  =  arrayOf("patna" , "darbhanga","simrahi")
        val adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,locationList)
        val autoCompleteTextView= binding.locationlist
        autoCompleteTextView.setAdapter(adapter)

    }
}