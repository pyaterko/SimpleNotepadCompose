package com.owl_laugh_at_wasted_time.simplenotepadcompose.di

import android.content.Context
import androidx.room.Room
import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.database.NotePadDatabase
import com.owl_laugh_at_wasted_time.simplenotepadcompose.until.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {


    @Singleton
    @Provides
    fun provideDataBase(
        @ApplicationContext context: Context
    ) =
        Room.databaseBuilder(context, NotePadDatabase::class.java, Constants.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideShopListDao(database: NotePadDatabase) = database.shoppingDao()

    @Singleton
    @Provides
    fun provideToDoDao(database: NotePadDatabase) = database.toDoDao()

    @Singleton
    @Provides
    fun provideNoteDao(database: NotePadDatabase) = database.noteDao()


}