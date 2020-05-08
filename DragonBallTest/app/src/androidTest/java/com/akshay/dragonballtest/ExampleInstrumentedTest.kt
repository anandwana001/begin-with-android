package com.akshay.dragonballtest

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private val main = IntentsTestRule(MainActivity::class.java, false, false)

    @Test
    fun testValidateButtomDisplayed() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        main.launchActivity(Intent(appContext, MainActivity::class.java))
        onView(withId(R.id.validateBtn)).check(matches(isDisplayed()))
    }

}
