package com.example.hw1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val bundle = intent.extras
        val intent = Intent(this,MainActivity::class.java)

        val but2 = findViewById<Button>(R.id.button2)
        val text3 = findViewById<EditText>(R.id.editTextTextPersonName3)
        val text4 = findViewById<EditText>(R.id.editTextTextPersonName4)

        but2.setOnClickListener {
            bundle!!.putString("Size",text3.text.toString())
            bundle.putString("Color",text4.text.toString())
            intent.putExtras(bundle)
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}