package com.example.quranhielmi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewAdapterSurah(
    val Ayat: ArrayList<SurahModel.Verses>,
) : RecyclerView.Adapter<ViewAdapterSurah.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_surah, parent, false)
    )

    override fun onBindViewHolder(holder: ViewAdapterSurah.ViewHolder, position: Int) {
        val dataAyat= Ayat[position]

        holder.tv_Ayat.text = dataAyat.number.inSurah.toString()
        holder.tv_arabSurah.text = dataAyat.text.arab
        holder.tv_artiAyat.text = dataAyat.translation.id
        holder.tv_latinSurah.text = dataAyat.text.transliteration.en

    }

    override fun getItemCount() = Ayat.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tv_Ayat = view.findViewById<TextView> (R.id.tv_Ayat)
        val tv_arabSurah = view.findViewById<TextView>(R.id.tv_arabSurah)
        val tv_latinSurah = view.findViewById<TextView>(R.id.tv_latinSurah)
        val tv_artiAyat = view.findViewById<TextView>(R.id.tv_artiAyat)
    }
    fun  setData (dataQuran: List<SurahModel.Verses>){
        Ayat.clear()
        Ayat.addAll(dataQuran)
        notifyDataSetChanged()
    }
}

