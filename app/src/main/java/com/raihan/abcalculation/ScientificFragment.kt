package com.raihan.abcalculation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.raihan.abcalculation.databinding.FragmentBMIBinding
import com.raihan.abcalculation.databinding.FragmentScientificBinding
import net.objecthunter.exp4j.ExpressionBuilder


class ScientificFragment : Fragment() {
    private lateinit var binding: FragmentScientificBinding
    private var bracketOpenCount = 0
    private var bracketCloseCount = 0


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScientificBinding.inflate(layoutInflater, container, false)
        binding.btnAc.setOnClickListener { onClear(it) }
        binding.btnBack.setOnClickListener { onBksp(it) }
        binding.btn0.setOnClickListener { onDigit(it) }
        binding.btn1.setOnClickListener { onDigit(it) }
        binding.btn2.setOnClickListener { onDigit(it) }
        binding.btn3.setOnClickListener { onDigit(it) }
        binding.btn4.setOnClickListener { onDigit(it) }
        binding.btn5.setOnClickListener { onDigit(it) }
        binding.btn6.setOnClickListener { onDigit(it) }
        binding.btn7.setOnClickListener { onDigit(it) }
        binding.btn8.setOnClickListener { onDigit(it) }
        binding.btn9.setOnClickListener { onDigit(it) }
        binding.btnDot.setOnClickListener { decimalPoint(it) }
        binding.btnAddition.setOnClickListener { onOperator(it) }
        binding.btnSubstraction.setOnClickListener { onOperator(it) }
        binding.btnDivision.setOnClickListener { onOperator(it) }
        binding.btnMultiplication.setOnClickListener { onOperator(it) }
        binding.btnEqual.setOnClickListener { onEqual(it) }
        binding.btnSin.setOnClickListener {
            binding.workingsTV.append("sin")
        }
        binding.btnCos.setOnClickListener {
            binding.workingsTV.append("cos")
        }
        binding.btnTan.setOnClickListener {
            binding.workingsTV.append("tan")
        }
        binding.btnLog.setOnClickListener {
            binding.workingsTV.append("log")
        }
        binding.btnIn.setOnClickListener {
            binding.workingsTV.append("In")
        }
        binding.btnFactorial.setOnClickListener {
            binding.workingsTV.append("!")
        }
        binding.btnSquare.setOnClickListener {
            binding.workingsTV.append("^")
        }
        binding.btnRootover.setOnClickListener {
            binding.workingsTV.append("√")
        }
        binding.btn1byx.setOnClickListener {
            binding.workingsTV.append("1/")
        }
        binding.btnStartBracket.setOnClickListener {
            binding.workingsTV.append("(")
        }
        binding.btnEndBracket.setOnClickListener {
            binding.workingsTV.append(")")
        }

      /*  fun onBracketOpen(view: View) {
            if (num && !dot) {
                binding.workingsTV.append("(")
                num = false
                dot = false
                bracketOpenCount++
            }
        }

        fun onBracketClose(view: View) {
            if (num && bracketOpenCount > bracketCloseCount) {
                binding.workingsTV.append(")")
                num = false
                dot = false
                bracketCloseCount++
            }
        }*/




