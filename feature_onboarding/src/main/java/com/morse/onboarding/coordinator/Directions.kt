package com.morse.onboarding.coordinator

sealed class OnBoardingDirections (val name : String ) {
    data object Splash  : OnBoardingDirections(name = "Splash")
    data object OnBoarding : OnBoardingDirections(name = "OnBoarding")
    sealed class SelectPreferences : OnBoardingDirections("SelectPreferences") {
        data object Country : SelectPreferences()
        data object Categories : SelectPreferences()
    }
}