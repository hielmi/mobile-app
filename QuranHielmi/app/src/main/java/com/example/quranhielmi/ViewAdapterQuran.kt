package com.example.quranhielmi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewAdapterQuran(
    val Quran: ArrayList<QuranModel.Data>,
    val listener: OnAdapterListener
) : RecyclerView.Adapter<ViewAdapterQuran.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_quran, parent, false)
    )

    override fun onBindViewHolder(holder: ViewAdapterQuran.ViewHolder, position: Int) {
        val dataQuran = Quran[position]

        holder.tv_nomor.text = dataQuran.number.toString()
        holder.tv_surah.text = dataQuran.name.transliteration.id
        holder.tv_arbSurah.text = dataQuran.name.short
        holder.tv_ayat.text = dataQuran.numberOfVerses.toString()
        holder.tv_revelation.text = dataQuran.revelation.id

        holder.itemView.setOnClickListener{
            listener.KlikSurah(dataQuran)
        }
    }

    override fun getItemCount() = Quran.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val tv_nomor = view.findViewById<TextView> (R.id.tv_number)
        val tv_surah = view.findViewById<TextView>(R.id.tv_surah)
        val tv_revelation = view.findViewById<TextView>(R.id.tv_revelation)
        val tv_arbSurah = view.findViewById<TextView>(R.id.tv_arbSurah)
        val tv_ayat = view.findViewById<TextView>(R.id.tv_ayat)
    }

    fun  setData (dataQuran: List<QuranModel.Data>){
        Quran.clear()
        Quran.addAll(dataQuran)
        notifyDataSetChanged()
    }



    interface OnAdapterListener{
        fun KlikSurah(dataQuran : QuranModel.Data )
    }

}


