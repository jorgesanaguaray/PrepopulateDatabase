package com.jorgesanaguaray.prepopulatedatabase.core.di

import android.content.Context
import androidx.room.Room
import com.jorgesanaguaray.prepopulatedatabase.Constants.Companion.DATABASE_NAME
import com.jorgesanaguaray.prepopulatedatabase.core.local.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Jorge Sanaguaray
 */

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room
        .databaseBuilder(context, UserDatabase::class.java, DATABASE_NAME)
        .createFromAsset("UserDatabase.db")
        .build()

    @Singleton
    @Provides
    fun provideUserDao(userDatabase: UserDatabase) = userDatabase.getUserDao()

}