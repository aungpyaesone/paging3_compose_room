package com.aps.room_test.di

import android.content.Context
import androidx.room.Room
import com.aps.room_test.data.local.ContactDao
import com.aps.room_test.data.local.ContactDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context:Context) : ContactDatabase{
        return Room.databaseBuilder(
            context,
            ContactDatabase::class.java,
            "beers.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(database: ContactDatabase): ContactDao{
        return database.dao
    }


}