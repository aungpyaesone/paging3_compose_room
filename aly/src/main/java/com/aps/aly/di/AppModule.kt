package com.aps.aly.di

import android.content.Context
import androidx.room.Room
import com.aps.aly.local.BookDao
import com.aps.aly.local.BookDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        BookDatabase::class.java,
        "book-db"
    )
        .build()

    @Singleton
    @Provides
    fun provideDao(db: BookDatabase): BookDao {
        return db.dao
    }
}