package com.App.maytinh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var isOperate = true
    private var afterCaculate = false
    private var isDotN1 = false
    private var isDotN2 = false
    private var timeClickN1 = false
    private var timeClickN2 = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun onDigit(view:View){
        var operate : TextView = findViewById(R.id.operator)
        var number2 :TextView = findViewById(R.id.number2)
        var number1: TextView = findViewById(R.id.number1)


            if(!operate.text.isEmpty()){
                number2.append((view as Button).text)
                isDotN2 = true
                view.setBackgroundResource(R.drawable.border_button)
            }else{
                view.setBackgroundResource(R.drawable.border_button)
                number1.append((view as Button).text)
                isDotN1 = true
        }

    }

    fun onOperator(view:View){
        var operate : TextView = findViewById(R.id.operator)
        view.setBackgroundResource(R.drawable.border_button)
        operate.append((view as Button).text)
        var number2 :TextView = findViewById(R.id.number2)
        var number1: TextView = findViewById(R.id.number1)

        if(afterCaculate){
            number1.setText(number2.text)
            number2.setText("")
        }
    }
    fun onDecimalPoint(view:View){
        view.setBackgroundResource(R.drawable.border_button)
        var number2 :TextView = findViewById(R.id.number2)
        var number1: TextView = findViewById(R.id.number1)

        if(number1.text.startsWith(".") ||number2.text.startsWith(".") ){
            isDotN1 = false
            isDotN2 = false
        }
        else if(isDotN1 && !timeClickN1){
            number1.append(".")
            isDotN1 = false
            timeClickN1 = true
        }else if(isDotN2 && !timeClickN2){
            isDotN2= false
            timeClickN2 = true
            number2.append(".")
        }

    }
    fun onEquals(view : View){
        view.setBackgroundResource(R.drawable.border_button)
        var number2 :TextView = findViewById(R.id.number2)
        var number1: TextView = findViewById(R.id.number1)
        var operate : TextView = findViewById(R.id.operator)
        var result : Double = 0.0
        when(operate.text.toString()){
            "+" -> result = number1.text.toString().toDouble() + number2.text.toString().toDouble()
            "-" -> result =  number1.text.toString().toDouble() - number2.text.toString().toDouble()
            "*" -> result =  number1.text.toString().toDouble() * number2.text.toString().toDouble()
            "/" -> result =  number1.text.toString().toDouble() / number2.text.toString().toDouble()
        }
        number1.setText("")
        number2.setText(result.toString())
        operate.setText("")
        afterCaculate = true
        isDotN1 = false
        isDotN2 = false

    }
    fun onClear(view: View){
        view.setBackgroundResource(R.drawable.border_button)
        var number2 :TextView = findViewById(R.id.number2)
        var number1: TextView = findViewById(R.id.number1)
        var operate : TextView = findViewById(R.id.operator)
        afterCaculate = false
        isDotN1 = false
        isDotN2 = false
        number1.setText("")
        number2.setText("")
        operate.setText("")
    }

}