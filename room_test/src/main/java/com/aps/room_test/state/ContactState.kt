package com.aps.room_test.state

import com.aps.room_test.data.local.Contact
import com.aps.room_test.event.SortType

data class ContactState(
    val contacts: List<Contact> = emptyList(),
    val firstName:String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val isAddingContact: Boolean = false,
    val sortType: SortType = SortType.FIRST_NAME
)