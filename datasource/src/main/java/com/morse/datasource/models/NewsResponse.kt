package com.morse.datasource.models

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: ArrayList<New> ,
    val code : String ?= null ,
    val message : String ?= null
){
    fun isSuccess () = status == "ok"
    fun isFail () = status == "error"
}

data class New(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
) {
    data class Source(val id: String, val name: String)
}