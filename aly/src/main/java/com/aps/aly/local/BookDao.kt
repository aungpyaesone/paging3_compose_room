package com.aps.aly.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.aps.aly.data.BookX
import kotlinx.coroutines.flow.Flow


@Dao
interface BookDao {

    @Upsert
    suspend fun upsertBook(bookX: BookX)

    @Query("select * from book")
    fun getAllBook() : Flow<List<BookX>>
}