package com.example.lab1katja

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var explicitBtn: Button
    private lateinit var implicitBtn: Button
    private lateinit var sendMsgBtn: Button
    private lateinit var photoBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        explicitBtn = findViewById(R.id.explicitActivityBtn)
        implicitBtn = findViewById(R.id.implicitActivityBtn)
        sendMsgBtn = findViewById(R.id.sendMessageBtn)
        photoBtn = findViewById(R.id.choosePhotoBtn)

        val bundle: Bundle? = intent.extras
        val tekst: String = bundle?.get("vnesenText")?.toString() ?: " ... "
        textView.text = tekst

        explicitBtn.setOnClickListener {
            val intent: Intent = Intent(this, ExplicitActivity::class.java)
            startActivity(intent)
        }

        sendMsgBtn.setOnClickListener {

                Intent(Intent.ACTION_SEND).let { emailIntent ->
                emailIntent.type = "text/plain"
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "MPiP Send Title")
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Content send from MainActivity")
                startActivity(emailIntent)
            }
        }

        var launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {

                val data: Intent? = result.data
                val openIntent = Intent.createChooser(data,"Choose app for images")
                startActivity(openIntent)


            }
        }

        photoBtn.setOnClickListener{
            val imageIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            launcher.launch(imageIntent)
        }
    }
}
