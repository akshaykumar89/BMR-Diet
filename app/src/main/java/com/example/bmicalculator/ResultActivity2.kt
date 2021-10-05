package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ResultActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_layout)
        var BMR: Int = getIntent().getFloatExtra("Bmr_ans", 0.toFloat()).toInt()
        val tv_bmr_ans: TextView = findViewById(R.id.tv_BMR_ans)
        tv_bmr_ans.text = "${BMR.toInt()}"

        var result_item: List<BMRitem> = listOf(
                BMRitem((BMR * 1.2).toInt(), "Sedentary", "Little or no exercise/Desk job"),
                BMRitem((BMR * 1.375).toInt(), "Light Active", "Exercise 1-3 times/week"),
                BMRitem((BMR * 1.55).toInt(), "Moderate Active", "Exercise 4-5 times/week"),
                BMRitem((BMR * 1.725).toInt(), "Very Active", "Daily exercise or intense exercise 3-4 times/week"),
                BMRitem((BMR * 1.9).toInt(), "Extremely Active", "Very intense exercise daily, or physical job"),
        )


        val recyler_result_list: RecyclerView = findViewById(R.id.recycler_result_list)
        recyler_result_list.adapter = result_List_Adapter(result_item)
        recyler_result_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }
}


