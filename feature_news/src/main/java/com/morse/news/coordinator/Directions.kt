package com.morse.news.coordinator


sealed class NewsDirections (val name : String){
    sealed class Home : NewsDirections("Home"){
        data object AllNews : Home()
        data object SavedNews : Home()
    }
    data object Search : NewsDirections("Search")
    data object Preferences : NewsDirections("Preferences")
    data class Restart (val isArabic : Boolean) : NewsDirections("Restart")
}
