package com.plcoding.composepaging3caching.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface BeerDao {

    @Upsert
    suspend fun upsertAll(entities: List<BeerEntity>)

    @Query("select * from beerentity")
    fun pagingSource() : PagingSource<Int,BeerEntity>

    @Query("delete from beerentity")
    suspend fun clearAll()
}