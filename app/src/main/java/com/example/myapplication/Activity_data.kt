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
//lateinit var nameResult: TextView
//lateinit var resultRadio: TextView
//    lateinit var resultAge: TextView


        override fun onCreate(savedInstanceState: Bundle?) {
//nameResult=findViewById(R.id.resultName)
//            resultRadio=findViewById(R.id.resultRadio)
//            resultAge=findViewById(R.id.resultAge)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        supportActionBar!!.title = "Profile"
        sharebutton = findViewById(R.id.ShareButton)

        val intent = intent

        val name = intent.getStringExtra("Name")
        val email = intent.getStringExtra("Email")
            val age = intent.getStringExtra("Age")
        val gender = intent.getStringExtra("Gender")
        val date = intent.getStringExtra("Date")
        val time=intent.getStringExtra("Time")

        val nameResult = findViewById<TextView>(R.id.resultName)
        val resultEmail = findViewById<TextView>(R.id.resultEmail)
        val resultRadio = findViewById<TextView>(R.id.resultRadio)
        val resultDob =findViewById<TextView>(R.id.resultDob)
        val resultTime=findViewById<TextView>(R.id.resultTime)
            val resultAge=findViewById<TextView>(R.id.resultAge)


//for image
        val imageView: ImageView = findViewById(R.id.profileImg)
        val bundle: Bundle = intent.extras!!
        val resId: Int = bundle.getInt("MyImg")



        nameResult.text = "Name:$name"
        resultEmail.text = "Email:$email"
            resultAge.text = "Age:$age"
        resultRadio.text = "Gender:$gender"
            resultDob.text="Date:$date"
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
//        val intent = Intent()
//        intent.putExtra("Name",nameResult.text.toString())
//        intent.putExtra("Age",resultAge.text.toString())
//        intent.putExtra("Gender",resultRadio.text.toString())

        startActivity(Intent(applicationContext, week3_RecyclerView::class.java))


    }


}







