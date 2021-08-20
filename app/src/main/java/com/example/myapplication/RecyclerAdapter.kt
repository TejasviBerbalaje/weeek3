package com.example.myapplication

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputLayout

class RecyclerAdapter
    (private val listdata: MutableList<Listdatacard>?)  : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var personimageView: ImageView
        var personmailid: TextView
        var personage: TextView
        var personname: TextView
        var persongender: TextView
        var time: TextView
        var persondob:TextView
        var delete: ImageButton
        var relativeLayout: LinearLayout

        init {
            delete = itemView.findViewById<View>(R.id.DeleteButton) as ImageButton
            personimageView = itemView.findViewById<View>(R.id.PersonImageView) as ImageView
            personname = itemView.findViewById<View>(R.id.PersonName) as TextView
            personmailid = itemView.findViewById<View>(R.id.PersonEmailId) as TextView
            personage = itemView.findViewById<View>(R.id.PersonAge) as TextView
            persondob=itemView.findViewById<View>(R.id.PersonDob) as TextView
            persongender = itemView.findViewById<View>(R.id.PersonGender) as TextView
            time = itemView.findViewById<View>(R.id.time) as TextView

            relativeLayout = itemView.findViewById<View>(R.id.CardLinearLayout) as LinearLayout
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.cardview_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listdata!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myListData = listdata!![position]
        holder.personname.text = listdata[position].personname
        holder.personimageView.setImageResource(listdata[position].imgId)
        holder.personmailid.text = listdata[position].email
        holder.personage.text =listdata[position].personage
        holder.persondob.text =listdata[position].dob
        holder.persongender.text = listdata[position].persongender
        holder.time.text = listdata[position].time



        holder.delete.setOnClickListener {view ->
            val builder1 = AlertDialog.Builder(view.context)
            builder1.setMessage("Are you sure want to delete?")
            builder1.setCancelable(true)
            builder1.setPositiveButton("Yes"){dialogInterface, which ->
                listdata.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position,listdata.size)
            }
            //performing cancel action
            builder1.setNeutralButton("Cancel"){dialogInterface , which ->

            }
            //performing negative action

            val alert11 = builder1.create()
            alert11.show()
            true


        }



        holder.relativeLayout.setOnClickListener { view ->
            val intent = Intent(view.context, Activity_data::class.java)
            intent.putExtra("Name",myListData.personname);
            intent.putExtra("MyImg",myListData.imgId);
            intent.putExtra("Email",myListData.email);
            intent.putExtra("Age",myListData.personage)
            intent.putExtra("Gender",myListData.persongender);
            intent.putExtra("Time",myListData.time);
            intent.putExtra("Dob",myListData.dob);

            intent.putExtra("pos",position)
            view.context.startActivity(intent)

        }
    }
}

