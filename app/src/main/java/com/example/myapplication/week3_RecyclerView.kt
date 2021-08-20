package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class week3_RecyclerView : AppCompatActivity() {
    var list: List<Listdatacard>? = null
//    private var userInfo: UserInfo? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week3_recycler_view)
        list = ArrayList<Listdatacard>()


        val fab: View = findViewById(R.id.fab)

        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->


            if (result.resultCode == Activity.RESULT_OK) {

                var data = result.data
                // There are no request codes
                val name = data?.getStringExtra("Name").toString()
                val email = data?.getStringExtra("Email").toString()
                val gender = data?.getStringExtra("Gender").toString()
                val age = data?.getStringExtra("Age").toString()
                val dob = data?.getStringExtra("Dob").toString()
                val time = data?.getStringExtra("Time").toString()


                (list as ArrayList<Listdatacard>).add(Listdatacard(R.drawable.person_icon_blue,email,name,gender,time,age,dob))


                val recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
                val adapter = RecyclerAdapter(list as ArrayList<Listdatacard>)
                recyclerView.setHasFixedSize(true)
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = adapter

                val insertIndex = 2
                adapter.notifyItemInserted(insertIndex);
            }
        }
        fab.setOnClickListener { view ->
//            resultLauncher.launch(Intent(this,MainActivity::class.java))
            val intent =Intent(this,MainActivity::class.java)
//            startActivity(intent)
//            val intent= Intent(applicationContext,MainActivity::class.java)
//
            resultLauncher.launch(intent)
        }
    }




    //    Menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_Logout -> {
                val builder1 = AlertDialog.Builder(this)
                builder1.setMessage("Are you sure you want to logout of this app?")
                builder1.setCancelable(true)
                builder1.setPositiveButton(
                    "Yes"
                ) { dialog,which ->finishAffinity() }
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

}

