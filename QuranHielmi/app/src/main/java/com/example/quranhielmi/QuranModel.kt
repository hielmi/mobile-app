package com.example.quranhielmi

data class QuranModel (
    val data : List<Data>,
){
    data class Data (
        val number : Int,
        val name : name,
        val numberOfVerses : Int,
        val revelation : revelation
            )
    data class name (
        val short: String,
        val transliteration : transliteration,
        val translation : transition,
            )
    data class transliteration (
        val id : String
            )
    data class transition(
        val id: String?
    )
    data class revelation(
        val id : String?
    )
}