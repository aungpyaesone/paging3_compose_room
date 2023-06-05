package com.aps.passing_data.uivalidation.domain.use_cases

import android.util.Patterns

class ValidatePassword {

    fun execute(password:String) : ValidationResult{
        if(password.length<8){
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "This password needs to consist of at least 8 characters"
            )
        }

        val containsLetterAndDigits =  password.any { it.isLetter() } && password.any { it.isDigit() }
        if(!containsLetterAndDigits){
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "That password required letter and digit"
            )
        }

        return ValidationResult(
            isSuccessful = true
        )
    }
}