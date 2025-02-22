package com.morse.news.coordinator

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.morse.news.feature_news.HomeScreen
import com.morse.news.feature_search.SearchScreen
import com.morse.onboarding.coordinator.OnBoardingDirections.Splash

fun openLink (context: Context , url : String){
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(browserIntent)
}

fun NavGraphBuilder.homeCycle(nav: NavHostController) {
    newsScreen(nav)
    searchScreen(nav)
}

private fun NavGraphBuilder.newsScreen(nav: NavHostController) {
    composable("Home") {
        HomeScreen(onPressed = {
            openLink(nav.context, it.url)
        }) { direction ->
            when (direction) {
                NewsDirections.Search ->navigateToSearch (nav)
                else -> {}
            }
        }
    }
}


private fun NavGraphBuilder.searchScreen(nav: NavHostController) {
    composable(NewsDirections.Search.name) {
        SearchScreen (onPressed = {

        }) {
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