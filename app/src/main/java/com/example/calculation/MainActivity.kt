package com.example.calcul_epta

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calcul_epta.R
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var zeroBtn: TextView
    private lateinit var oneBtn: TextView
    private lateinit var twoBtn: TextView
    private lateinit var threeBtn: TextView
    private lateinit var fourBtn: TextView
    private lateinit var fiveBtn: TextView
    private lateinit var sixBtn: TextView
    private lateinit var sevenBtn: TextView
    private lateinit var eightBtn: TextView
    private lateinit var nineBtn: TextView
    private lateinit var dotBtn: TextView
    private lateinit var buttonPlus: TextView
    private lateinit var buttonMinus: TextView
    private lateinit var buttonDivide: TextView
    private lateinit var buttonMultiply: TextView
    private lateinit var buttonDelete: TextView
    private lateinit var buttonOpenBracket: TextView
    private lateinit var buttonCloseBracket: TextView
    private lateinit var buttonAC: TextView
    private lateinit var buttonEquals: TextView
    private lateinit var mathOperationView: TextView
    private lateinit var resultOperationView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zeroBtn = findViewById(R.id.btn_0)
        oneBtn = findViewById(R.id.btn_1)
        twoBtn = findViewById(R.id.btn_2)
        threeBtn = findViewById(R.id.btn_3)
        fourBtn = findViewById(R.id.btn_4)
        fiveBtn = findViewById(R.id.btn_5)
        sixBtn = findViewById(R.id.btn_6)
        sevenBtn = findViewById(R.id.btn_7)
        eightBtn = findViewById(R.id.btn_8)
        nineBtn = findViewById(R.id.btn_9)
        dotBtn = findViewById(R.id.btn_dot)
        buttonPlus = findViewById(R.id.plus_btn)
        buttonMinus = findViewById(R.id.minus_btn)
        buttonDivide = findViewById(R.id.divide_btn)
        buttonMultiply = findViewById(R.id.multiply_btn)
        buttonDelete = findViewById(R.id.btn_delite)
        buttonOpenBracket = findViewById(R.id.firstBracket_btn)
        buttonCloseBracket = findViewById(R.id.secondBracket_btn)
        buttonAC = findViewById(R.id.AC_btn)
        buttonEquals = findViewById(R.id.equals_btn)
        mathOperationView = findViewById(R.id.math_operation)
        resultOperationView = findViewById(R.id.result_text)

        zeroBtn.setOnClickListener {setTextFields("0")}
        oneBtn.setOnClickListener {setTextFields("1")}
        twoBtn.setOnClickListener {setTextFields("2")}
        threeBtn.setOnClickListener {setTextFields("3")}
        fourBtn.setOnClickListener {setTextFields("4")}
        fiveBtn.setOnClickListener {setTextFields("5")}
        sixBtn.setOnClickListener {setTextFields("6")}
        sevenBtn.setOnClickListener {setTextFields("7")}
        eightBtn.setOnClickListener {setTextFields("8")}
        nineBtn.setOnClickListener {setTextFields("9")}
        dotBtn.setOnClickListener {setTextFields(".")}
        buttonPlus.setOnClickListener {setTextFields("+")}
        buttonMinus.setOnClickListener {setTextFields("-")}
        buttonMultiply.setOnClickListener {setTextFields("*")}
        buttonDivide.setOnClickListener {setTextFields("/")}
        buttonOpenBracket.setOnClickListener {setTextFields("(")}
        buttonCloseBracket.setOnClickListener {setTextFields(")")}

        buttonAC.setOnClickListener {
            mathOperationView.text = ""
            resultOperationView.text = ""
        }

        buttonDelete.setOnClickListener{
            val str = mathOperationView.text.toString()
            if(str.isNotEmpty())
                mathOperationView.text = str.substring(0, str.length - 1)
        }

        buttonEquals.setOnClickListener {
            try {
                val ex = ExpressionBuilder(mathOperationView.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()
                if(result==longRes.toDouble())
                    resultOperationView.text = longRes.toString()
                else
                    resultOperationView.text = result.toString()
            } catch(e:Exception) {
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }
    }
    private fun setTextFields(str: String)    {
        if(resultOperationView.text != "")  {
            mathOperationView.text = resultOperationView.text
            resultOperationView.text = ""
        }
        mathOperationView.append(str)
    }

}

