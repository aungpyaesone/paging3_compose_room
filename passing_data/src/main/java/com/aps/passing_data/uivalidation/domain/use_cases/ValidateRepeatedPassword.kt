package com.aps.passing_data.uivalidation.domain.use_cases

import android.util.Patterns

class ValidateRepeatedPassword {

    fun execute(password:String,repeatedPassword:String) : ValidationResult{
        if(password != repeatedPassword){
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "The password don't match"
            )
        }

        return ValidationResult(
            isSuccessful = true
        )
    }
}