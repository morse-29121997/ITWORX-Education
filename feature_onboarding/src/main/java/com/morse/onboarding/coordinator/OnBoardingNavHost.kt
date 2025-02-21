package com.morse.onboarding.coordinator

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.morse.onboarding.onboarding.OnBoardingScreen
import com.morse.onboarding.preferences.PreferenceScreen
import com.morse.onboarding.splash.SplashScreen


fun NavGraphBuilder.onBoardingGraph(nav : NavHostController) {
    splashScreen(nav)
    onBoardingScreen(nav)
    selectCountryAndPreferencesScreen(nav)
}

private fun NavGraphBuilder.splashScreen (nav: NavHostController){
    composable(OnBoardingDirections.Splash::class.java.name) {
        SplashScreen {
            OnBoardingDirections.Splash.navigateToOnBoarding(nav)
        }
    }
}

private fun NavGraphBuilder.onBoardingScreen (nav: NavHostController){
    composable(OnBoardingDirections.OnBoarding::class.java.name) {
        OnBoardingScreen() {
            OnBoardingDirections.OnBoarding.navigateToOnSelectCountryAndPreferences(nav)
        }
    }
}

private fun NavGraphBuilder.selectCountryAndPreferencesScreen (nav: NavHostController){
    composable(OnBoardingDirections.SelectPreferences::class.java.name) {
        PreferenceScreen{
            OnBoardingDirections.SelectPreferences.Language.navigateToHome(nav)
        }
    }
}