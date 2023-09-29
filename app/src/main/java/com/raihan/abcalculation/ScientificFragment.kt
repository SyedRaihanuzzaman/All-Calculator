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
    private lateinit var binding:FragmentScientificBinding



    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScientificBinding.inflate(layoutInflater, container, false)

          binding.btnAc.setOnClickListener{
              binding.workingsTV.text = ""
              binding.resultTV.text = ""
          }
        /*binding.btnSin.setOnClickListener {
            val operand = binding.workingsTV.text.toString()
            val result = Math.sin(Math.toRadians(operand.toDouble()))
            binding.workingsTV.text = result.toString()
        }*/


        binding.btn0.setOnClickListener {
            binding.workingsTV.append("0")
        }
        binding.btn1.setOnClickListener {
            binding.workingsTV.append("1")
        }
        binding.btn2.setOnClickListener {
            binding.workingsTV.append("2")
        }
        binding.btn3.setOnClickListener {
            binding.workingsTV.append("3")
        }
        binding.btn4.setOnClickListener {
            binding.workingsTV.append("4")
        }
        binding.btn5.setOnClickListener {
            binding.workingsTV.append("5")
        }
        binding.btn6.setOnClickListener {
            binding.workingsTV.append("6")
        }
        binding.btn7.setOnClickListener {
            binding.workingsTV.append("7")
        }
        binding.btn8.setOnClickListener {
            binding.workingsTV.append("8")
        }
        binding.btn9.setOnClickListener {
            binding.workingsTV.append("9")
        }
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
        binding.btnStartBracket.setOnClickListener {
            binding.workingsTV.append("(")
        }
        binding.btnEndBracket.setOnClickListener {
            binding.workingsTV.append(")")
        }
        binding.btnDot.setOnClickListener {
            binding.workingsTV.append(".")
        }

        binding.btnAddition.setOnClickListener {
            binding.workingsTV.append("+")
        }
        binding.btnSubstraction.setOnClickListener {
            binding.workingsTV.append("-")
        }
        binding.btnDivision.setOnClickListener {
            binding.workingsTV.append("/")
        }
        binding.btnMultiplication.setOnClickListener {
            binding.workingsTV.append("×")
        }
        binding.btnFactorial.setOnClickListener {
            binding.workingsTV.append("!")
        }

        binding.btnEqual.setOnClickListener {
            val expression = ExpressionBuilder(binding.workingsTV.text.toString()).build()
            val result = expression.evaluate()
            val longresult = result.toLong()

            if(result==longresult.toDouble()){
                binding.resultTV.text = longresult.toString()

            }else{
                binding.resultTV.text = result.toString()
            }
        }


        return binding.root
    }


    }























