package com.jorgesanaguaray.prepopulatedatabase.home.domain

import com.jorgesanaguaray.prepopulatedatabase.core.item.User

/**
 * Created by Jorge Sanaguaray
 */

interface HomeRepository {

    suspend fun getUsers(): Result<List<User>>

}