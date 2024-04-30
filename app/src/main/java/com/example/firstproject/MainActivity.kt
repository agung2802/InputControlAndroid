package com.example.firstproject

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar


class MainActivity : AppCompatActivity() {
    // on below line we are creating a variable.
    lateinit var pickDateBtn: Button
    lateinit var selectedDateTV: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pickDateBtn = findViewById(R.id.idBtnPickDate)
        selectedDateTV = findViewById(R.id.idTVSelectedDate)

        pickDateBtn.setOnClickListener {
            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    selectedDateTV.text = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }


        lateinit var buttonAlert: Button

        buttonAlert = findViewById(R.id.showAlert);
        buttonAlert.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setMessage("Please Select any option")
            dialog.setTitle("Dialog Box")
            dialog.setPositiveButton(
                "YES"
            ) { dialog, which ->
                Toast.makeText(applicationContext, "Yes is clicked", Toast.LENGTH_LONG).show()
            }
            dialog.setNegativeButton(
                "cancel"
            ) { dialog, which ->
                Toast.makeText(
                    applicationContext,
                    "cancel is clicked",
                    Toast.LENGTH_LONG
                ).show()
            }
            val alertDialog = dialog.create()
            alertDialog.show()
        }




    }


}