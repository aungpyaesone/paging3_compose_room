package com.aps.passing_data.uivalidation.domain.use_cases

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class ValidatePasswordTest {

    private lateinit var validPassword : ValidatePassword
    @Before
    fun setUp() {
        validPassword  = ValidatePassword()
    }

    @Test
    fun `Password is letter-only, return error`(){
        val result = validPassword.execute("12345678")
        assertEquals(result.isSuccessful,false)
    }
}