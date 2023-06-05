package com.aps.aly.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aps.aly.data.BookX
import com.aps.aly.local.BookDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dao: BookDao
): ViewModel(){


    val bookData = dao.getAllBook().stateIn(viewModelScope, SharingStarted.WhileSubscribed(),
        emptyList()
    )
}

data class HomeStateUi(
    val bookList: List<BookX> = emptyList(),
    val loading: Boolean = false,
)