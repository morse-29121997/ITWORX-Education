package com.morse.news.coordinator

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.morse.onboarding.coordinator.OnBoardingDirections.Splash

@Composable
fun NewsNavHost() {
    val controller = rememberNavController()
    NavHost(
        navController = controller,
        startDestination = Splash.name,
    ) {
        onBoardingCycle(controller)
        homeCycle(controller)
    }
}






