package com.example.quranhielmi

data class SurahModel (
    val data : Data
        ){
    data class Data (
        val verses : List<Verses>
        )
    data class Verses(
        val number : number,
        val meta : meta,
        val text : text,
        val translation : translation,
            )
    data class meta(
        val juz : Int
    )
    data class number(
        val inSurah : Int,
    )
    data class text(
        val arab : String,
        val transliteration: transliterationText
    )
    data class transliterationText(
        val en : String
    )

    data class translation (
        val id : String
            )
}

