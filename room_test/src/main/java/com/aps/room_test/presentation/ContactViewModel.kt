package com.aps.room_test.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aps.room_test.data.local.Contact
import com.aps.room_test.data.local.ContactDao
import com.aps.room_test.event.ContactEvent
import com.aps.room_test.event.SortType
import com.aps.room_test.state.ContactState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class ContactViewModel @Inject constructor(
    private val dao: ContactDao
) : ViewModel(){

    private val _sortType = MutableStateFlow(SortType.FIRST_NAME)
    private val _state = MutableStateFlow(ContactState())
    private val _contacts: StateFlow<List<Contact>> = _sortType.flatMapLatest { sortType->
        when(sortType){
            SortType.FIRST_NAME -> dao.getContactOrderByFirstName()
            SortType.LAST_NAME -> dao.getContactOrderByLastName()
            SortType.PHONE_NUMBER -> dao.getContactOrderByPhoneNumber()
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    val state = combine(_state,_sortType,_contacts){state,sortType,contacts ->
        state.copy(contacts=contacts,sortType = sortType)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ContactState())


    fun onEvent(event:ContactEvent){
        when(event){
            is ContactEvent.DeleteContacts -> {
                viewModelScope.launch {
                    dao.deleteContact(event.contact)
                }
            }
            ContactEvent.HideDialog -> {
                _state.update {contact ->
                    contact.copy(isAddingContact = false)
                }
            }
            ContactEvent.SaveContact -> {
                val firstName = state.value.firstName
                val lastName = state.value.lastName
                val phoneNumber = state.value.phoneNumber
                if(firstName.isBlank() || lastName.isBlank() || phoneNumber.isBlank()){
                    return
                }

                val contact = Contact(
                    firstName = firstName,
                    lastName = lastName,
                    phoneNumber = phoneNumber
                )
                viewModelScope.launch {
                    dao.upsertContact(contact)
                }
                _state.update {
                    it.copy(isAddingContact = false,
                    firstName = "",
                    lastName = "",
                    phoneNumber = "")
                }
            }
            is ContactEvent.SetFirstName -> {
                _state.update {
                    it.copy(firstName = event.firstName)
                }
            }
            is ContactEvent.SetLPhoneNumber -> {
                _state.update {
                    it.copy(phoneNumber = event.phoneNumber)
                }
            }
            is ContactEvent.SetLastName -> {
                _state.update {
                    it.copy(lastName = event.lastName)
                }
            }
            ContactEvent.ShowDialog ->  _state.update {contact ->
                contact.copy(isAddingContact = true)
            }
            is ContactEvent.SortContacts -> {
                _sortType.value = event.sortType
            }
        }
    }
}