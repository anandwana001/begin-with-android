package com.akshay.dragonballtest

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun checkEmailIsInCorrectFormat() {
        val email = "test@gmail.com"
        val result = Util.validateEmail(email)
        assertEquals(result, true)
    }

    @Test
    fun checkEmailIsIncorrect() {
        val email = "testgmail"
        val result = Util.validateEmail(email)
        assertEquals(result, false)
    }

}
