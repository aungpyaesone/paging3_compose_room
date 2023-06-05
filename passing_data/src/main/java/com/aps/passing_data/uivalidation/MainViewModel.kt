package com.aps.passing_data.uivalidation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aps.passing_data.uivalidation.domain.use_cases.ValidateEmail
import com.aps.passing_data.uivalidation.domain.use_cases.ValidatePassword
import com.aps.passing_data.uivalidation.domain.use_cases.ValidateRepeatedPassword
import com.aps.passing_data.uivalidation.domain.use_cases.ValidateTerms
import com.aps.passing_data.uivalidation.presentation.RegistrationFormEvent
import com.aps.passing_data.uivalidation.presentation.RegistrationFormState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val validateEmail: ValidateEmail = ValidateEmail(),
    private val validatePassword: ValidatePassword = ValidatePassword(),
    private val validateRepeatedPassword: ValidateRepeatedPassword = ValidateRepeatedPassword(),
    private val validateTerms: ValidateTerms = ValidateTerms()
) : ViewModel() {

    var state by mutableStateOf(RegistrationFormState())

    private val validationEventChannel  = Channel<ValidationEvent>()
    val validationEvent = validationEventChannel.receiveAsFlow()

    fun onEvent(event: RegistrationFormEvent){
        when(event){
            is RegistrationFormEvent.AcceptTerm -> state = state.copy(acceptTerms = event.isAccepted)
            is RegistrationFormEvent.EmailChanged -> state = state.copy(email = event.email)
            is RegistrationFormEvent.PasswordChange -> state = state.copy(password = event.password)
            is RegistrationFormEvent.RepeatedPasswordChange -> state = state.copy(repeatedPassword = event.repeatedPassword)
            RegistrationFormEvent.Submit -> submitData()
        }
    }

    private fun submitData() {
        val emailResult = validateEmail.execute(state.email)
        val passwordResult = validatePassword.execute(state.password)
        val repeatedPasswordResult = validateRepeatedPassword.execute(state.password,state.repeatedPassword)
        val termResult = validateTerms.execute(state.acceptTerms)

        val hasError = listOf(
            emailResult,
            passwordResult,
            repeatedPasswordResult,
            termResult
        ).any { !it.isSuccessful }

        if(hasError){
            state = state.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage,
                repeatedPasswordError = repeatedPasswordResult.errorMessage,
                termsError = termResult.errorMessage
            )
            return
        }

        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    sealed class ValidationEvent{
        object Success : ValidationEvent()
    }
}