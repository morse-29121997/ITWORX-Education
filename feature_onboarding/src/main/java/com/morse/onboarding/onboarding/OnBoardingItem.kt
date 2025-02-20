package com.morse.onboarding.onboarding

import com.morse.onboarding.R

data class OnBoardingItem(
    val text: Int,
    val image: Int,
) {
    companion object {
        fun get() = listOf(
            OnBoardingItem(
                R.string.choose_countries_that_matter,
                R.drawable.countries,
            ),
            OnBoardingItem(
                R.string.choose_topics_that_matter,
                R.drawable.categorious,

                )

        )
    }
}