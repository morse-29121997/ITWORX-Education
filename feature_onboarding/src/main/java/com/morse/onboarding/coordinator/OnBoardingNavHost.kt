package com.morse.onboarding.coordinator

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.morse.onboarding.coordinator.OnBoardingDirections.OnBoarding
import com.morse.onboarding.coordinator.OnBoardingDirections.SelectPreferences
import com.morse.onboarding.coordinator.OnBoardingDirections.Splash
import com.morse.onboarding.onboarding.OnBoardingScreen
import com.morse.onboarding.preferences.PreferenceScreen
import com.morse.onboarding.splash.SplashScreen

enum class SplashDirections {
    OnBoarding ,
    Home
}

fun NavGraphBuilder.onBoardingGraph(nav : NavHostController , onSaveSuccess : () -> Unit) {
    splashScreen(nav , onSaveSuccess)
    onBoardingScreen(nav)
    selectCountryAndPreferencesScreen(nav , onSaveSuccess)
}

private fun NavGraphBuilder.splashScreen (nav: NavHostController , navToHome : () -> Unit = {}){
    composable(Splash.name) {
        SplashScreen {
            when(it){
                SplashDirections.OnBoarding -> navigateToOnBoarding(nav)
                SplashDirections.Home -> navToHome()
            }
        }
    }
}

private fun NavGraphBuilder.onBoardingScreen (nav: NavHostController){
    composable(OnBoarding.name) {
        OnBoardingScreen() {
            navigateToOnSelectCountryAndPreferences(nav)
        }
    }
}

private fun NavGraphBuilder.selectCountryAndPreferencesScreen (nav: NavHostController, navToHome : () -> Unit = {}){
    composable(SelectPreferences.Country.name) {
        PreferenceScreen{
            navToHome()
        }
    }
}


fun navigateToOnBoarding(nav: NavHostController) =
    nav.navigate(OnBoarding.name){
        popUpTo(Splash.name){
            inclusive = true
        }
    }

fun navigateToOnSelectCountryAndPreferences(nav: NavHostController) =
    nav.navigate(SelectPreferences.Country.name){
        popUpTo(Splash.name){
            inclusive = true
        }
    }
