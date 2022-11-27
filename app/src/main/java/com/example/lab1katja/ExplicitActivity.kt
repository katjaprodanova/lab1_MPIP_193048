package com.example.lab1katja

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ExplicitActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var voRedBtn: Button
    private lateinit var otkaziBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit)

        editText = findViewById(R.id.editText)
        voRedBtn = findViewById(R.id.voRedBtn)
        otkaziBtn = findViewById(R.id.otkaziBtn)

        voRedBtn.setOnClickListener{
            val intent: Intent = Intent(this,MainActivity::class.java)
            intent.putExtra("vnesenText",editText.text.toString())
            startActivity(intent)
        }

        otkaziBtn.setOnClickListener{
            val intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }




    }
}