package com.morse.news.coordinator

sealed class NewsDirections {
    sealed class Home : NewsDirections(){
        data object AllNews : Home()
        data object SavedNews : Home()
    }
    data object Search : NewsDirections()
}
