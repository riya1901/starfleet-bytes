package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity

import android.os.Bundle
import com.example.myapplication.databinding.ActivityDinerBinding

class Diner : AppCompatActivity() {
   private val binding:ActivityDinerBinding by lazy {
       ActivityDinerBinding.inflate(layoutInflater)
   }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.textgo.setOnClickListener{
            val intent= Intent(this,signup::class.java)
            startActivity(intent)
    }
}
}