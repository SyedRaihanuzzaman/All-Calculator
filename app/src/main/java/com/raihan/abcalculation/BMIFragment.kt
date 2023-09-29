package com.raihan.abcalculation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.raihan.abcalculation.databinding.FragmentBMIBinding


class BMIFragment : Fragment() {
    private lateinit var binding: FragmentBMIBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBMIBinding.inflate(layoutInflater, container, false)

        binding.button.setOnClickListener {
            val weight = binding.weightedtxt.text.toString()
            val height = binding.Hightedtxt.text.toString()

            if (validateInput(weight, height)) {
                val bmi =
                    weight.toDouble() / ((height.toDouble() / 100) * (height.toDouble() / 100))
                val bmiDigit = String.format("%.2f", bmi).toDouble()

                displayResult(bmiDigit)


            }


        }
        return binding.root
    }

    private fun displayResult(bmi: Double) {
        binding.resulttxt.text = bmi.toString()
        binding.bmi.text = "You are Healthy"
        binding.range.text = "Normal Change"

        var result = ""
        var color = 0
        var range = ""

        when{
            bmi<18.50 ->{
                result = "Underweight"
                color = R.color.under_weight
                range = "(Underweight range is less than 18.50)"
            }
            bmi in 18.50..24.99 ->{
                result = "Healthy"
                color = R.color.normal
                range = "(Healthy range is 18.50 to 24.99)"
            }
            bmi in 25.00..29.99 ->{
                result = "OverWeight"
                color = R.color.over_weight
                range = "(Overweight range is 25.00 to 29.99)"
            }
            bmi>29.99->{
                result = "Obese"
                color = R.color.obese
                range = "(Obese range is greater than 29.99)"
            }
        }

        binding.bmi.text = result
        binding.bmi.setTextColor(ContextCompat.getColor(requireContext(),color))
        binding.range.text = range
        binding.range.setTextColor(ContextCompat.getColor(requireContext(),color))
    }

    private fun validateInput(weight: String?, height: String?): Boolean {
        return when {
            weight.isNullOrEmpty()->{
                Toast.makeText(requireContext(),"Weight is empty", Toast.LENGTH_SHORT).show()
                return false
            }
            height.isNullOrEmpty()->{
                Toast.makeText(requireContext(),"Height is empty",Toast.LENGTH_SHORT).show()
                return false
            }


            else -> {
                return true
            }
        }

    }


}