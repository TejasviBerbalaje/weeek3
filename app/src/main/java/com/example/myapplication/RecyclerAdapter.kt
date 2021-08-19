package com.example.myapplication

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.view.LayoutInflater
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
        val fname= arrayListOf("tej1","tej2","tej3","tej4")
val age= arrayListOf("24","25","24","25")
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
 var fname : TextView = itemView.findViewById(R.id.PersonName)
        var age : TextView = itemView.findViewById(R.id.PersonAge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.cardview_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return fname.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.fname.text=fname[position]
       holder.age.text=age[position]
    }
}

