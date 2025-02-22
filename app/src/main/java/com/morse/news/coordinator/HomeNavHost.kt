package com.morse.news.coordinator

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.morse.news.feature_news.HomeScreen
import com.morse.news.feature_search.SearchScreen
import com.morse.onboarding.coordinator.OnBoardingDirections.Splash



fun NavGraphBuilder.homeCycle(nav: NavHostController) {
    newsScreen(nav)
    searchScreen(nav)
}

private fun NavGraphBuilder.newsScreen(nav: NavHostController) {
    composable("Home") {
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


fun navigateToHome(nav: NavHostController) = nav.navigate("Home"){
    popUpTo(Splash.name){
        inclusive = true
    }
}