package com.aps.passing_data.uivalidation.domain.use_cases

import android.util.Patterns
import androidx.compose.ui.res.stringResource
import com.aps.passing_data.R
import java.util.regex.Pattern

class ValidateEmail {

    fun execute(email:String) : ValidationResult{
        if(email.isBlank()){
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "This email can't be blank"
            )
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "That not a valid email"
            )
        }

        return ValidationResult(
            isSuccessful = true
        )
    }
}