        return binding.root
    }

    var dot:Boolean = false
    var num:Boolean = false

    fun onClear(view: View) {
        binding.workingsTV.text = ""
        binding.resultTV.text = ""

        num=false
        dot=false
    }
    fun onBksp(view: View) {
        val string = binding.workingsTV.text.toString()
        if(string.isNotEmpty()){
            binding.workingsTV.text = string.substring(0,string.length-1)
        }
    }
    fun onDigit(view: View) {
        if (binding.workingsTV.text == "0"){
            binding.workingsTV.text = ""
        }
        binding.workingsTV.append((view as Button).text)
        num= true
        dot = false
    }
    fun decimalPoint(view: View) {
        if (num && !dot){
            binding.workingsTV.append(".")
            dot= true
            num= false
        }
    }
    fun onOperator(view: View) {
        if(num && !isoperatorthere(binding.workingsTV.text.toString())){
            binding.workingsTV.append((view as Button).text)
            num=false
            dot=false
        }
    }

    private fun isoperatorthere(value: String): Boolean {
        return if (value.startsWith("-")){
            false
        }

        else {
            value.contains("+") || value.contains("-") || value.contains("*") || value.contains("÷") || value.contains("%")
        }

    }

    fun onEqual(view: View) {
        if (num) {

            var value = binding.workingsTV.text.toString()
            var prefixcheckker = ""

            try { // In try block cuz some people do division by zero....

                if (value.startsWith("-")) {
                    prefixcheckker = "-"
                    value = value.substring(1)
                }

                if (value.contains("-")) {
                    val splitvalue = value.split("-")
                    var num1 = splitvalue[0]
                    var num2 = splitvalue[1]

                    if (!prefixcheckker.isEmpty()) {
                        num1 = prefixcheckker + num1
                    }



                    binding.resultTV.text = reducezeroes((num1.toDouble() - num2.toDouble()).toString())
                }

                else if (value.contains("+")){
                    val splitvalue = value.split("+")
                    var num1 = splitvalue[0]
                    var num2 = splitvalue[1]

                    if (!prefixcheckker.isEmpty()) {
                        num1 = prefixcheckker + num1
                        binding.resultTV.text = reducezeroes((num1.toDouble() + num2.toDouble()).toString())
                    }

                    else{
                        binding.resultTV.text = reducezeroes((num1.toDouble() + num2.toDouble()).toString())
                    }
                }

                else if (value.contains("*")){
                    val splitvalue = value.split("*")
                    var num1 = splitvalue[0]
                    var num2 = splitvalue[1]

                    if (!prefixcheckker.isEmpty()) {
                        num1 = prefixcheckker + num1
                        binding.resultTV.text = reducezeroes((num1.toDouble() * num2.toDouble()).toString())
                    }

                    else{
                        binding.resultTV.text = reducezeroes((num1.toDouble() * num2.toDouble()).toString())
                    }
                }
                else if (value.contains("÷")){
                    val splitvalue = value.split("÷")
                    var num1 = splitvalue[0]
                    var num2 = splitvalue[1]

                    if (!prefixcheckker.isEmpty()) {
                        num1 = prefixcheckker + num1
                        binding.resultTV.text = (num1.toDouble() / num2.toDouble()).toString()
                    }

                    else{
                        binding.resultTV.text = (num1.toDouble() / num2.toDouble()).toString()
                    }
                }

                else if (value.contains("%")){
                    val splitvalue = value.split("%")
                    var num1 = splitvalue[0]
                    val num2 = splitvalue[1]

                    binding.resultTV.text = ((num1.toDouble() * num2.toDouble())/100).toString()
                }
                else if(value.contains("sin")){
                    binding.workingsTV.append((view as Button).text)
                    val splitvalue = value.split("sin")
                    var num1 = splitvalue[0]
                    var num2 = splitvalue[1]
                    val result = Math.sin(Math.toRadians(num2.toDouble()))
                    binding.workingsTV.text = result.toString()

                }
                else if(value.contains("cos")){
                    binding.workingsTV.append((view as Button).text)
                    val splitvalue = value.split("cos")
                    var num1 = splitvalue[0]
                    var num2 = splitvalue[1]
                    val result = Math.cos(Math.toRadians(num2.toDouble()))
                    binding.workingsTV.text = result.toString()

                }
                else if(value.contains("tan")){
                    binding.workingsTV.append((view as Button).text)
                    val splitvalue = value.split("tan")
                    var num1 = splitvalue[0]
                    var num2 = splitvalue[1]
                    val result = Math.tan(Math.toRadians(num2.toDouble()))
                    binding.workingsTV.text = result.toString()

                }
                else if(value.contains("log")){
                    binding.workingsTV.append((view as Button).text)
                    val splitvalue = value.split("log")
                    var num1 = splitvalue[0]
                    var num2 = splitvalue[1]
                    val result = Math.log10(num2.toDouble())
                    binding.workingsTV.text = result.toString()

                }
                else if(value.contains("in")){
                    binding.workingsTV.append((view as Button).text)
                    val splitvalue = value.split("in")
                    var num1 = splitvalue[0]
                    var num2 = splitvalue[1]
                    val result = Math.log(num2.toDouble())
                    binding.workingsTV.text = result.toString()

                }
                else if(value.contains("!")){
                    binding.workingsTV.append((view as Button).text)
                    val splitvalue = value.split("!")
                    var num1 = splitvalue[0]
                    var num2 = splitvalue[1]
                    var result = 1.0
                    for (i in 2..num1.toInt()) {
                        result *= i.toDouble()
                    }
                    binding.workingsTV.text = result.toString()

                }
                else if(value.contains("^")){
                    binding.workingsTV.append((view as Button).text)
                    val splitvalue = value.split("^")
                    var num1 = splitvalue[0]
                    var num2 = splitvalue[1]
                    val result = num1.toDouble() * num2.toDouble()
                    binding.workingsTV.text = result.toString()

                }
                else if(value.contains("√")){
                    binding.workingsTV.append((view as Button).text)
                    val splitvalue = value.split("√")
                    var num1 = splitvalue[0]
                    var num2 = splitvalue[1]
                    val result = Math.sqrt(num2.toDouble())
                    binding.workingsTV.text = result.toString()

                }
                else if(value.contains("√")){
                    binding.workingsTV.append((view as Button).text)
                    val splitvalue = value.split("√")
                    var num1 = splitvalue[0]
                    var num2 = splitvalue[1]
                    val result = Math.sqrt(num2.toDouble())
                    binding.workingsTV.text = result.toString()

                }
                else if(value.contains("1/")){
                    binding.workingsTV.append((view as Button).text)
                    val splitvalue = value.split("1/")
                    var num1 = splitvalue[0]
                    var num2 = splitvalue[1]
                    val result = 1.0 / num2.toDouble()
                    binding.workingsTV.text = result.toString()

                }




            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }catch (e: Exception) {
                e.printStackTrace()
                binding.resultTV.text = "Error"
            }

        }
    }

    private fun reducezeroes(result: String): String {
        var finalvalue = result

        if (result.contains(".0")){
            finalvalue = result.substring(0, result.length-2)
        }
        return finalvalue
    }




}
