package com.abhijeet.samplemvvm

import android.text.method.Touch.scrollTo
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.abhijeet.samplemvvm.view.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SampleMVVMTest {

    @Rule @JvmField
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkProgressBar() {
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
        Thread.sleep(5000)
    }

}