package com.aps.passing_data.uivalidation.domain.use_cases

class ValidateTerms {

    fun execute(acceptTerms: Boolean) : ValidationResult{
        if(!acceptTerms){
            return ValidationResult(
                isSuccessful = false,
                errorMessage = "Please accept the term"
            )
        }

        return ValidationResult(
            isSuccessful = true
        )
    }
}