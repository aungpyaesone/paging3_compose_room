package com.aps.passing_data.uivalidation.presentation

sealed class RegistrationFormEvent{
    data class EmailChanged(val email:String) : RegistrationFormEvent()
    data class PasswordChange(val password:String) : RegistrationFormEvent()
    data class RepeatedPasswordChange(val repeatedPassword:String) : RegistrationFormEvent()
    data class AcceptTerm(val isAccepted:Boolean) : RegistrationFormEvent()
    object Submit : RegistrationFormEvent()
}
