package com.example.myapplication

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.util.TimeFormatException
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import com.example.myapplication.R.id
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.timepicker.TimeFormat
import java.io.Serializable
import java.sql.Time
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*
import kotlin.toString as toString




class MainActivity : AppCompatActivity() {

    lateinit var textInputFull_Name: TextInputLayout
    lateinit var textInputReg_Email: TextInputLayout
    lateinit var textInputReg_age: TextInputLayout
    lateinit var textInputGender: TextView
    lateinit var radioGroup: RadioGroup
    lateinit var radioButton: RadioButton
    lateinit var radioButton2: RadioButton
    lateinit var checkBox: CheckBox
    lateinit var regImg:ImageView
    lateinit var btnValidate: Button
    lateinit var DateOfBirth: TextView
    lateinit var btnDateOfBirth: Button
    lateinit var btntimePicker: Button
    lateinit var timePicker: TextView
    var formatdate=SimpleDateFormat("dd MMMM yyyy", Locale.US)
    var formattime=SimpleDateFormat("HH:mm aa")



    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar!!.title = "Registration Form"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textInputFull_Name = findViewById(id.full_Name)
        textInputReg_Email = findViewById(id.register_Email)
        textInputReg_age=findViewById(id.age)
        textInputGender = findViewById(id.textView3)
        radioGroup = findViewById(id.radio_Group)
        radioButton =findViewById(id.radioButton)
        radioButton2 =findViewById(id.radioButton2)
        checkBox = findViewById(id.checkBox)
        regImg =findViewById(id.regImage)
        btnValidate = findViewById(id.btnValidate)
        timePicker =findViewById(id.timePicker)
        DateOfBirth =findViewById(id.DateOfBirth)
        btnDateOfBirth=findViewById(id.btnDateOfBirth)
        btntimePicker=findViewById(id.btntimePicker)


        btnDateOfBirth.setOnClickListener(View.OnClickListener {
            val getdate =Calendar.getInstance()
            val datePicker=DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                val selectdate=Calendar.getInstance()
                selectdate.set(Calendar.YEAR,i)
                selectdate.set(Calendar.MONTH,i2)
                selectdate.set(Calendar.DAY_OF_MONTH,i3)
                DateOfBirth.text=formatdate.format(selectdate.time)
            },getdate.get(Calendar.YEAR),getdate.get(Calendar.MONTH),getdate.get(Calendar.DAY_OF_MONTH))
            datePicker.show()

        })

        btntimePicker.setOnClickListener(View.OnClickListener {
            val gettime= Calendar.getInstance()
            var timepicker= TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { time, i, i2 ->
                val selecttime=Calendar.getInstance()
                selecttime.set(Calendar.HOUR_OF_DAY,i)
                selecttime.set(Calendar.MINUTE,i2)
                timePicker.text=formattime.format(selecttime.time)
            },gettime.get(Calendar.HOUR_OF_DAY),gettime.get(Calendar.MINUTE),false)
            timepicker.show()
        })

    }


    fun validateName(): Boolean {
        val fce: String = getString(R.string.fce)
        val name: String = textInputFull_Name.editText!!.text.toString()
        return if (name.isEmpty()) {
            textInputFull_Name.error = fce
            false
        } else if (name.length <=5) {
            textInputFull_Name.error = "Username is too Short"
            false
        }else if (name.length>=30) {
            textInputFull_Name.error = "Username is too long"
            false
        }
        else {
            textInputFull_Name.error = null
            true
        }
    }
     fun validateEmail(): Boolean {
         val fce: String = getString(R.string.fce)
        val emailInput1 = textInputReg_Email.editText!!.text.toString().trim()
        return if (emailInput1.isEmpty()) {
            textInputReg_Email.error = fce
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput1).matches()) {
            textInputReg_Email.error = "Please enter valid Email"
            false
        } else {
            textInputReg_Email.error = null
            true
        }
    }
    fun validateage(): Boolean {
        val age = textInputReg_age.editText!!.text.toString().trim()
        val ageval="/^[1-9]?[0-9]{1}\$|^100\$/"
        return if (age.isEmpty()) {
            textInputReg_age.error = "Field can not be empty"
            false
        }
        else {
            textInputReg_age.error = null
            true
        }
    }
     fun validateRadiogroup(): Boolean {
        return if (radioGroup.checkedRadioButtonId == -1) {
            textInputGender.error = "Please select the gender"
            false
        } else {
            textInputGender.error = null
            true
        }
    }
    fun validateDateofBirth(): Boolean {
        val name: String = DateOfBirth.text.toString()
        return if (name.isEmpty()) {
            DateOfBirth.error = "Field can not be empty"
            false
        } else {
            DateOfBirth.error = null
            true
        }
    }
     fun validateTimpepicker(): Boolean {
        val name: String = timePicker.text.toString()
        return if (name.isEmpty()) {
            timePicker.error = "Field can not be empty"
            false
        } else {
            timePicker.error = null
            true
        }
    }
      fun validatecheckbox(): Boolean {
        return if (!checkBox.isChecked) {
            checkBox.error = "Please accept the terms and condition"
            false
        } else {
            checkBox.error = null
            true
        }
    }
    fun btnRegisterForm(view: View) {
        val name= textInputFull_Name.editText?.text.toString()
        val email=textInputReg_Email.editText?.text.toString()
        val age=textInputReg_age.editText?.text.toString()
        val date=DateOfBirth.text.toString()
        val time=timePicker.text.toString()
        val radioGroup=radioGroup.checkedRadioButtonId
        val male=findViewById<RadioButton>(radioGroup)
        val registration_successful: String = getString(R.string.registration_successful)

        if (!validateName() or  !validateEmail() or  !validateRadiogroup() or  !validatecheckbox() or !validateTimpepicker() or !validateage() or !validateDateofBirth()) {
            return
        }

        Toast.makeText(this, registration_successful, Toast.LENGTH_SHORT).show()
        val intent= Intent(this,week3_RecyclerView::class.java)
        intent.putExtra("Name",name)
        intent.putExtra("Email",email)
        intent.putExtra("Age",age)
        intent.putExtra("Gender",male.text.toString())
        intent.putExtra("Dob",date)
        intent.putExtra("Time",time)
        intent.putExtra("MyImg", R.drawable.person_icon_blue)

        setResult(RESULT_OK,intent);

        finish()

    }
}

//class UserInfo : Serializable {
//    private lateinit var name: String
//    private lateinit var email: String
//    fun getName(): String? {
//        return name
//    }
//    @JvmName("setName1")
//    fun setName(name: String?) {
//        this.name = name!!
//    }
//    fun getEmail(): String? {
//        return email
//    }
//    @JvmName("setEmail1")
//    fun setEmail(email: String?) {
//        this.email= email!!
//    }
//}



