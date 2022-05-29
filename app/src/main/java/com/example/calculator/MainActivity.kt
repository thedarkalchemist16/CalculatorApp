package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {

    private var tvInput: TextView? = null
    private var LastNumeric:Boolean=false
    private var LastDot:Boolean=false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput=findViewById(R.id.TxtInput)

    }
    fun OnDigit(view: View){

        tvInput?.append((view as Button).text)
        LastNumeric=true
        LastDot=false

    }

    fun OnClear(view: View){
        tvInput?.text=""
    }

    fun OnDecimalPoint(view: View){
        if(LastNumeric&&!LastDot){
            tvInput?.append(".")
            LastNumeric=false
            LastDot=true
        }

    }

    fun OnOperator(view: View){
        tvInput?.text?.let {
            if(LastNumeric && !IsOperatorAdded(it.toString())){
                tvInput?.append((view as Button).text)
                LastNumeric=false
                LastDot=false

            }
        }

    }

    fun OnEqual(view: View){
        if(LastNumeric){
            var tvValue=tvInput?.text.toString()
            var prefix=""

            try{
                if(tvValue.startsWith("-")){
                    prefix="-"
                    tvValue=tvValue.substring(1)
                }

                if(tvValue.contains("-")){

                    val SplitValue=tvValue.split("-")
                    var one=SplitValue[0]
                    var two=SplitValue[1]

                    if(prefix.isNotEmpty()){
                        one=prefix+one
                    }

                    tvInput?.text=RemoveDotAfterZero((one.toDouble()-two.toDouble()).toString())
                }

                else if(tvValue.startsWith("+")){
                    prefix="+"
                    tvValue=tvValue.substring(1)
                }

                if(tvValue.contains("+")){

                    val SplitValue=tvValue.split("+")
                    var one=SplitValue[0]
                    var two=SplitValue[1]

                    if(prefix.isNotEmpty()){
                        one=prefix+one
                    }

                    tvInput?.text=RemoveDotAfterZero((one.toDouble()+two.toDouble()).toString())
                }

                else if (tvValue.startsWith("*")){
                    prefix="*"
                    tvValue=tvValue.substring(1)
                }

                if(tvValue.contains("*")){

                    val SplitValue=tvValue.split("*")
                    var one=SplitValue[0]
                    var two=SplitValue[1]

                    if(prefix.isNotEmpty()){
                        one=prefix+one
                    }

                    tvInput?.text=RemoveDotAfterZero((one.toDouble()*two.toDouble()).toString())
                }

                else if (tvValue.startsWith("/")){
                    prefix="/"
                    tvValue=tvValue.substring(1)
                }

                if(tvValue.contains("/")){

                    val SplitValue=tvValue.split("/")
                    var one=SplitValue[0]
                    var two=SplitValue[1]

                    if(prefix.isNotEmpty()){
                        one=prefix+one
                    }

                    tvInput?.text=RemoveDotAfterZero(((one.toDouble()/two.toDouble()).toString()))
                }


        }catch(e: ArithmeticException){
            e.printStackTrace()

            }        }
    }

    private fun RemoveDotAfterZero(result: String):String{
        var value=result
        if(result.contains(".0")){
            value=result.substring(0,result.length-2)
        }
        return value
    }


    private fun IsOperatorAdded (value:String):Boolean{
        return if(value.startsWith("-")){
            false
        }
        else(value.contains("+")
                || value.contains("*")
                || value.contains("/")
                || value.contains("-"))
    }
}