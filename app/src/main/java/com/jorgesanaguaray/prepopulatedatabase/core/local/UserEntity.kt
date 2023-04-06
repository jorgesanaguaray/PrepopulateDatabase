package com.jorgesanaguaray.prepopulatedatabase.core.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Jorge Sanaguaray
 */

@Entity(tableName = "user_table")
data class UserEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val username: String,
    val name: String,
    val profilePicture: String

)