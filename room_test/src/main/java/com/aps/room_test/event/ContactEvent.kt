package com.aps.room_test.event

import com.aps.room_test.data.local.Contact

sealed interface ContactEvent{
    object SaveContact : ContactEvent
    data class SetFirstName(val firstName: String): ContactEvent
    data class SetLastName(val lastName: String): ContactEvent
    data class SetLPhoneNumber(val phoneNumber: String): ContactEvent

    object HideDialog : ContactEvent
    object ShowDialog : ContactEvent
    data class SortContacts(val sortType: SortType) : ContactEvent
    data class DeleteContacts(val contact: Contact) : ContactEvent
}