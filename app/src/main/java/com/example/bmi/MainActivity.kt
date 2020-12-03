package com.example.bmi

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var weight : EditText
    lateinit var height : EditText
    lateinit var result : TextView
    lateinit var btn : Button
    lateinit var context: Context
    lateinit var coment : TextView
    lateinit var btn1 : Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weight = findViewById<EditText>(R.id.et1)
        height = findViewById<EditText>(R.id.et2)
        result = findViewById<TextView>(R.id.tv)
        btn = findViewById<Button>(R.id.btn)
        coment = findViewById<TextView>(R.id.COMMENT)
        btn1 = findViewById<Button>(R.id.btn1)

        context=this
        btn.setOnClickListener {

            var w = weight.text.toString().toFloat()
            var h = height.text.toString().toFloat()
            var r = w/(h*h)
            val n = r.toFloat()
            val net = StrictMath.abs(w - 25 * (h * h)).toFloat()
            val net1 = StrictMath.abs(16.5 * (h * h) - w).toFloat()

            result.text = "BMI ->" + r.toString()
            if(r>= 18.5 &&  r <25)
                coment.text="You are Fit"
            if (r<18.5)
                coment.text= "You need to gain Weight by  " + net1 + " Kg"
            if (r>25)
                coment.text= "You need to loose Weight by " + net + " Kg"


        }


        btn1.setOnClickListener {
            var intent = Intent(context, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}