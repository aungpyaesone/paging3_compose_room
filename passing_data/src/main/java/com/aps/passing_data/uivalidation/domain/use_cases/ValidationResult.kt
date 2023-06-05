package com.aps.passing_data.uivalidation.domain.use_cases

data class ValidationResult(
    var isSuccessful : Boolean,
    var errorMessage: String = ""
)
