package com.morse.news.coordinator

import androidx.navigation.NavHostController

sealed class NewsDirections (val name : String){
    sealed class Home : NewsDirections("Home"){
        data object AllNews : Home()
        data object SavedNews : Home()
    }
    data object Search : NewsDirections("Search")
}
