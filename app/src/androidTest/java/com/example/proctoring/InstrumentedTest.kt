package com.example.proctoring

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
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
class InstrumentedTest {


    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    companion object {
        @BeforeClass
        @JvmStatic
        fun init() {
            Intents.init()
        }
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.proctoring", appContext.packageName)
    }

    @Test
    fun testStartButton() {
        onView(withId(R.id.bStart))
            .check(matches(isDisplayed()))
            .check(matches(isClickable()))
            .perform(click())
        intended(hasComponent(InfoActivity::class.java.name))

        onView(withId(R.id.infoButton))
            .check(matches(isDisplayed()))
            .check(matches(isClickable()))
            .perform(click())
        intended(hasComponent(ScannerActivity::class.java.name))
//
//        val intent = Intent(, CheckFaceActivity::class.java)
//        startActivity(intent)
    }

    @Test
    fun testAboutButton() {
        onView(withId(R.id.aboutButton))
            .check(matches(isDisplayed()))
            .check(matches(isClickable()))
            .perform(click())
        intended(hasComponent(AboutActivity::class.java.name))
    }


//    @Rule
//    @JvmField
//    var mActivityTestRule = ActivityTestRule(InfoActivity::class.java)



//    @Test
//    fun testCheckQRButton() {
//
////        val intent = Intent(context, InfoActivity::class.java)
////        context.startActivity(intent)
//
//        onView(withId(R.id.infoButton))
//            .check(matches(isDisplayed()))
//            .check(matches(isClickable()))
//            .perform(click())
//        intended(hasComponent(ScannerActivity::class.java.name))
//    }


}