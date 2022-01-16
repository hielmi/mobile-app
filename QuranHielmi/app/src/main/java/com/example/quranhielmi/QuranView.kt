package com.example.quranhielmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuranView : AppCompatActivity() {

    private val api by lazy { ApiService().endpoint }
    private lateinit var MyQuran: ViewAdapterQuran
    private lateinit var list_quran : RecyclerView
    private lateinit var btnBack : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quran_view)

        setupView()
        setUpList()

        btnBack = findViewById(R.id.btnBackQuran)

        btnBack.setOnClickListener {
            back()
        }

    }

    override fun onStart(){
        super.onStart()
        getAllSurah()
    }

    private fun setupView(){
        list_quran = findViewById(R.id.list_quran)
    }

    private fun setUpList () {
        MyQuran = ViewAdapterQuran (arrayListOf(), object : ViewAdapterQuran.OnAdapterListener{
            override fun KlikSurah(dataQuran: QuranModel.Data) {
                val intent = Intent(this@QuranView, SurahView::class.java)
                intent.putExtra("nomor_surah", dataQuran.number.toString())
                intent.putExtra("jumlah_ayat", dataQuran.numberOfVerses.toString())
                intent.putExtra("text_surat", dataQuran.name.transliteration.id)
                intent.putExtra("arti_surah", dataQuran.name.translation.id)
                startActivity(intent)
            }
        })

        list_quran = findViewById(R.id.list_quran)
        list_quran.adapter = MyQuran
    }

    fun getAllSurah(){
        api.data().enqueue( object : Callback<QuranModel> {
            override fun onResponse(call: Call<QuranModel>, response: Response<QuranModel>) {
                if (response.isSuccessful()) {
                    val listData = response.body()!!.data
                    MyQuran.setData( listData )
                }
            }

            override fun onFailure(call: Call<QuranModel>, t: Throwable) {
                Log.d("Response", t.toString())
            }

        })
    }

    fun back(){
        finish()
    }
}


