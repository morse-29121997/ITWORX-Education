package com.morse.onboarding.navigation

 sealed class OnBoardingDirections {
     data object OnBoarding : OnBoardingDirections()
     sealed class SelectPreferences : OnBoardingDirections(){
        data object Country : SelectPreferences()
        data object Language : SelectPreferences()
    }
 }