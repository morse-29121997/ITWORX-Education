package com.morse.onboarding.coordinator

import androidx.navigation.NavHostController

sealed class OnBoardingDirections {
    data object Splash : OnBoardingDirections() {
        fun navigateToOnBoarding(nav: NavHostController) =
            nav.navigate(OnBoarding::class.java.name){
                popUpTo(Splash::class.java.name){
                    inclusive = true
                }
            }

       private fun navigateToHome(nav: NavHostController) = Splash::class.java.name
    }

    data object OnBoarding : OnBoardingDirections(){
        fun navigateToOnSelectCountryAndPreferences(nav: NavHostController) =
            nav.navigate(SelectPreferences::class.java.name){
                popUpTo(Splash::class.java.name){
                    inclusive = true
                }
            }
    }
    sealed class SelectPreferences : OnBoardingDirections() {
        fun navigateToHome(nav: NavHostController) = Splash::class.java.name
        data object Country : SelectPreferences(){}
        data object Language : SelectPreferences(){}
    }
}