package com.morse.news.coordinator

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.morse.onboarding.coordinator.OnBoardingDirections.OnBoarding
import com.morse.onboarding.coordinator.OnBoardingDirections.SelectPreferences
import com.morse.onboarding.coordinator.OnBoardingDirections.Splash
import com.morse.onboarding.onboarding.OnBoardingScreen
import com.morse.onboarding.preferences.PreferenceScreen
import com.morse.onboarding.splash.SplashScreen

fun NavGraphBuilder.onBoardingCycle (nav: NavHostController){
    splashScreen(nav){ navigateToHome(nav)}
    onBoardingScreen(nav)
    selectCountryAndPreferencesScreen(nav){ navigateToHome(nav)}
}

private fun NavGraphBuilder.splashScreen (nav: NavHostController , navToHome : () -> Unit = {}){
    composable(Splash.name) {
        SplashScreen {
            when(it){
                true -> navigateToOnBoarding(nav)
                false -> navToHome()
            }
        }
    }
}

private  fun NavGraphBuilder.onBoardingScreen (nav: NavHostController){
    composable(OnBoarding.name) {
        OnBoardingScreen {
            navigateToOnSelectCountryAndPreferences(nav)
        }
    }
}

private  fun NavGraphBuilder.selectCountryAndPreferencesScreen (nav: NavHostController, navToHome : () -> Unit = {}){
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
