package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
    fun OnDigit(view: View){
        Toast.makeText(this,"ButtonClicked",Toast.LENGTH_SHORT).show()
        var Btn7:Button= findViewById(R.id.Btn7)
        Btn7.setOnClickListener(){

        }
    }
}