package com.jorgesanaguaray.prepopulatedatabase.home.di

import com.jorgesanaguaray.prepopulatedatabase.core.local.UserDao
import com.jorgesanaguaray.prepopulatedatabase.home.data.HomeRepositoryImpl
import com.jorgesanaguaray.prepopulatedatabase.home.domain.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Jorge Sanaguaray
 */

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Singleton
    @Provides
    fun provideRepository(userDao: UserDao): HomeRepository {
        return HomeRepositoryImpl(userDao)
    }

}