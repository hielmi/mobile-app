package com.example.quranhielmi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiEndPoint {

    // get all data
    @GET("surah/")
    fun data() : Call<QuranModel>

    // get surah

    @GET
    fun getAyat(@Url url: String?): Call<SurahModel?>?
}