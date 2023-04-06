package com.jorgesanaguaray.prepopulatedatabase.core.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by Jorge Sanaguaray
 */

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

}