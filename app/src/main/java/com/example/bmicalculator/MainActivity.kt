package com.example.bmicalculator

import android.content.Intent
import android.content.pm.FeatureGroupInfo
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.*
import androidx.core.text.trimmedLength
import java.lang.Integer.parseInt


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Assiging every views and elements of layout in kotlin file

        val button_male: ImageButton = findViewById(R.id.button_Male)
        val button_Female: ImageButton = findViewById(R.id.button_Female)
        val Male_Icon_TV: TextView = findViewById(R.id.male_icon_text)
        val Female_Icon_TV: TextView = findViewById(R.id.Female_icon_text)
        val sb_height: SeekBar = findViewById(R.id.sb_Weight)
        val tvheight: TextView = findViewById(R.id.tvheight)
        val etWeight: EditText = findViewById(R.id.etWeight)
        val etAge: EditText = findViewById(R.id.etAge)
        val btnBmi: Button = findViewById(R.id.btnBMI)

        var IsMale: Boolean = true
        var Age: Editable? = etAge.getText()
        var Weight: Editable? = etWeight.getText()
        var BMR: Float = 1.toFloat()
        var Height: Int = 130


//     Code when Female icon button is clicked
        button_Female.setOnClickListener {

            IsMale = false
            Female_Icon_TV.setBackgroundColor(Color.parseColor("#FFC0CB"))
            Male_Icon_TV.setBackgroundColor(Color.TRANSPARENT)

        }


//      Code when Male icon button is clicked
        button_male.setOnClickListener {
            IsMale = true
            Male_Icon_TV.setBackgroundColor(Color.parseColor("#8A8AFF"))
            Female_Icon_TV.setBackgroundColor(Color.TRANSPARENT)
        }


//      code for SEEK BAR (SLIDE BAR) of HEight
        sb_height.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {


            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvheight.text = "$progress"
                Height = progress

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })


// Code whn Calulte button is clicked
        btnBmi.setOnClickListener {


            if (if_all_filled(Age, Weight)) {
                var W: Int = parseInt(Weight.toString())
                var A: Int = parseInt(Age.toString())
                if (IsMale) {

                    BMR = (66.47 + (13.75 * W) + (5.003 * Height) - (6.755 * A)).toFloat()

                } else {
                    BMR = (655.1 + (9.563 * W) + (1.85 * Height) - (4.676 * A)).toFloat()


                }
                val intent = Intent(this,
                        ResultActivity2::class.java)
                intent.putExtra("Bmr_ans", BMR)
                startActivity(intent)


            }
        }
    }


    //      function handels if all data is filled  or not
    private fun if_all_filled(age: Editable?, weight: Editable?): Boolean {
        if (age.toString().trimmedLength() == 0 && weight.toString().trimmedLength() == 0) {
            Toast.makeText(this, "Enter AGE and Weight to proceed", Toast.LENGTH_SHORT).show()
            return false
        }
        if (age.toString().trimmedLength() == 0) {
            Toast.makeText(this, "Enter AGE  to proceed", Toast.LENGTH_SHORT).show()
            return false
        }
        if (weight.toString().trimmedLength() == 0) {
            Toast.makeText(this, "Enter Weight  to proceed", Toast.LENGTH_SHORT).show()
            return false
        }
        return true

    }
}