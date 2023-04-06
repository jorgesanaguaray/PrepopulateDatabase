package com.jorgesanaguaray.prepopulatedatabase.home.data

import com.jorgesanaguaray.prepopulatedatabase.core.item.User
import com.jorgesanaguaray.prepopulatedatabase.core.local.UserDao
import com.jorgesanaguaray.prepopulatedatabase.core.mapper.toDomain
import com.jorgesanaguaray.prepopulatedatabase.home.domain.HomeRepository

/**
 * Created by Jorge Sanaguaray
 */

class HomeRepositoryImpl(private val userDao: UserDao) : HomeRepository {

    override suspend fun getUsers(): Result<List<User>> {

        return try {

            Result.success(userDao.getUsers().map { it.toDomain() })

        } catch (e: Exception) {

            Result.failure(e)

        }

    }

}