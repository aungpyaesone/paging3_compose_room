package com.aps.room_test

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aps.room_test.event.ContactEvent
import com.aps.room_test.event.SortType
import com.aps.room_test.state.ContactState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit,
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { onEvent(ContactEvent.ShowDialog) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Contact")
            }
        },
        modifier = Modifier.padding(16.dp)
    ) { paddingValues ->

        if(state.isAddingContact){
            AddContactDialog(state = state, onEvent = onEvent)
        }

        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SortType.values().forEach { sortType ->
                        Row(modifier = Modifier.clickable {
                            onEvent(ContactEvent.SortContacts(sortType))
                        }, verticalAlignment = CenterVertically) {
                            RadioButton(selected = state.sortType == sortType, onClick = {
                                onEvent(ContactEvent.SortContacts(sortType))
                            })
                            Text(text = sortType.name)
                        }
                    }
                }
            }
            items(state.contacts) { contact ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "${contact.firstName} ${contact.lastName}",
                            fontSize = 20.sp
                        )
                        Text(text = contact.phoneNumber)
                    }
                    IconButton(onClick = {
                        onEvent(ContactEvent.DeleteContacts(contact))
                    }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete contact"
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun AddContactDialog(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            onEvent(ContactEvent.HideDialog)
        },
        title = { Text(text = "Add Contact") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                TextField(
                    value = state.firstName,
                    onValueChange = { onEvent(ContactEvent.SetFirstName(it)) },
                    placeholder = { Text(text = "First Name")}
                )
                TextField(
                    value = state.lastName,
                    onValueChange = { onEvent(ContactEvent.SetLastName(it)) },
                    placeholder = { Text(text = "Last Name")})
                TextField(
                    value = state.phoneNumber,
                    onValueChange = { onEvent(ContactEvent.SetLPhoneNumber(it)) },
                    placeholder = { Text(text = "Phone Number")})
            }
        },
        buttons = {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                Button(onClick = {
                    onEvent(ContactEvent.SaveContact)
                }) {
                    Text(text = "Save")
                }
            }
        }
    )
}