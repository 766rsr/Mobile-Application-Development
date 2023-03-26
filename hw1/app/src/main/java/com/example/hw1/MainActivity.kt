package com.example.hw1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private val requestDataLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_OK){
            val data = it.data
            val text = findViewById<TextView>(R.id.textView3)
            text.setText("姓名 ： "+data?.getStringExtra("Name")+"\n性別 ： "+data?.getStringExtra("Gender")+"\n尺寸 ： "+data?.getStringExtra("Size")+"\n顏色 ： "+data?.getStringExtra("Color"))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val but1 = findViewById<Button>(R.id.button)
        val text1 = findViewById<EditText>(R.id.editTextTextPersonName)
        val text2 = findViewById<EditText>(R.id.editTextTextPersonName2)

        val bundle = Bundle()
        val intent = Intent(this,MainActivity2::class.java)

        but1.setOnClickListener {
            bundle.putString("Name",text1.text.toString())
            bundle.putString("Gender",text2.text.toString())
            intent.putExtras(bundle)
            text1.setText("")
            text2.setText("")
            requestDataLauncher.launch(intent)
        }
    }
}