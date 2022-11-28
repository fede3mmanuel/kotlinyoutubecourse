package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MyTag", "MainActivity: OnCreate")
            val greetingTextView = findViewById<TextView>(R.id.tvHello)
            val inputField = findViewById<EditText>(R.id.etName)
            val submitButton = findViewById<Button>(R.id.btnSubmit)
            val offersButton = findViewById<Button>(R.id.btnOffers)

            var enteredName = ""

            submitButton.setOnClickListener {
                enteredName = inputField.text.toString()

                if (enteredName == ""){
                    offersButton.visibility = INVISIBLE
                    greetingTextView.text = ""
                    Toast.makeText(this@MainActivity, "Please, enter your name!", Toast.LENGTH_SHORT ).show()
                }else {
                    val message = "Welcome ${enteredName}"
                    Log.i("MyTag", message)
                    greetingTextView.text = message
                    Log.i("MyTag", "After displaying the message on the Text View ")
                    inputField.text.clear()
                    offersButton.visibility = VISIBLE
                }
            }

        offersButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("USER", enteredName)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
    }
}