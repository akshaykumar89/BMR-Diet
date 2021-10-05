package com.example.bmicalculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class result_List_Adapter(var BMRitem:List<BMRitem>) : RecyclerView.Adapter<result_List_Adapter.result_viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): result_viewholder {
       val infilater : LayoutInflater= LayoutInflater.from(parent.context)
        val view = infilater.inflate(R.layout.result_item_layout,parent,false)
        return result_viewholder(view)
    }

    override fun onBindViewHolder(holder: result_viewholder, position: Int) {
      holder.item.text=BMRitem[position].bmr.toString()
        holder.level.text=BMRitem[position].level
        holder.description.text=BMRitem[position].description

    }

    override fun getItemCount(): Int {
       return BMRitem.size
    }
    class result_viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item : TextView=itemView.findViewById(R.id.tv_BMR_other)
        var level : TextView=itemView.findViewById(R.id.tv_level)
        var description : TextView=itemView.findViewById(R.id.tv_description)
    }
}
