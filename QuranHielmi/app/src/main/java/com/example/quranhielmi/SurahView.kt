package com.example.quranhielmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SurahView : AppCompatActivity() {

    private val api by lazy { ApiService().endpoint }
    private lateinit var myAyat : ViewAdapterSurah
    private lateinit var btnBack : ImageView
    private lateinit var listAyat : RecyclerView
    private val nomor_surah by lazy {intent.getStringExtra("nomor_surah")}
    private val jumlah_ayat by lazy {intent.getStringExtra("jumlah_ayat")}
    private val text_surat by lazy {intent.getStringExtra("text_surat")}
    private val arti_surah by lazy {intent.getStringExtra("arti_surah")}
    private lateinit var tv_juz : TextView
    private lateinit var tv_surahSurah : TextView
    private lateinit var tv_artiSurah : TextView
    private lateinit var tv_ayatSurah : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surah_view)

        tv_juz = findViewById(R.id.tv_juz)
        tv_ayatSurah  = findViewById ( R.id. tv_ayatSurah)
        tv_artiSurah = findViewById(R.id.tv_artiSurah)
        tv_surahSurah = findViewById(R.id.tv_surahSurah)


        listAyat = findViewById(R.id.list_ayat)
        getAyat()

        btnBack = findViewById(R.id.btnBackSurah)

        btnBack.setOnClickListener {
            back()
        }
    }

   private fun getAyat () {
       api.getAyat("surah/${nomor_surah}")?.enqueue( object : Callback<SurahModel?> {
           override fun onResponse(call: Call<SurahModel?>, response: Response<SurahModel?>) {
               if(response.isSuccessful()){
                   val dataAyat = response.body()!!.data.verses
                   listAyat.layoutManager = LinearLayoutManager(this@SurahView)
                   listAyat.adapter = ViewAdapterSurah (dataAyat as ArrayList<SurahModel.Verses>)
                   tv_surahSurah.text = text_surat
                   tv_ayatSurah.text = jumlah_ayat
                   tv_artiSurah.text = arti_surah
                   dataAyat.forEach{
                       tv_juz.text = it.meta.juz.toString()
                   }

               }
           }

           override fun onFailure(call: Call<SurahModel?>, t: Throwable) {
               Log.d("Response", "gagal ${t.toString()}")
           }
       })
    }

    private fun back(){
        finish()
    }
}




