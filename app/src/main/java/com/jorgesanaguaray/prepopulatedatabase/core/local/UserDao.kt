package com.jorgesanaguaray.prepopulatedatabase.core.local

import androidx.room.Dao
import androidx.room.Query

/**
 * Created by Jorge Sanaguaray
 */

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    suspend fun getUsers(): List<UserEntity>

}