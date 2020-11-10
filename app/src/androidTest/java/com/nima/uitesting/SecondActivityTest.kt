package com.nima.uitesting

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondActivityTest{

    @get :Rule
    val activityRule = ActivityScenarioRule(SecondActivity::class.java)

    @Test
    fun isActivityInViewTest(){
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
    }

    @Test
    fun titleVisibilityTest(){
        onView(withId(R.id.activity_secondary_title)).check(matches(isDisplayed()))
    }
    @Test
    fun buttonVisibilityTest(){
        onView(withId(R.id.button_back)).check(matches(isDisplayed()))
    }
    @Test
    fun buttonTextTest(){
        onView(withId(R.id.activity_secondary_title)).check(matches(withText(R.string.text_secondaryActivity)))
    }
    @Test
    fun titleTextTest(){
        onView(withId(R.id.button_back)).check(matches(withText(R.string.text_back)))
    }
}