package com.nima.uitesting

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{
    @Test
    fun isActivityInIViewTest(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun titleVisibilityTest(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.activity_main_title)).check(matches(isDisplayed()))

        onView(withId(R.id.activity_main_title)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun buttonVisibilityTest(){
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()))
    }

    @Test
    fun titleTextTest(){
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.activity_main_title)).check(matches(withText(R.string.text_mainactivity)))
    }

    @Test
    fun buttonTextTest(){
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.button_next_activity)).check(matches(withText(R.string.text_next)))
    }
    @Test
    fun navSecondaryActivityTest(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.button_next_activity)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
    }

    @Test
    fun navBackActivityPressed(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.button_next_activity)).perform(click())

        //method 1
        //onView(withId(R.id.button_back)).perform(click())

        //method 2
        pressBack()

        onView(withId(R.id.main)).check(matches(isDisplayed()))

    }

}