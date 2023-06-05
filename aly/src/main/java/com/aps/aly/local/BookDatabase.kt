package com.aps.aly.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aps.aly.data.BookX

@Database(entities = [BookX::class], version = 1)
abstract class BookDatabase : RoomDatabase(){
    abstract val dao : BookDao
}