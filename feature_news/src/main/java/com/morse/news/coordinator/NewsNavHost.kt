package com.morse.news.coordinator

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.morse.news.feature_news.HomeScreen
import com.morse.news.feature_search.SearchScreen


fun NavGraphBuilder.newsGraph(nav: NavHostController) {
    homeScreen(nav)
    searchScreen(nav)
}

private fun NavGraphBuilder.homeScreen(nav: NavHostController) {
    composable(NewsDirections.Home.AllNews.name) {
        HomeScreen {
            navigateToSearch(nav)
        }
    }
}


private fun NavGraphBuilder.searchScreen(nav: NavHostController) {
    composable(NewsDirections.Search.name) {
        SearchScreen {
            nav.popBackStack()
        }
    }
}

fun navigateToSearch(navHostController: NavHostController) {
    navHostController.navigate(NewsDirections.Search.name)
}
