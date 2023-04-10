package com.example.proctoring

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


//import kotlin.coroutines.jvm.internal.CompletedContinuation.context


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class InstrumentedTestPart4 {


    @get:Rule
    val activityRule = ActivityScenarioRule(GoodResultActivity::class.java)


    companion object {
        @BeforeClass
        @JvmStatic
        fun init() {
            Intents.init()
        }
    }

    @Test
    fun testGoodResultButton() {
        onView(withId(R.id.backButton2))
            .check(matches(isDisplayed()))
            .check(matches(isClickable()))
            .perform(click())
        intended(hasComponent(MainActivity::class.java.name))
    }




}