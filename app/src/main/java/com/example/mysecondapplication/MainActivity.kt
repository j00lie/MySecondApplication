package com.example.mysecondapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val secAct: Button = findViewById(R.id.secondActivityBtn)
        secAct.setOnClickListener {
            val startIntent = Intent(this, SecondActivity::class.java)
            startIntent.putExtra("com.example.mysecondapplication.SOMETHING", "HELLO WORLD")
            startActivity(startIntent)
        }
        val gooAct: Button = findViewById(R.id.googleBtn)
        gooAct.setOnClickListener {
            val google = "https://www.google.com"
            val webaddress = Uri.parse(google)
            val googleIntent = Intent(Intent.ACTION_VIEW, webaddress)
            startActivity((googleIntent))
        }
    }
}