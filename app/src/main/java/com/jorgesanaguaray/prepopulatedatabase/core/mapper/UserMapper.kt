package com.jorgesanaguaray.prepopulatedatabase.core.mapper

import com.jorgesanaguaray.prepopulatedatabase.core.item.User
import com.jorgesanaguaray.prepopulatedatabase.core.local.UserEntity

/**
 * Created by Jorge Sanaguaray
 */

fun UserEntity.toDomain(): User {

    return User(username, name, profilePicture)

}