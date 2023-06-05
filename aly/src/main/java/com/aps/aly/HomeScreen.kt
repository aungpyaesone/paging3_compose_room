package com.aps.aly

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.aps.aly.data.BookX

@Composable
fun HomeScreen(
    state:List<BookX>
){
    LazyColumn{
        items(state){
            Text(text = it.title ?: "no data")
        }
    }
}