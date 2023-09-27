package com.raihan.abcalculation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class TempFragment : Fragment() {
    var selectTempText = ""
    var convertTempText = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_temp, container, false)


        val temperature = resources.getStringArray(R.array.temperature)
        val adapter = ArrayAdapter(rootView.context, R.layout.dropdown_item, temperature)
        val convert = rootView.findViewById<Button>(R.id.convertbtn)
        val selectEtxt = rootView.findViewById<EditText>(R.id.tempEtxt)
        val converttxt = rootView.findViewById<TextView>(R.id.tempconEtxt)


        // Find the AutoCompleteTextView within the inflated layout
        val selectTemp = rootView.findViewById<AutoCompleteTextView>(R.id.selecttempEtxt)
        selectTemp.setAdapter(adapter)
        val convertTemp = rootView.findViewById<AutoCompleteTextView>(R.id.selectcontempEtxt)
        convertTemp.setAdapter(adapter)





        selectTemp.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            var selectedItem = adapter.getItem(position)
            selectTempText = selectedItem.toString()
            Toast.makeText(requireContext(), "Selected Item:$selectTempText", Toast.LENGTH_SHORT)
                .show()

        }

        convertTemp.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            var convertedItem = adapter.getItem(position)
            convertTempText = convertedItem.toString()
            Toast.makeText(requireContext(), "Selected Item:$convertTempText", Toast.LENGTH_SHORT)
                .show()

        }
        convert.setOnClickListener {
            var getTemp = selectEtxt.text.toString()
            if(getTemp.equals("")){
                Toast.makeText(requireContext(), "Please enter the temperature", Toast.LENGTH_SHORT).show()
            }
            else if(selectTempText == "Celsius" && convertTempText == "Fahrenheit"){
                //F = °C × (9/5) + 32
                var f = (getTemp.toDouble())*(9.0/5.0)+32.0
                converttxt.text = f.toString()
            }
            else if(selectTempText == "Celsius" && convertTempText == "Kelvin"){
                //Kelvin = Celsius + 273.15.
                var k = (getTemp.toDouble())+273.15
                converttxt.text = k.toString()
            }
            else if(selectTempText == "Celsius" && convertTempText == "Celsius"){
                var c = getTemp.toDouble()
                converttxt.text = c.toString()
            }
            else if(selectTempText == "Fahrenheit" && convertTempText == "Kelvin"){
                //(F − 32) × 5 ⁄ 9 + 273.15
                var k = ((((getTemp.toDouble())-32)*5)/9)+273.15
                var txt = String.format("%.2f",k)
                converttxt.text = txt.toString()
            }
            else if(selectTempText == "Fahrenheit" && convertTempText == "Celsius"){
                //(°F - 32) × 5/9
                var c = (((getTemp.toDouble())-32)*5)/9
                var txt = String.format("%.2f",c)
                converttxt.text = txt.toString()
            }
            else if(selectTempText == "Fahrenheit" && convertTempText == "Fahrenheit"){
                var f = getTemp.toDouble()
                converttxt.text = f.toString()
            }
            else if(selectTempText == "Kelvin" && convertTempText == "Celsius"){
                //K - 273.15
                var c = (getTemp.toDouble())-273.15
                var txt = String.format("%.2f",c)
                converttxt.text = txt.toString()
            }
            else if(selectTempText == "Kelvin" && convertTempText == "Fahrenheit"){
                //(K − 273.15) × 1.8 + 32
                var f = (((getTemp.toDouble())-273.15)*1.8)+32
                var txt = String.format("%.2f",f)
                converttxt.text = txt.toString()
            }
            else if(selectTempText == "Kelvin" && convertTempText == "Kelvin"){
                var k = getTemp.toDouble()
                converttxt.text = k.toString()
            }
            else{
                Toast.makeText(requireContext(), "Please select one unit.....", Toast.LENGTH_SHORT).show()
            }
        }


        return rootView
    }

}
