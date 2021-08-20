package com.example.myapplication



import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView


class Activity_data : AppCompatActivity() {
    lateinit var sharebutton: ImageButton



        @SuppressLint("SetTextI18n")
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        supportActionBar!!.title = "Profile"
        sharebutton = findViewById(R.id.ShareButton)

        val nameResult = findViewById<TextView>(R.id.resultName)
        val resultEmail = findViewById<TextView>(R.id.resultEmail)
        val resultRadio = findViewById<TextView>(R.id.resultRadio)
        val resultDob =findViewById<TextView>(R.id.resultDob)
        val resultTime=findViewById<TextView>(R.id.resultTime)
            val resultAge=findViewById<TextView>(R.id.resultAge)


//for getting dat from main activity
        val imageView: ImageView = findViewById(R.id.profileImg)
        val bundle: Bundle = intent.extras!!
        val resId: Int = bundle.getInt("MyImg")

            val name = bundle.getString("Name")
            val email = bundle.getString("Email")
            val age = bundle.getString("Age")
            val gender = bundle.getString("Gender")
            val date = bundle.getString("Dob")
            val time=bundle.getString("Time")


        nameResult.text = "Name:$name"
        resultEmail.text = "Email:$email"
            resultAge.text = "Age:$age"
        resultRadio.text = "Gender:$gender"
            resultDob.text="Dob:$date"
            resultTime.text="Time:$time"
        imageView.setImageResource(resId)

//share butoon
        sharebutton.setOnClickListener {
            val message = nameResult.text.toString()
            val emailmessage = resultEmail.text.toString()
            val agemessage = resultAge.text.toString()
            val radiomessage = resultRadio.text.toString()
            val dobmessage =resultDob.text.toString()
            val Timemessage =resultTime.text.toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,message+"\n"+emailmessage+"\n"+radiomessage+"\n"+dobmessage+"\n"+Timemessage +"\n"+agemessage)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share via :"))

        }

    }


    //homebutton

    fun homeBtn(view: View) {
        startActivity(Intent(this, week3_RecyclerView::class.java))

    }


}







