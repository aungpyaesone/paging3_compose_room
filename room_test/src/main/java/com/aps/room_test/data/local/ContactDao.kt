package com.aps.room_test.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("select * from contact order by firstName ASC")
    fun getContactOrderByFirstName(): Flow<List<Contact>>

    @Query("select * from contact order by lastName ASC")
    fun getContactOrderByLastName(): Flow<List<Contact>>

    @Query("select * from contact order by phoneNumber ASC")
    fun getContactOrderByPhoneNumber(): Flow<List<Contact>>






}