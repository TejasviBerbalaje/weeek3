package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class week3_RecyclerView : AppCompatActivity() {
//lateinit var recyclerView:RecyclerView
//
//    lateinit var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
//    lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week3_recycler_view)

//        layoutManager=LinearLayoutManager(this)
//        recyclerView.layoutManager=layoutManager
//
//        adapter=RecyclerAdapter()
//        recyclerView.adapter=adapter

//        val intent = intent
//
//        val name = intent.getStringExtra("Name")
//        val age = intent.getStringExtra("Age")
//        val gender = intent.getStringExtra("Gender")
//
//        val personname=findViewById<TextView>(R.id.PersonName)
//        val personage=findViewById<TextView>(R.id.PersonAge)
//        val persongender=findViewById<TextView>(R.id.PersonGender)
//
//        personname.text="$name"
//        personage.text="$age"
//        persongender.text="$gender"


    }

//    Menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_Logout -> {
                val builder1 = AlertDialog.Builder(this)
                builder1.setMessage("Are you sure you want to logout of this app?")
                builder1.setCancelable(true)
                builder1.setPositiveButton(
                    "Yes"
                ) { dialog,which ->finish() }
                builder1.setNegativeButton(
                    "No"
                ) { dialog, id -> dialog.cancel() }
                val alert11 = builder1.create()
                alert11.show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }




    fun fab(view: View) {
        startActivity(Intent(applicationContext, MainActivity::class.java))
//        Snackbar.make(view, "Please register here", Snackbar.LENGTH_LONG)
//            .setAction("Action", null).show()

    }

    fun cardView(view: View) {
        startActivity(Intent(applicationContext, Activity_data::class.java))
    }
}
