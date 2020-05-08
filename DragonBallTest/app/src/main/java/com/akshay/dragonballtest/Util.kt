package com.akshay.dragonballtest

import java.util.regex.Pattern

/**
 * Created by akshaynandwana on
 * 08, May, 2020
 **/
object Util {

    private val EMAIL_ADDRESS = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    fun validateEmail(email: String): Boolean {
        return when {
            !EMAIL_ADDRESS.matcher(email).matches() -> false
            else -> true
        }
    }
}