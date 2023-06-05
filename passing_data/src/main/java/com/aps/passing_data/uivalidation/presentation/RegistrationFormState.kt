package com.aps.passing_data.uivalidation.presentation

data class RegistrationFormState(
    val email:String = "",
    val emailError: String? = "",
    val password: String = "",
    val passwordError: String? = null,
    val repeatedPassword: String = "",
    val repeatedPasswordError: String? = null,
    val acceptTerms: Boolean = false,
    val termsError: String? = null
)