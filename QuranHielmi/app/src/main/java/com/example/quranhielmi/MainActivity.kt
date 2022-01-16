package com.example.quranhielmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.cardview.widget.CardView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private val api by lazy { ApiService().endpoint }
    private lateinit var btnQuran: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnQuran = findViewById(R.id.card1)

        btnQuran.setOnClickListener {
            startActivity( Intent(this@MainActivity, QuranView::class.java))
        }

    }
}